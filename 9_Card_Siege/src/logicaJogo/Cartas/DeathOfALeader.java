/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class DeathOfALeader extends Card {

    public DeathOfALeader(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceSiegeTower(1);
        j.setEnemiesLaddersLocation(j.getEnemiesLaddersLocation() - 1);
    }

    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setPlayerMorale(j.getPlayerMorale() - 1);
    }

    @Override
    public void TurnActionPoints(DadosJogo j) {

        j.setTurnActionPoints(j.getTurnActionPoints() + super.getActionPoint());

    }

}
