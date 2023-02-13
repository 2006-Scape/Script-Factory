package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat;

import org.parabot.environment.scripts.Category;
import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class CowkillerBones extends ScriptFactoryScript {
    public CowkillerBones() {
        super(
                "Cow killer (with bone burying)",
                "Dark98",
                Category.COMBAT,
                1.0,
                "Kills Cows And Buries The Bones \n Start Near Cows.",
                "IfNot In-Combat()\n" +
                        "If Entity-is-around(81,397,1767,1768)\n" +
                        "Take-Ground-item(526)\n" +
                        "Sleep(600)\n" +
                        "If Item-is-in-Inventory(527,1)\n" +
                        "Inventory-item-interact(527,2)\n" +
                        "Endif\n" +
                        "Interact-with-entity-by-ID(81,397,1767,1768,1)\n" +
                        "Sleep(600)\n" +
                        "Endif\n" +
                        "Endif",
                new String[]{}
        );
    }
}
