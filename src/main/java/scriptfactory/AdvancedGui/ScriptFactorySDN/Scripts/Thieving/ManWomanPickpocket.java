package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Thieving;

import org.parabot.environment.scripts.Category;
import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class ManWomanPickpocket extends ScriptFactoryScript {
    public ManWomanPickpocket() {
        super(
                "Pickpocket (Man/Woman)",
                "Dark98",
                Category.THIEVING,
                1.0,
                "Pickpockets Men/Women \n Start Near Man/Woman",
                "If Entity-is-around(1,2,3,4,5,6)\n" +
                        "Interact-with-entity-by-ID(1,2,3,4,5,6,3)\n" +
                        "Endif",
                new String[]{}
        );
    }
}
