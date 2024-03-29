package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

public class CoverOfDarkness extends CardAdapter {

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
        j.setRaidBonus(j.getRaidBonus() + 1);
    }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
        j.setSabotageBonus(0);
        j.setRaidBonus(0);
    }

}
