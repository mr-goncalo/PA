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
public class AguardaRallyTroops extends EstadoAdapter implements IEstado {

    public AguardaRallyTroops(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarRallyTroops(int bonus) {
        if (bonus == 1 || bonus == 2) {
            if (getJogo().getPlayerSupplies() > 0) {
                getJogo().performRallyTroops(bonus);
                getJogo().setTurnActionPoints(getJogo().getTurnActionPoints());
                return new AguardaAccao(getJogo());
            } else { 
                getJogo().setLog("Not enought supplies!");
                return this;
            }
        }
        getJogo().setLog("Invalid Option!");
        return this;
    }

}
