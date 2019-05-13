package Han.Fire.data;

import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;

public enum Logs {
    REGULAR("Logs", 1),
    OAK("Oak logs", 15),
    WILLOW("Willow logs", 30),
    MAPLE("Maple logs", 45),
    YEW("Yew logs", 60),
    MAGIC("Magic logs", 75);

    private final String logName;
    private final int requiredLevel;

    Logs(final String logName, final int requiredLevel) {
        this.logName = logName;
        this.requiredLevel = requiredLevel;
    }
    public String getLogName() { return logName;}
    public int getRequiredLevel() { return requiredLevel;}
    public boolean isAccessible() {
        return Skills.getCurrentLevel(Skill.FIREMAKING) >= requiredLevel;
    }
}