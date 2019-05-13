package Han.Fire.impl;


import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;

import java.util.Arrays;


public class MoveOff extends Task {
    @Override
    public boolean validate() {
        String[] blockingYourPath = {"Flowers", "Box trap", "Bird snare", "Fire", "Daisies", "Fern", "Stones", "Thistle", "Fire"};
        if(Players.getLocal().isAnimating()) return false;
        if(Players.getLocal().isMoving()) return false;
        SceneObject danger = SceneObjects.getFirstAt(Players.getLocal().getPosition());
        return danger != null && Arrays.asList(blockingYourPath).contains(danger.getName());
    }

    @Override
    public int execute() {
        System.out.println("Moving off hot fire!");
        Movement.walkTo(Players.getLocal().getPosition().translate(0,+1));
        return 200;
    }
}
