package scriptfactory.AdvancedGui.ScriptFactorySDN;

import org.parabot.core.desc.ScriptDescription;
import org.parabot.environment.scripts.Category;
import scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat.CowkillerBones;
import scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Combat.CowkillerPower;
import scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Deps.Walktocows;
import scriptfactory.AdvancedGui.ScriptFactorySDN.Scripts.Thieving.ArdyCakesBanking;

public class ScriptFactoryScript extends ScriptDescription {

    String code;
    String[] dependencies;

    public ScriptFactoryScript(String scriptName, String author, Category category, double version, String description, String code, String[] dependencies) {
        super(scriptName, author, String.valueOf(category), version, description, new String[]{"Any"});
        this.code = code;
        this.dependencies = dependencies;
    }

    public ScriptFactoryScript(String scriptName, String author, String category, double version, String description, String code, String[] dependencies) {
        super(scriptName, author, category, version, description, new String[]{"Any"});
        this.code = code;
        this.dependencies = dependencies;
    }

    public static ScriptFactoryScript[] getDescriptions() {
        return new ScriptFactoryScript[]{
                //Scripts
                new ArdyCakesBanking(), //TODO Untested?
                new CowkillerBones(),
                new CowkillerPower(),

                //Deps
                //new Openlummybank(),
                new Walktocows(),
        };
    }

    public static ScriptFactoryScript getScriptByName(String name)
    {
        for (ScriptFactoryScript s : getDescriptions())
            if (s.scriptName.equals(name))
                return s;

        return null;
    }
}
