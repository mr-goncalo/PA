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
public class FlamingArrows extends CardAdapter {

    public FlamingArrows(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceSiegeTower(1);
    }

    
    @Override
    public void RemoveEventBonus(DadosJogo j) {
        super.RemoveEventBonus(j); //To change body of generated methods, choose Tools | Templates.
    }

    

}
