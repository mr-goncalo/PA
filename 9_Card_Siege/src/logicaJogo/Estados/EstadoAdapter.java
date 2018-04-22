
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
//        getJogo().AdvanceTurn();
//        return new AguardaCarta(jogo);
        return this;
    }

    @Override
    public IEstado playerAction(int action) {
        return this;
    }
 
    @Override
    public IEstado playerAction() {
        return this;
    }
}
