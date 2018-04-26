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
public class AguardaExtraPoint extends EstadoAdapter {

    public AguardaExtraPoint(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarExtraPoint(int c) {
        if (c == 1) {
            if (getJogo().getPlayerMorale() != 0) {
                getJogo().extraActionPoint(c);
                return new AguardaAccao(getJogo());
            }

            getJogo().setLog("You have 0 morale , you can't perform this action!");
            return this;
        } else if (c == 2) {
            if (getJogo().getPlayerSupplies() != 0) {
                getJogo().extraActionPoint(c);
                return new AguardaAccao(getJogo());
            }
            getJogo().setLog("You have 0 Supplies , you can't perform this action!");
            return this;
        } else {
            getJogo().setLog("Invalid Option!");
            return this;
        }
    }

}
