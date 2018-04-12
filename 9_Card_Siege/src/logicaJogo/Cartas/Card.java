
package logicaJogo.Cartas;

public class Card //imple.. ser..
{
    private String eventDesc;
    private String eventName;
    private int actionPoint;
    
    private int supplies;
    private int raid;
    private int morale;
    private int sabotage; 
    private int coupure;
    private int circleSpaces;
    private int closeCombat;
    
    private int batteringRam;
    private int siegeTower; 
    private int ladders; 

    public Card(String eventDesc, String eventName, int actionPoint, int supplies, int raid, int morale, int sabotage, int coupure, int circleSpaces, int closeCombat, int batteringRam, int siegeTower, int ladders) {
        this.eventDesc = eventDesc;
        this.eventName = eventName;
        this.actionPoint = actionPoint;
        this.supplies = supplies;
        this.raid = raid;
        this.morale = morale;
        this.sabotage = sabotage;
        this.coupure = coupure;
        this.circleSpaces = circleSpaces;
        this.closeCombat = closeCombat;
        this.batteringRam = batteringRam;
        this.siegeTower = siegeTower;
        this.ladders = ladders;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public String getEventName() {
        return eventName;
    }

    public int getActionPoint() {
        return actionPoint;
    }

    public int getSupplies() {
        return supplies;
    }

    public int getRaid() {
        return raid;
    }

    public int getMorale() {
        return morale;
    }

    public int getSabotage() {
        return sabotage;
    }

    public int getCoupure() {
        return coupure;
    }

    public int getCircleSpaces() {
        return circleSpaces;
    }

    public int getCloseCombat() {
        return closeCombat;
    }

    public int getBatteringRam() {
        return batteringRam;
    }

    public int getSiegeTower() {
        return siegeTower;
    }

    public int getLadders() {
        return ladders;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setActionPoint(int actionPoint) {
        this.actionPoint = actionPoint;
    }

    public void setSupplies(int supplies) {
        this.supplies = supplies;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public void setSabotage(int sabotage) {
        this.sabotage = sabotage;
    }

    public void setCoupure(int coupure) {
        this.coupure = coupure;
    }

    public void setCircleSpaces(int circleSpaces) {
        this.circleSpaces = circleSpaces;
    }

    public void setCloseCombat(int closeCombat) {
        this.closeCombat = closeCombat;
    }

    public void setBatteringRam(int batteringRam) {
        this.batteringRam = batteringRam;
    }

    public void setSiegeTower(int siegeTower) {
        this.siegeTower = siegeTower;
    }

    public void setLadders(int ladders) {
        this.ladders = ladders;
    }
     
}
