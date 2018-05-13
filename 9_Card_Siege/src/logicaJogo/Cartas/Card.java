package logicaJogo.Cartas;

import java.io.Serializable;
import logicaJogo.DadosJogo;

public abstract class Card implements Serializable {

    private String eventDesc;
    private String eventName;
    private int actionPoint;

    public Card(String eventName, String eventDesc, int actionPoint) {
        this.eventDesc = eventDesc;
        this.eventName = eventName;
        this.actionPoint = actionPoint;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void TurnActionPoints(DadosJogo j) {
        j.setTurnActionPoints(this.actionPoint);
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
        s += "\n-------------------------------- ";
        return s;
    }

    public abstract void ApplyEvent(DadosJogo j);

    public abstract void AdvanceEnemies(DadosJogo j);

    public abstract void RemoveEventBonus(DadosJogo j);
}
