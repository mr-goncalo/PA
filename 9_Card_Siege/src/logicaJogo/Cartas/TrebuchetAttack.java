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
public class TrebuchetAttack extends  Card{
    
    public TrebuchetAttack(String eventDesc, String eventName, int actionPoint) {
        super(eventDesc, eventName, actionPoint);
    }

    @Override
    public void ApplyEvent(Jogo j) { 
        if(j.enemiesTrebuchetCount == 3)
            j.playerWallStrength -= 2;
        else if (j.enemiesTrebuchetCount == 2)
            j.playerWallStrength -= 1;
        else{
            //Rolar o dado
            //if(j.rollDice > 3)
                j.playerWallStrength -= 1;
        }
    }

    @Override
    public void TurnActionPoints(Jogo j) { 
        j.turnActionPoints += super.getActionPoint();
    }
    
}
