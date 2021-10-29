package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Thieving;

import org.parabot.environment.scripts.Category;
import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class ArdyCakesBanking extends ScriptFactoryScript {
    public ArdyCakesBanking() {
        super(
                "ArdyCakes (with banking)",
                "Maui",
                Category.THIEVING,
                1.0,
                "Steals cakes in Ardy \n Start Next To Ardy Cake Stalls",
                "If Inventory-slots-used(28)\n" +
                        "IfNot Entity-is-around(494)\n" +
                        "Walk-to(2655,3286,35000)\n" +
                        "Endif\n" +
                        "Interact-with-entity-by-ID(2213,2)\n" +
                        "Bank-all-except-IDs()\n" +
                        "Walk-to(2669,3310,35000)\n" +
                        "Endif\n" +
                        "IfNot Inventory-slots-used(28)\n" +
                        "Interact-with-entity-by-location(2667,3310)\n",
                new String[]{}
        );
    }
}
