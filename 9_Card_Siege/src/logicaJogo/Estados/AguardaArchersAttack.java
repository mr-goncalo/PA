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
public class AguardaArchersAttack extends EstadoAdapter implements IEstado{
    
    public AguardaArchersAttack(DadosJogo jogo) {
        super(jogo);
    } 
    
    @Override
    public IEstado realizarArchersAttack(int pista){
        return getJogo().ArchersAttack(pista) ?  new AguardaAccao(getJogo()) :  this;  
    }
}
