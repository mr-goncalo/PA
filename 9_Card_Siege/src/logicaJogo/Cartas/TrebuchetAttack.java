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
public class TrebuchetAttack extends  Card{

    public TrebuchetAttack(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
    
    

    @Override
    public void ApplyEvent(DadosJogo j) { 
        if(j.getEnemiesTrebuchetCount()  == 3)
            j.setPlayerWallStrength(j.getPlayerWallStrength() - 2);
        else if (j.getEnemiesTrebuchetCount()  == 2)
            j.setPlayerWallStrength(j.getPlayerWallStrength() - 1);
        else{
            //Rolar o dado
            //if(j.rollDice > 3)
            j.setPlayerWallStrength(j.getPlayerWallStrength() -1);
        }
    }
 
}
