
package logicaJogo;

import java.io.Serializable;

public class Jogador implements Constantes, Serializable
{
    private String nome;
    private DadosJogo jogo;
    private boolean ganhou;
    
    public Jogador(String nome, DadosJogo jogo) 
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
