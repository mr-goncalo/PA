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
public class Coupure extends ActionAdapter {

    public Coupure(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j) {
        int roll = j.lancaDado() + j.getCoupureBonus();
        if (roll > 4) {
            j.setPlayerWallStrength(j.getPlayerWallStrength() + 1);
            j.setLog("Attack Successful!");
            return 1;
        }
        j.setLog("You Rolled " + roll + " Attack failed!");
        return 0;
    }

}
