
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class CoverOfDarkness extends Card
{
    
    public CoverOfDarkness(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
 
    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AvancaMaisLonge();
    }
    
    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setSabotageBonus(j.getSabotageBonus() + 1);
        j.setPlayerSupplies(j.getPlayerSupplies() +1);
    }
    
    @Override
    public void TurnActionPoints(DadosJogo j) {
        j.setTurnActionPoints(j.getTurnActionPoints() + super.getActionPoint());
    }
}
