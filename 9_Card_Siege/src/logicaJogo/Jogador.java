
package logicaJogo;

import java.io.Serializable;

public class Jogador implements Constantes, Serializable
{
    private String nome;
    private Jogo jogo;
    private boolean ganhou;
    
    public Jogador(String nome, Jogo jogo) 
    {
        this.nome = nome;
        this.jogo = jogo;
        this.ganhou=false;
    }
    
    public void setNomeJogador(String nome)
    {
        this.nome = nome;
    }
    
}
