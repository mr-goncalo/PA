package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class Card {

    private String eventDesc;
    private String eventName;
    private int actionPoint;

    public Card(String eventName, String eventDesc, int actionPoint) {
        this.eventDesc = eventDesc;
        this.eventName = eventName;
        this.actionPoint = actionPoint;
    }

    /**
     *
     * @param j
     */
    public void ApplyEvent(DadosJogo j) {
    }

    ;
    
    public void AdvanceEnemies(DadosJogo j) {
    }

    ;
    
    public void TurnActionPoints(DadosJogo j) {
        j.setTurnActionPoints(j.getTurnActionPoints() + this.actionPoint);

    }

    ;
    
    public void RemoveEventBonus(DadosJogo j) {
    }

    ;
    
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

    @Override
    public String toString() {
        String s = "\n";
        s += "-------------------------------";
        s += "\n \t|";
        s += " " + this.eventName;
        s += "\n     " + this.actionPoint + "\t| ";
        s += this.eventDesc;
        s += "\n--------------------------------\n";
        return s;
    }

}
