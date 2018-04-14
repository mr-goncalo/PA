
package logicaJogo;

import java.io.Serializable;
import logicaJogo.Estados.AguardaCarta;
import logicaJogo.Estados.AguardaInicio;
import logicaJogo.Estados.IEstado;

public class MaquinaEstados implements Serializable
{
    private Jogo jogo = new Jogo();
    private IEstado estado;

    public MaquinaEstados() 
    {
        setEstado(new AguardaInicio(jogo));
    }

    private void setEstado(IEstado estado)
    { 
        this.estado = estado;
    }
    
    public IEstado getEstado()
    {
        return estado;
    }
    
    public void defineNomeJogador(String nome)
    {
        setEstado(estado.defineNomeJogador(nome));
    }

    public void comecarJogo() 
    {
        setEstado(estado.comecarJogo());
    }
    
    
}
