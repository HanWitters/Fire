package Han.Fire.data;

import org.rspeer.runetek.api.movement.position.Area;

public enum Locations {
    GRAND_EXCHANGE_SOUTH(
            Area.rectangular(3161, 3491, 3168, 3486),
            Area.rectangular(3181, 3476, 3185, 3473),
            Area.rectangular(3185, 3473, 3147, 3477),
            "GE_South");

    private final Area bankPoint, beginPoint,firePoint;
    private final String locName;

    Locations(final Area bankPoint, Area beginPoint, Area firePoint, String LocName) {
        this.bankPoint = bankPoint;
        this.beginPoint = beginPoint;
        this.firePoint = firePoint;
        this.locName = LocName;
    }
    public Area getBankPoint() {return bankPoint;}
    public Area getBeginPoint() {return beginPoint;}
    public Area getFirePoint() {return firePoint;}
    public String getLocName() {return locName;}
}
