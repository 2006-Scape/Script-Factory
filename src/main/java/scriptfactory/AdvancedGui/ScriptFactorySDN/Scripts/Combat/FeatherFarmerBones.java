package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat;

import org.parabot.environment.scripts.Category;
import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class FeatherFarmerBones extends ScriptFactoryScript {
    public FeatherFarmerBones() {
        super(
                "Feather Farmer (with bone burying)",
                "Dark98",
                Category.COMBAT,
                1.0,
                "Kills Chickens, Farms The Feathers & Buries The Bones \n Start Near Chickens",
                "IfNot In-Combat()\n" +
                        "If Entity-is-around(41)\n" +
                        "If Item-is-on-Ground(526)\n" +
                        "Take-Ground-item(526)\n" +
                        "Take-Ground-item(314)\n" +
                        "Endif\n" +
                        "If Item-is-in-Inventory(527,1)\n" +
                        "Inventory-item-interact(527,2)\n" +
                        "Endif\n" +
                        "Interact-with-entity-by-ID(41,1)\n" +
                        "Sleep(600)\n" +
                        "Endif\n" +
                        "Endif",
                new String[]{}
        );
    }
}
