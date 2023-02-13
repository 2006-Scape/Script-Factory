package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat;

import org.parabot.environment.scripts.Category;
import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class CowkillerPower extends ScriptFactoryScript {
    public CowkillerPower() {
        super(
                "Power Cow killer",
                "Dark98",
                Category.COMBAT,
                1.0,
                "Kills Cows In Lumbridge  \n Start In Lummy Cow Field.",

                "IfNot In-Combat()\n" +
                        "If Entity-is-around(81,397,1767,1768)\n" +
                        "Interact-with-entity-by-ID(81,397,1767,1768,1)\n" +
                        "Sleep(2400)\n" +
                        "Endif\n" +
                        "Endif",
                new String[]{}
        );
    }
}
