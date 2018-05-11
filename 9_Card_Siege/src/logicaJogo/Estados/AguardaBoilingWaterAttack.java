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
public class AguardaBoilingWaterAttack extends EstadoAdapter implements IEstado {

    public AguardaBoilingWaterAttack(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarBoilingWaterAttack(int pista) 
    {
        // return getJogo().ArchersAttack(pista) ? new AguardaAccao(getJogo()) : this;
        boolean accao = getJogo().ArchersAttack(pista);
      
        if(getJogo().isPerdeu())
            return new FimJogo(getJogo());

        return accao ? new AguardaAccao(getJogo()) : this;
  
    }

}
