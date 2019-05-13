package Han.Fire.impl;

import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

import static Han.Fire.Lit.*;


public class Firemaking extends Task {
    private static final String USE_ACTION = "Use";
    @Override
    public boolean validate() {
        if(!Inventory.contains(SELECTED_LOG_ID.getLogName())) return false;
        if(!Inventory.contains(item -> item.getName().equals("Tinderbox"))) return false;
        if(Players.getLocal().isAnimating()) return false;
        if(Players.getLocal().isMoving()) return false;
        return SELECTED_LOCATION.getFirePoint().contains(Players.getLocal());
    }

    @Override
    public int execute() {
        if (!Players.getLocal().isAnimating() && !Players.getLocal().isMoving()) {
            if(Inventory.getFirst(BOX_ID).interact(USE_ACTION)) {
                if(Inventory.getFirst(SELECTED_LOG_ID.getLogName()).interact(USE_ACTION)) {
                    Time.sleepUntil(()->Players.getLocal().isMoving(),1500);
                }
            }
        }
        return 100;
    }
}
