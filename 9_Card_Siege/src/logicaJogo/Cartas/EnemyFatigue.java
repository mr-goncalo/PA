
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class EnemyFatigue extends Card
{
    
    public EnemyFatigue(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
    
    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceLadders(1);
    }
    
    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setCoupureBonus(1);
        j.setRaidBonus(1);
        j.setSabotageBonus(1);
     }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
         j.setCoupureBonus(0);
        j.setRaidBonus(0);
        j.setSabotageBonus(0);
     }

    @Override
    public void TurnActionPoints(DadosJogo j) {
        j.setTurnActionPoints(j.getTurnActionPoints() + super.getActionPoint());
    }
    
}
