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
public class AguardaCloseCombatAttack extends EstadoAdapter implements IEstado {

    public AguardaCloseCombatAttack(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarCloseCombatAttack() 
    {
        //return getJogo().closeCombatAttack() ? new AguardaAccao(getJogo()) : this;
        boolean accao = getJogo().closeCombatAttack();
        if(getJogo().isPerdeu())
            return new FimJogo(getJogo());
        
        return accao ? new AguardaAccao(getJogo()) : this;

    }

    @Override
    public IEstado realizarCloseCombatAttack(int track) 
    {
        //return getJogo().closeCombatAttack() ? new AguardaAccao(getJogo()) : this;
        boolean accao = getJogo().closeCombatAttack();
        if(getJogo().isPerdeu())
            return new FimJogo(getJogo());
        return accao ? new AguardaAccao(getJogo()) : this;

    }

}
