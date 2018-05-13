/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import java.io.Serializable;
import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class CardAdapter extends Card implements Serializable {

    public CardAdapter(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }

    @Override
    public void TurnActionPoints(DadosJogo j) {
        j.setTurnActionPoints(super.getActionPoint());
    }

    @Override
    public void ApplyEvent(DadosJogo j) {
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        
    }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
    }
 

}
