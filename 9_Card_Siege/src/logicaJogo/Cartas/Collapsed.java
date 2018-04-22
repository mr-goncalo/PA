
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class Collapsed extends Card {

    public Collapsed(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceLadders(1);
        j.AdvanceBattRam(1);

    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.RemoveSiegeTower();
    }  

}
