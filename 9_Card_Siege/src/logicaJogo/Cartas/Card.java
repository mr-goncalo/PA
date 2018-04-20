
package logicaJogo.Cartas;

import logicaJogo.Jogo;

public class Card 
{
    private String eventDesc;
    private String eventName;
    private int actionPoint;

    public Card(String eventDesc, String eventName, int actionPoint) {
        this.eventDesc = eventDesc;
        this.eventName = eventName;
        this.actionPoint = actionPoint;
    }
  
    /**
     *
     * @param j
     */
    public void ApplyEvent(Jogo j){};
    
    public void AdvanceEnemies(Jogo j){};
    
    public void TurnActionPoints(Jogo j){};
    
    public void RemoveEventBonus(Jogo j){};
    
    public String getEventDesc() {
        return eventDesc;
    }

    public String getEventName() {
        return eventName;
    }

    public int getActionPoint() {
        return actionPoint;
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
 
     
}
