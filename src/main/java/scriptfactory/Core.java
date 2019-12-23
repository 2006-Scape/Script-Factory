package scriptfactory;

import org.parabot.environment.api.utils.Timer;
import scriptfactory.GUI.GUI;
import scriptfactory.Strategies.RunLoop;
import scriptfactory.Actions.Action;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static scriptfactory.VarsMethods.log;

/**
 * Created by SRH on 1/9/2018.
 * Welcome to AIO AIO - ScriptFactory. Make your own scripts!
 */

@ScriptManifest(author = "Before", name = "Script Factory 1.15", category = Category.OTHER, version = 1.15, description = "Create your own scripts!", servers = "All")
public class Core extends Script implements Paintable {

    private ArrayList<Action> actions = new ArrayList<>();
    private ArrayList<Strategy> strategies = new ArrayList<>();

    private GUI gui;
    public Timer SCRIPT_TIMER;

    @Override
    public boolean onExecute() {
        File directory = new File(VarsMethods.DEFAULT_DIR + VarsMethods.FSEP + "dependencies");
        if (!directory.exists())
            directory.mkdirs();
        
        gui = new GUI(actions);

        while (gui.isShowing())
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        if (!gui.scriptStarted)
        {
            gui.killAllGuis();
            VarsMethods.savescript(actions, new File(VarsMethods.CACHED_LOC));
            return false;
        }
        VarsMethods.calculateBaseXP();
        SCRIPT_TIMER = new Timer();

        strategies.add(new RunLoop(actions));
        provide(strategies);

        return true;
    }

    @Override
    public void paint(Graphics graphics) {
        try {
            Graphics2D g = (Graphics2D) graphics;
            Color c2 = new Color(44, 62, 80, 160);
            g.setColor(c2);
            g.setBackground(c2);
            g.fillRect(4, 232, 160, 20);

            Color c = new Color(44, 62, 80, 80);
            g.setColor(c);
            g.setBackground(c);
            g.fillRect(4, 252, 160, 85);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString("Script Factory", 9, 247);
            g.setFont(new Font("Arial", Font.BOLD, 11));
            if (SCRIPT_TIMER == null) {
                g.drawString("Awaiting Start:", 9, 270);
                return;
            }
            g.drawString("Currently Executing:", 9, 270);
            g.drawString(VarsMethods.currentAction, 9, 290);
            g.drawString("EXP(P/H): " + VarsMethods.formatNumber((int) VarsMethods.gainedXP) + "(" + VarsMethods.formatNumber(SCRIPT_TIMER.getPerHour(VarsMethods.gainedXP)) + ")", 9, 310);
            g.drawString("Runtime: " + SCRIPT_TIMER.toString(), 9, 330);
        } catch (Exception e) {
            log("Paint Error");
        }
    }
}
