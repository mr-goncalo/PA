/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Actions;

import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class Sabotage extends Action {

    public Sabotage(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j) {
        int roll = j.lancaDado() + j.getSabotageBonus();
        if (j.getEnemiesTrebuchetCount() != 0) {
            if (roll > 4) {
                j.setEnemiesTrebuchetCount(j.getEnemiesTrebuchetCount() - 1);
                j.setLog("Sabotage Sucessfull!");
                return 1;
            } else {
                j.setLog("Sabotage Failed!");
                return 1;
            }
        }
        j.setLog("Trebuchet Count is 0");
        return 0;
    }

}
