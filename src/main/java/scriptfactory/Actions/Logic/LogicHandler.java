package scriptfactory.Actions.Logic;

import org.parabot.environment.api.utils.Filter;
import org.rev317.min.api.wrappers.GroundItem;
import org.rev317.min.api.wrappers.Tile;
import scriptfactory.Actions.Action;
import org.rev317.min.api.methods.*;

import java.util.ArrayList;

import static scriptfactory.VarsMethods.log;
import static scriptfactory.VarsMethods.toPintArray;

public class LogicHandler {
    public boolean determineIf(final Action a) {
        switch (a.getMethod().replaceAll("-", " "))
        {
            case "Item is in Inventory":
                return Inventory.getCount(a.getParam(0)) >= (a.getParamAsString(1).equals("") ? 0 : a.getParam(1));
            case "Inventory slots used":
                return Inventory.getCount() >= a.getParam(0);
            case "Item is on Ground":
                return GroundItems.getGroundItems(new Filter<GroundItem>() {
                    @Override
                    public boolean accept(GroundItem o) {
                        return o.getId() == a.getParam(0);
                    }
                }).length > 0;
            case "Entity is around":
                ArrayList<Integer> ids = new ArrayList<>();
                for (int i = 0; i < a.getParamCount(); i++)
                    ids.add(a.getParam(i));
                return Npcs.getClosest(toPintArray(ids)) != null ||
                        SceneObjects.getClosest(toPintArray(ids)) != null;
            case "Hitpoints is below":
                return Players.getMyPlayer().getHealth() < a.getParam(0);
            case "In Combat":
                return Players.getMyPlayer().isInCombat();
            case "Within x Tiles of Coords":
                return new Tile(a.getParam(1), a.getParam(2)).distanceTo() < a.getParam(0);
            default:
                log("Error: Unimplemented conditional: " + a.getAction());
        }
        return false;
    }

    public String determineIfAsBoolString(Action a)
    {
        return determineIf(a) ? "True" : "False";
    }

    public String determineIfNotAsBoolString(Action a) {
        return determineIfAsBoolString(a).equals("True") ? "False" : "True";
    }
}
