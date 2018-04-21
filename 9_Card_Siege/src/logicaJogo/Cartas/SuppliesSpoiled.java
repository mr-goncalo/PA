
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;


public class SuppliesSpoiled extends Card
{

    public SuppliesSpoiled(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setPlayerSupplies(j.getPlayerSupplies() - 1);
     }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
         // avança os enimigos
         j.setEnemiesLaddersLocation(j.getEnemiesLaddersLocation() - 1);
    }

    
    
}
