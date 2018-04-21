
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class Collapsed extends Card {

    public Collapsed(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.setEnemiesBattRamLocation(j.getEnemiesBattRamLocation() - 1);
        j.setEnemiesLaddersLocation(j.getEnemiesLaddersLocation() - 1);

    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.RemoveSiegeTower();
    }  

}
