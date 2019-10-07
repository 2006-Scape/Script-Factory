package scriptfactory.Strategies;

import scriptfactory.Actions.Action;
import scriptfactory.Actions.ActionHandler;
import scriptfactory.Actions.Logic.Endif;
import scriptfactory.Actions.Logic.If;
import scriptfactory.Actions.Logic.IfNot;
import scriptfactory.Actions.Logic.LogicHandler;
import scriptfactory.VarsMethods;
import org.parabot.environment.api.utils.Time;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import static scriptfactory.VarsMethods.*;

public class ActionExecutor {
    private ArrayList<Action> actions;
    private ActionHandler actionHandler;
    private LogicHandler logicHandler;
    private Stack ifStack;

    private int lineIndex;

    public ActionExecutor(ArrayList<Action> actions) {
        this.actions = actions;

        actionHandler = new ActionHandler();
        logicHandler = new LogicHandler();
        ifStack = new Stack();
        ifStack.push("True");

        lineIndex = 0;
    }

    public void execute()
    {
        Action line = actions.get(lineIndex);
        lineIndex = ++lineIndex == actions.size() ? 0 : lineIndex;

        if (line instanceof Endif)
        {
            ifStack.pop();
            return;
        } else if ((line instanceof If || line instanceof IfNot) && ifStack.peek().equals("False")) {
            ifStack.push("False");
            return;
        }

        if (ifStack.peek().equals("True"))
        {
            VarsMethods.currentAction = line.getAction();

            try {
                executeLine(line);
            } catch (NumberFormatException notFilledIn) {
                log("Error on line " + line);
                log("Make sure you fill in all numeric values properly! Numbers only! (No spaces!!)");
            }

            Time.sleep(VarsMethods.tickSpeed);
        }

        Time.sleep(50);
    }

    private void executeLine(Action action) {
        if (action instanceof If)
        {
            ifStack.push(logicHandler.determineIfAsBoolString(action));
        }
        else if (action instanceof IfNot)
        {
            ifStack.push(logicHandler.determineIfNotAsBoolString(action));
        }
        else
        {
            switch (action.getMethod().replace("-", " "))
            {
                case "Interact with entity by ID":
                    actionHandler.handleInteractWith(action);
                    break;
                case "Interact with entity by location":
                    actionHandler.handleInteractWithByLoc(action);
                    break;
                case "Take Ground item":
                    actionHandler.handleGroundItemInteract(action);
                    break;
                case "Inventory item interact":
                    actionHandler.inventoryItemInteract(action);
                    break;
                case "Use item on":
                    actionHandler.useItemOn(action);
                    break;
                case "Type":
                    actionHandler.type(action);
                    break;
                case "Click xy":
                    actionHandler.clickxy(action);
                    break;
                case "Sleep":
                    actionHandler.sleep(action);
                    break;
                case "Send raw Action":
                    actionHandler.sendRawAction(action);
                    break;
                case "Walk to":
                    actionHandler.walkTo(action);
                    break;
                case "Run subscript":
                    insertSubscript(action, actions, action.getParamAsString(0));
                    lineIndex = --lineIndex == -1 ? actions.size()-1 : lineIndex; //Rerun the last line, which now contains start of subscript
                    break;
                case "Bank all except IDs":
                    actionHandler.bankAllExcept(action);
                    break;
                case "Change Tick Speed":
                    VarsMethods.tickSpeed = action.getParam(0);
                    break;
                default:
                    log("Error: Unimplemented action: " + action.getAction());
            }
        }
    }

    private void insertSubscript(Action action, ArrayList<Action> actions, String path) {
        int actionIndex = -1;
        //Find where to insert the subscript
        for (int i = 0; i < actions.size(); i++)
            if (actions.get(i).equals(action))
                actionIndex = i;

        //Load subscript into array
        ArrayList<Action> subscriptActions = new ArrayList<>();
        File subscriptFile = new File(DEFAULT_DIR + FSEP + path);
        if (subscriptFile.exists())
            loadscript(subscriptActions, subscriptFile);
        else
            loadscript(subscriptActions, new File(DEFAULT_DIR + FSEP + "dependencies" + FSEP + path));

        //Insert subscript array into original script array
        actions.remove(actionIndex);
        for (int i = 0; i < subscriptActions.size(); i++) {
            actions.add(actionIndex + i, subscriptActions.get(i));
        }
    }
}
