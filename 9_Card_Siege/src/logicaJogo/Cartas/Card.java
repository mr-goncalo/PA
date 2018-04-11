
package logicaJogo.Cartas;

public class Card //imple.. ser..
{
    private String eventDesc;
    private String eventName;
    private int actionPoint;
    private int supplies;
    public Card(String eventDesc, String eventName, int actionPoint, int supplies) {
        this.eventDesc = eventDesc;
        this.eventName = eventName;
        this.actionPoint = actionPoint;
        this.supplies = supplies;
    }
    


    public String getEventName() {
        return eventName;
    }

    public int getActionPoint() {
        return actionPoint;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setActionPoint(int actionPoint) {
        this.actionPoint = actionPoint;
    }
    
    
}
