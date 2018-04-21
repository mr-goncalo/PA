
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class EnemyFatigue extends Card
{
    
    public EnemyFatigue(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
    
    @Override
    public void AdvanceEnemies(DadosJogo j) {
         j.setEnemiesLaddersLocation(j.getEnemiesLaddersLocation() - 1);
    }
    
    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setC
     }
}
