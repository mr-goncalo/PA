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
public class ArchersAttack extends Action {

    public ArchersAttack(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j, int track) {
        int rol = j.lancaDado();
        switch (track) {
            case LADDER_TRACK:
                if (j.isHasLadderns() && j.getEnemiesLaddersLocation() != 4) {
                    if (rol + j.getLaddersBonus() > LADDER_STRG) {
                        j.AdvanceLadders(-1);
                        j.setLog("Attack Sucessful!");
                        return 1;
                    }
                    j.setLog("You Rolled " + rol + j.getLaddersBonus() + " Attack failed!");
                    return 0;
                }
                j.setLog("Track selected not valid");
                return -1;
            case BATT_RAM_TRACK:
                if (j.isHasBattRam() && j.getEnemiesBattRamLocation() != 4) {
                    if (rol + j.getBattRamBonus() > BATT_RAM_STRG) {
                        j.AdvanceBattRam(-1);
                        j.setLog("Attack Sucessful!");
                        return 1;
                    }
                    j.setLog("You Rolled " + rol + j.getBattRamBonus() + " Attack failed!");
                    return 0;
                }
                j.setLog("Track selected not valid");
                return -1;
            case SIEGE_TOWER_TRACK:
                if (j.isHasSiegeTower() && j.getEnemiesSiegeTowerLocation() != 4) {
                    if (rol + j.getSiegeTowerBonus() > SIEGE_TOWER_STRG) {
                        j.AdvanceSiegeTower(-1);
                        j.setLog("Attack Sucessful!");
                        return 1;
                    }
                    j.setLog("You Rolled " + rol + j.getSiegeTowerBonus() + " Attack failed!");
                    return 0;
                }
                j.setLog("Track selected not valid");
                return -1;

        }
        return 0;
    }
}
