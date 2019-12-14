package scriptfactory.Strategies;


import org.rev317.min.api.methods.Game;
import scriptfactory.Actions.Action;
import org.parabot.environment.scripts.framework.Strategy;
import scriptfactory.VarsMethods;

import java.util.ArrayList;

/**
 * Created by SRH on 1/15/2018.
 */
public class RunLoop implements Strategy {

    private ActionExecutor actionExecutor;
    private LoginHandler loginHandler = new LoginHandler();

    public RunLoop(ArrayList<Action> actions)
    {
        actionExecutor = new ActionExecutor(actions);
    }

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public void execute() {
        VarsMethods.calculateGainedXP();
        if(!Game.isLoggedIn() || Game.getOpenBackDialogId() == 15812){
            loginHandler.execute();
        }
        actionExecutor.execute();
    }

}
