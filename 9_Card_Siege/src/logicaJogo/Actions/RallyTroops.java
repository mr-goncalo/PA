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
public class RallyTroops extends ActionAdapter {

    public RallyTroops(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j, int bonus) {

        int roll = j.lancaDado()+ j.getMoraleBonus();

        if (bonus == 1) {

            j.setPlayerSupplies(j.getPlayerSupplies() - 1);
            roll += 1;
        }
        if (roll  > 4) {
            j.setPlayerMorale(j.getPlayerMorale() + 1);
            j.setLog("Morale Raised!");
            return 0;
        }
        j.setLog("You Rolled " + roll + " Attack failed!");
        return 0;
    }

}
