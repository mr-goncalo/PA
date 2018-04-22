
package logicaJogo.Estados;

import java.io.Serializable;
import logicaJogo.DadosJogo;


public abstract class EstadoAdapter implements IEstado, Serializable
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

    @Override
    public IEstado defineNomeJogador(String nome) 
    {
        return this;
    }

    @Override
    public IEstado comecarJogo() 
    {
        return this;
    } 
    
    @Override
    public IEstado retirarCarta()
    { 
        return this;
    }

    @Override
    public IEstado mudarTurno() {
        return this;
    }

    @Override
    public IEstado verificaEnimigosAreaCombate()
    {
        return this;
    }
    
    @Override
    public IEstado realizarAccao(int n) {
        return this;
    }

    @Override
    public IEstado verificaFimJogo() {
        return this;
    }
}
