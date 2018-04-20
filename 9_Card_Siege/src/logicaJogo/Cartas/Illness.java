/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import logicaJogo.Jogo;

/**
 *
 * @author eu
 */
public class Illness extends Card{
    
    public Illness(String eventDesc, String eventName, int actionPoint) {
        super(eventDesc, eventName, actionPoint);
    }

    @Override
    public void AdvanceEnemies(Jogo j) {
        j.enemiesSiegeTowerLocation--;
     }

    @Override
    public void ApplyEvent(Jogo j) {
        j.playerSupplies--;
        j.playerMorale--;
     }

    @Override
    public void TurnActionPoints(Jogo j) {
        j.turnActionPoints += super.getActionPoint();
     }
    
    
}
