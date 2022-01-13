package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat;

import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;
import org.parabot.environment.scripts.Category;

public class CowkillerPrayer extends ScriptFactoryScript {
    public CowkillerPrayer() {
        super(
                "Cow killer (with bone burying)",
                "Red Bracket/Dark98",
                Category.COMBAT,
                1.3,
                "Kills Cows In Lumbridge And Burys Bones \n Start In CowField Or Lummy Castle Courtyard",
                "IfNot Entity-is-around(81,397,1767,1768)\n" +
                        "Run-subscript(Walktocows)\n" +
                        "Endif\n" +
                        "If Entity-is-around(81,397,1767,1768)\n" +
                        "Sleep(600)\n" +
                        "Take-Ground-item(526)\n" +
                        "Sleep(900)\n" +
                        "If Item-is-in-Inventory(527)\n" +
                        "Inventory-item-interact(527,2)\n" +
                        "Endif\n" +
                        "Sleep(600)\n" +
                        "IfNot In-Combat()\n" +
                        "Interact-with-entity-by-ID(81,397,1767,1768,1)\n" +
                        "Endif\n" +
                        "Endif\n",
                new String[]{"Walktocows"}
        );
    }
}
