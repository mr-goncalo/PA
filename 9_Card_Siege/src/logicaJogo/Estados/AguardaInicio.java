
package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaInicio extends EstadoAdapter implements IEstado
{
    
    public AguardaInicio(DadosJogo jogo) 
    {
        super(jogo);
    }
    
    @Override
    public IEstado defineNomeJogador(String nome)
    {
        getJogo().setNomeJogador(nome);
        return this;
    }
    
    @Override
    public IEstado comecarJogo()
    {
        return new AguardaCarta(getJogo());
    } 
     
}
