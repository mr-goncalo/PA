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
public class Coupure extends Action {

    public Coupure(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j) {
        int roll = j.lancaDado();
        if (roll + j.getCoupureBonus() > 4) {
            j.setPlayerWallStrength(j.getPlayerWallStrength() + 1);
            j.setLog("Attack Successful!");
            return 1;
        }
        j.setLog("Attack failed!");
        return 0;
    }

}
