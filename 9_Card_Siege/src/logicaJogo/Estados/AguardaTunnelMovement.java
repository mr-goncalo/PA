/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Estados;

import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class AguardaTunnelMovement extends EstadoAdapter {

    public AguardaTunnelMovement(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarTunnelMovement() {
        getJogo().advanceTotunnel();
        getJogo().setTurnActionPoints(getJogo().getTurnActionPoints() - 1); 
        getJogo().setTroopsEnteredInThisTurn(true);
        return new AguardaAccao(getJogo());
    }

    @Override
    public IEstado realizarTunnelMovement(int move) {
        if (move == 1)//Free movement
        {
            if (!getJogo().isTroopsEnteredInThisTurn()) {
                getJogo().setTroopsFreeMovement(true);
            } else {
                getJogo().setLog("You can use thuis movement in the same turn");
                return this;
            }
        } else if (move == 2) {//fast movement

            if (getJogo().getTurnActionPoints() > 0) {
                getJogo().tunnelFastMovement();
                getJogo().setTurnActionPoints(getJogo().getTurnActionPoints() - 1);
            } else {
                getJogo().setLog("You don't have enought action points!");
                return this;
            }
        }
        return new AguardaAccao(getJogo());
    }

}
