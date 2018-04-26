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
public class RallyTroops extends Action {

    public RallyTroops(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j, int bonus) {

        int roll = j.lancaDado();

        if (bonus == 1) {

            j.setPlayerSupplies(j.getPlayerSupplies() - 1);
            roll += 1;
        }
        if (roll + j.getMoraleBonus() > 4) {
            j.setPlayerMorale(j.getPlayerMorale() + 1);
            j.setLog("Morale Raised!");
            return 0;
        }
        j.setLog("Morale Raise Failed!");
        return 0;
    }

}
