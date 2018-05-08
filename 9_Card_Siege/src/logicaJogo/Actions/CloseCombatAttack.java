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
public class CloseCombatAttack extends Action implements logicaJogo.Constantes {

    public CloseCombatAttack(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j, int track) {
        int rol = j.lancaDado() + j.getCloseCombatAttBonus();
        int[] units = j.getCloseCombatUnits();
        if (track == 0 || track == 1) {
            if (rol > CLOSE_COMBAT_STRG) {
                if (units[track] == LADDERSID) { // procura qual é a que está a ocupar 
                    j.setHasLadderns(true); //volta a por a flag hasLadders a true para saber que elas voltaram ao tabuleiro
                    j.AdvanceLadders(-1);// recua 1 espaço
                    j.setLaddersInCircleSpace(true); // Quando elas recuam voltam para o cirulos.
                    units[track] = 0; // actualiza o array local
                    j.setCloseCombatUnits(units); // actualiza o array dos dados de jgo
                } else if (units[track] == BATTRAMID) {
                    j.setHasBattRam(true);
                    j.AdvanceBattRam(-1);
                    j.setBattRamInCircleSpace(true);
                    units[track] = 0;
                    j.setCloseCombatUnits(units);
                } else if (units[track] == SIEGETOWERID) {
                    j.setHasSiegeTower(true);
                    j.AdvanceSiegeTower(-1);
                    j.setSiegeTowerInCircleSpace(true);
                    units[track] = 0;
                    j.setCloseCombatUnits(units);
                }
                j.setLog("Attack Successful!");
                return 1;
            }
            j.setLog("You Rolled " + rol + " Attack failed!");
            return 0;
        }
        j.setLog("Invalid Track!");
        return -1;
    }

    @Override
    public int ApplyRules(DadosJogo j) {
        int i = 0;
        int[] units = j.getCloseCombatUnits();

        for (i = 0; i < units.length; i++) {
            if (units[i] != 0) {
                break;
            }
        }

        int rol = j.lancaDado() + j.getCloseCombatAttBonus();

        if (rol > CLOSE_COMBAT_STRG) {
            if (j.getCloseCombatUnits()[i] == LADDERSID) {
                j.setHasLadderns(true);
                j.AdvanceLadders(-1);
                j.setLaddersInCircleSpace(true);
                units[i] = 0;
                j.setCloseCombatUnits(units);
            } else if (j.getCloseCombatUnits()[i] == BATTRAMID) {
                j.setHasBattRam(true);
                j.AdvanceBattRam(-1);
                j.setBattRamInCircleSpace(true);
                units[i] = 0;
                j.setCloseCombatUnits(units);
            } else if (j.getCloseCombatUnits()[i] == SIEGETOWERID) {
                j.setHasSiegeTower(true);
                j.AdvanceSiegeTower(-1);
                j.setSiegeTowerInCircleSpace(true);
                units[i] = 0;
                j.setCloseCombatUnits(units);
            }
            j.setLog("You Rolled " + rol + " Attack failed!");
            return 1;
        }
        j.setLog("Attack failed!");
        return 0;

    }

}
