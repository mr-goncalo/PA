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
    public void ApplyRules(DadosJogo j, int track) {
        int rol = j.lancaDado();
        switch (track) {
            case LADDER_TRACK:
                if (rol + j.getLaddersBonus() > LADDER_STRG) {
                    j.AdvanceLadders(-1);
                }
                break;
            case BATT_RAM_TRACK:
                if (rol + j.getBattRamBonus() > BATT_RAM_STRG) {
                    j.AdvanceBattRam(-1);
                }
                break;
            case SIEGE_TOWER_TRACK:
                if (rol + j.getSiegeTowerBonus()> SIEGE_TOWER_STRG) {
                    j.AdvanceSiegeTower(-1);
                }
                break;

        }
    } 
}
