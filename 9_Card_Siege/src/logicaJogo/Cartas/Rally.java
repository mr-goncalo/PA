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
public class Rally extends Card {

    public Rally(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceBattRam(1);
        j.AdvanceSiegeTower(1);
    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setCloseCombatAttBonus(1);
        j.setCircleSpacesBonus(1);
    }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
        j.setCloseCombatAttBonus(0);
        j.setCircleSpacesBonus(0);
    }

     

}
