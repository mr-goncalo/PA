
package logicaJogo.Cartas;

import logicaJogo.Jogo;


public class SuppliesSpoiled extends Card
{

    public SuppliesSpoiled(String eventDesc, String eventName, int actionPoint) {
        super(eventDesc, eventName, actionPoint);
    }

    @Override
    public void ApplyEvent(Jogo j) {
        j.playerSupplies--;
     }

    @Override
    public void AdvanceEnemies(Jogo j) {
         // avança os enimigos
         j.enemiesLaddersLocation--;
    }

    @Override
    public void TurnActionPoints(Jogo j) {
        j.turnActionPoints = super.getActionPoint();
     } 
    
}
