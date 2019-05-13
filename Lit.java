package Han.Fire;

import Han.Fire.data.Locations;
import Han.Fire.data.Logs;
import Han.Fire.impl.Banking;
import Han.Fire.impl.Firemaking;
import Han.Fire.impl.MoveOff;
import Han.Fire.impl.Traverse;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;



@ScriptMeta(developer = "Han", desc = "It's lit, fam", name = "Lit", version = 1)
public class Lit extends TaskScript {

    private static final Task[] TASKS = {new MoveOff(),new Banking(),new Firemaking(),new Traverse()};
    public static Logs SELECTED_LOG_ID;
    public static String BOX_ID = "Tinderbox";
    public static Locations SELECTED_LOCATION;

    @Override
    public void onStart() {
        new LitGUI().setVisible(true);
        submit(TASKS);
    }
}
