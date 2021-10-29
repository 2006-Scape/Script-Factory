package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Deps;

import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class Openlummybank extends ScriptFactoryScript
{
    public Openlummybank() {
        super(
                "Openlummybank",
                "Before",
                "Dependency",
                1.1,
                "Opens the bank in lumbridge castle from anywhere",
                "Type(::stuck,1)\n" +
                        "Sleep(1500)\n" +
                        "Interact-with-entity-by-location(3217,3218,1)\n" +
                        "Interact-with-entity-by-location(3215,3211,1)\n" +
                        "Interact-with-entity-by-location(3204,3207,1)\n" +
                        "Sleep(12000)\n" +
                        "Interact-with-entity-by-location(3204,3207,1)\n" +
                        "Interact-with-entity-by-location(3204,3207,2)\n" +
                        "Interact-with-entity-by-ID(494,3)\n" +
                        "Sleep(6000)\n",
                new String[]{}
        );
    }
}
