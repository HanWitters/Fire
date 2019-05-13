package Han.Fire.impl;

import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

import static Han.Fire.Lit.*;

public class Traverse extends Task {
    @Override
    public boolean validate() {
        if(Players.getLocal().isMoving()) return false;
        return traverseToBank() || traverseToBegin();
    }
    @Override
    public int execute() {
        Movement.walkTo(traverseToBank() ? SELECTED_LOCATION.getBankPoint().getCenter().translate(Random.nextInt(-1,+1),Random.nextInt(-1,+1)) : SELECTED_LOCATION.getBeginPoint().getCenter().translate(Random.nextInt(-1,+1),Random.nextInt(-1,+1)));
        return 300;
    }
    private boolean traverseToBank(){
        return Inventory.getCount(SELECTED_LOG_ID.getLogName()) == 0 && !SELECTED_LOCATION.getBankPoint().contains(Players.getLocal());
    }
    private boolean traverseToBegin(){
        return Inventory.contains(SELECTED_LOG_ID.getLogName()) && Inventory.contains(BOX_ID) && !SELECTED_LOCATION.getFirePoint().contains(Players.getLocal());
    }
}
