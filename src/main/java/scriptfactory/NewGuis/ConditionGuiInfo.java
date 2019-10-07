package scriptfactory.NewGuis;


import scriptfactory.Actions.Action;
import scriptfactory.Consumer;

import java.util.ArrayList;

/**
 * Created by SRH on 1/9/2018.
 */
public class ConditionGuiInfo extends NewStatementGUI {
    public ConditionGuiInfo(ArrayList<Action> actionList, Consumer<Integer> updateTextfield) {
        String[] actionTypes = new String[]{"Item is in Inventory", "Inventory slots used", "Item is on Ground", "Entity is around", "Hitpoints is below", "In Combat", "Within x Tiles of Coords", "Detect Animation ID"};
        Descriptions[] setDescs = {
                new Descriptions("Item to detect (eg. 4296 = bones)", "Number of them to detect (blank = 1)"),
                new Descriptions("Inventory slots greater than or equal to (eg. \"28\" detects a full inventory)"),
                new Descriptions("Item to detect (eg. 314 = feathers)"),
                new Descriptions("Entity to detect (eg. \"81,397,1767,1768\" detects cows)"),
                new Descriptions("Below health # (eg. 10)"),
                new Descriptions(),
                new Descriptions("Tiles to be within (i.e. 6)", "x Coordinate", "y Coordinate"),
                new Descriptions("Animation ID to detect", "ms to look for animation (recommended 600+)", "\"1\" to look for any ID other than the one specified (use this with anim ID -1 to detect any animation)"),
        };

        initGui("Add new condition", actionList, updateTextfield, actionTypes, setDescs);
    }

}
