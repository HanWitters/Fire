package Han.Fire.impl;

import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

import static Han.Fire.Lit.*;


public class Banking extends Task {
    @Override
    public boolean validate() {
        if(Inventory.contains(SELECTED_LOG_ID.getLogName())) {return false;}
        if(SELECTED_LOG_ID == null || SELECTED_LOCATION == null) {return false;}
    return SELECTED_LOCATION.getBankPoint().contains(Players.getLocal());
    }

    @Override
    public int execute() {

        if (!Bank.isOpen()){
            Bank.open();
            if (!Inventory.contains(BOX_ID)){
                System.out.println("Grabbing Tinderbox");
                Bank.withdraw(BOX_ID,1);
            }
            if (!Inventory.contains(SELECTED_LOG_ID.getLogName())){
                System.out.println("Grabbing logs");
                Bank.withdraw(SELECTED_LOG_ID.getLogName(),27);
            }
            if(Inventory.contains(BOX_ID)&& Inventory.contains(SELECTED_LOG_ID.getLogName())) {
                System.out.println("Closing Bank");
                Bank.close();
            }
        }
        return 100;
    }
}
