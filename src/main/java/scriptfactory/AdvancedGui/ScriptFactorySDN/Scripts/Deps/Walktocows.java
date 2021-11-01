package scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Deps;

import scriptfactory.AdvancedGui.ScriptFactorySDN.ScriptFactoryScript;

public class Walktocows extends ScriptFactoryScript
{
    public Walktocows() {
        super(
                "Walktocows",
                "Red Bracket",
                "Dependency",
                1.0,
                "Walks to the cows in lumbridge from anywhere",
                "IfNot Entity-is-around(81,397,1767,1768)\n" +
                        "Type(::stuck,1)\n" +
                        "Sleep(1500)\n" +
                        "Walk-to(3241,3226,14000)\n" +
                        "Walk-to(3259,3233,14000)\n" +
                        "Walk-to(3256,3250,14000)\n" +
                        "Walk-to(3252,3266,14000)\n" +
                        "Interact-with-entity-by-location(3253,3266,1)\n" +
                        "Walk-to(3258,3268,5000)\n" +
                        "Endif\n",
                new String[]{}
        );
    }
}
