package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat;

import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;
import org.parabot.environment.scripts.Category;

public class CowkillerBanking extends ScriptFactoryScript {
    public CowkillerBanking() {
        super(
                "Cow killer (with banking)",
                "Before",
                Category.COMBAT,
                1.1,
                "Kills Cows In Lumbridge And Banks In The Castle \n Set Tick Speed To 1000 For Best Results \n Can Be Started Anywhere",
                "If Inventory-slots-used(28)\n" +
                        "Run-subscript(Openlummybank)\n" +
                        "Bank-all-except-IDs()\n" +
                        "Run-subscript(Walktocows)\n" +
                        "Endif\n" +
                        "IfNot In-Combat()\n" +
                        "If Entity-is-around(81,397,1767,1768)\n" +
                        "Take-Ground-item(2132)\n" +
                        "Take-Ground-item(526)\n" +
                        "Take-Ground-item(1739)\n" +
                        "If Inventory-slots-used(28)\n" +
                        "Run-subscript(Openlummybank)\n" +
                        "Bank-all-except-IDs()\n" +
                        "Run-subscript(Walktocows)\n" +
                        "Endif\n" +
                        "Interact-with-entity-by-ID(81,397,1767,1768,1)\n" +
                        "Endif\n" +
                        "IfNot Entity-is-around(81,397,1767,1768)\n" +
                        "If Inventory-slots-used(28)\n" +
                        "Run-subscript(Openlummybank)\n" +
                        "Bank-all-except-IDs()\n" +
                        "Endif\n" +
                        "Run-subscript(Walktocows)\n" +
                        "Endif\n" +
                        "Endif\n",
                new String[]{"Walktocows", "Openlummybank"}
        );
    }
}
