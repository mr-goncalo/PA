
package logicaJogo.Estados;

import logicaJogo.Jogo;

public class AguardaInicio extends EstadoAdapter
{
    
    public AguardaInicio(Jogo jogo) 
    {
        super(jogo);
    }
    
    public IEstado defineNomeJogador(String nome)
    {
        getJogo().setNomeJogador(nome);
        return this;
    }
    
    public IEstado comecarJogo()
    {
//        if(getJogo().inicializa())
//        {
//            return new AguardaColocacao(getJogoDados());
//        }
//        return this; 
    }
    
}
