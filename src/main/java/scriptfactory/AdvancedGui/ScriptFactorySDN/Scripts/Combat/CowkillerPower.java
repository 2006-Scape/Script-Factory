package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat;

import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;
import org.parabot.environment.scripts.Category;

public class CowkillerPower extends ScriptFactoryScript {
    public CowkillerPower() {
        super(
                "Power Cow killer",
                "Dark98 & Red Bracket",
                Category.COMBAT,
                1.0,
                "Kills Cows In Lumbridge  \n Can Be Started Anywhere",

                "IfNot In-Combat()\n" +
                        "If Entity-is-around(81,397,1767,1768)\n" +
                        "Interact-with-entity-by-ID(81,397,1767,1768,1)\n" +
                        "Sleep(600)\n" +
                        "Endif\n" +
                        "IfNot Entity-is-around(81,397,1767,1768)\n" +
                        "Run-subscript(Walktocows)\n" +
                        "Endif\n" +
                        "Endif\n",
                new String[]{"Walktocows"}
        );
    }
}
