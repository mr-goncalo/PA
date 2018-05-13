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
public class SupplyRaid extends ActionAdapter {

    public SupplyRaid(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j) {
        int roll = j.lancaDado() + j.getRaidBonus();
        if (roll == 6) {
            j.setSuppliesCarried(2);
            j.setLog("Sucessfull! You raided 2 supply");
            return 1;
        } else if (roll > 2 && roll < 6) {
            if (j.getSuppliesCarried() < 2) {
                j.setSuppliesCarried(j.getSuppliesCarried() + 1);
                j.setLog("Sucessfull! You raided 1 supply");
                return 1;
            }
            j.setLog("Supplies Carried Full!");
            return 0;
        } else if (roll == 1) {
            j.EnemyLineCheck();
            return 1;
        } else {
            j.setLog("You Rolled " + roll + " Attack failed!");
            return 1;
        }
    }

}
