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
public class BoilingWaterAttack extends Action {

    public BoilingWaterAttack(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j, int track) {
        //rolar dados + 1 do bónus do ataque mais o bónus do espaço de circulo 
        int rol = j.lancaDado() + 1 + j.getCircleSpacesBonus();
                // Caso role 1 a ação falha e baixa a morale by 1, caso haja um bonus que torne o role > 1 nao tira morale

        switch (track) {
            case LADDER_TRACK:
                if (j.isLaddersInCircleSpace()) {
                    if (rol == 1) { // Caso role 1 a ação falha e baixa a morale by 1, caso haja um bonus que torne o role > 1 nao tira morale
                        if (rol + j.getLaddersBonus() < 1) {
                            j.setLog("Bad luck you rolled 1, morale reduced by 1");
                            j.setPlayerMorale(j.getPlayerMorale() - 1);
                        } else {
                            j.setLog("Bad luck you rolled 1, but your morale is intact");
                        }
                        return 0;
                    }
                    if (rol + j.getLaddersBonus() > LADDER_STRG) {
                        j.AdvanceLadders(-1);
                        j.setLog("Attack Successful!");
                        return 1;
                    }
                    j.setLog("Attack failed!");
                    return 0;
                }
                j.setLog("Track selected not in circle space");
                return -1;
            case BATT_RAM_TRACK:
                if (j.isBattRamInCircleSpace()) {
                    if (rol + j.getBattRamBonus() > BATT_RAM_STRG && j.isBattRamInCircleSpace()) {
                        j.AdvanceBattRam(-1);
                        j.setLog("Attack Successful!");
                        return 1;
                    }
                    j.setLog("Attack failed!");
                    return 0;
                }
                j.setLog("Track selected not valid");
                return -1;
            case SIEGE_TOWER_TRACK:
                if (j.isSiegeTowerInCircleSpace()) {
                    if (rol + j.getSiegeTowerBonus() > SIEGE_TOWER_STRG) {
                        j.AdvanceSiegeTower(-1);
                        j.setLog("Attack Successful!");
                        return 1;
                    }
                    j.setLog("Attack failed!");
                    return 0;
                }
                j.setLog("Track selected not valid");
                return -1;

        }
        return 0;
    }

}
