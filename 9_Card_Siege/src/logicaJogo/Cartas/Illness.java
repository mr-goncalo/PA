
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;


public class Illness extends Card 
{

    public Illness(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
  
    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceSiegeTower(1);
    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setPlayerSupplies(j.getPlayerSupplies() - 1);
        j.setPlayerMorale(j.getPlayerMorale() - 1);
    }

    
}
