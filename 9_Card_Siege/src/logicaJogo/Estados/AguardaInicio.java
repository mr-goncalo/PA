
package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaInicio extends EstadoAdapter
{
    
    public AguardaInicio(DadosJogo jogo) 
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
        return new AguardaCarta(getJogo());
      //return this; 
    } 
}
