
package logicaJogo.Estados;

import java.io.Serializable;
import logicaJogo.Jogo;


public class EstadoAdapter implements IEstado, Serializable
{
    private Jogo jogo;
    
    public EstadoAdapter(Jogo jogo)
    {
        this.jogo = jogo;
    }

    public Jogo getJogo()
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
