
package logicaJogo;

import java.io.Serializable;
import logicaJogo.Estados.AguardaCarta;
import logicaJogo.Estados.AguardaInicio;
import logicaJogo.Estados.IEstado;

public class Jogo implements Serializable
{
    private DadosJogo jogo ;
    private IEstado estado;

    public Jogo() 
    {
        this.jogo = new DadosJogo();
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
          
    public void retirarCarta() {
        setEstado(estado.retirarCarta());
    }
    public void realizarAccao(int n){
        setEstado(estado.realizarAccao(n));
    }
    
    public void mudarTurno(){
        setEstado(estado.mudarTurno());
    }
    
    public String toStringDados() {
         return jogo.toStringDados();
    }  

    public String toStringCarta() {
        return jogo.toStringCarta();
    }

    
}
