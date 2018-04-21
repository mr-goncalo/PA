/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class VolleyOfArrows extends Card {

    public VolleyOfArrows(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.setEnemiesBattRamLocation(j.getEnemiesBattRamLocation() - 1);
    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setLaddersBonus(1);
        j.setBattRamBonus(1);
        j.setCloseCombatAttBonus(1);
        j.setSiegeTowerBonus(1);
    }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
        j.setLaddersBonus(0); 
        j.setBattRamBonus(0);
        j.setCloseCombatAttBonus(0);
        j.setSiegeTowerBonus(0);
    }

}
