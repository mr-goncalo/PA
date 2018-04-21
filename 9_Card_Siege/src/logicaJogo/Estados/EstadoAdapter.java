
package logicaJogo.Estados;

import java.io.Serializable;
import logicaJogo.DadosJogo;


public class EstadoAdapter implements IEstado, Serializable
{
    private DadosJogo jogo;
    
    public EstadoAdapter(DadosJogo jogo)
    {
        this.jogo = jogo;
    }

    public DadosJogo getJogo()
    {
        return jogo; 
    }

    public IEstado defineNomeJogador(String nome) 
    {
        return this;
    }

    public IEstado comecarJogo() 
    {
        return this;
    }
    
    
}
