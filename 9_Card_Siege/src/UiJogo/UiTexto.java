package UiJogo;

import java.util.Scanner;
import logicaJogo.Estados.AguardaAccao;
import logicaJogo.Estados.AguardaCarta;
import logicaJogo.Estados.AguardaInicio;
import logicaJogo.Estados.IEstado;
import logicaJogo.DadosJogo;
import logicaJogo.Jogo;

public class UiTexto 
{        
    private Jogo jogo;
    private DadosJogo j;
    boolean sair = false;
    
    public UiTexto(Jogo jogo)
    {
        this.jogo = jogo;
    }
    
    void iuAguardaInicio()
    {
        
        //System.out.println( j.toString());
        
        System.out.println("1 - Novo Jogo\n2 - Sair");
        char c = ' ';
        Scanner sc = new Scanner(System.in);
        c = sc.next().charAt(0);
        if(c=='1')
        {
            System.out.println("Insira o nome do jogador: ");           
            String nome = sc.next();
            jogo.defineNomeJogador(nome);
            System.out.println("Nome: " + nome);
            jogo.comecarJogo();
            return;
        }
        if(c=='2')
        {
            sair = true;
            return;
        }        
    }
    
    void iuAguardaCarta()
    {
         //System.out.println("A mostrar carta...");
        String s = new String(); 
         //System.out.println(jogo.DrawedCardToString());
        System.out.println("\n");
        jogo.retirarCarta();        
        System.out.println(jogo.toString());
        
        
        System.out.println("1 - Acções\n2 - Outra Carta\n3 - Sair");
        char c = ' ';
        Scanner sc = new Scanner(System.in);
        c = sc.next().charAt(0);
        if(c=='1')
        {
            //jogo.escolherAccao();
            System.out.println("Ações ainda por fazer...");
            sair = true;
            return;
        }
        if(c=='2')
        {
            jogo.mudarTurno();
            return;
        }      
        if(c=='3')
        {
            sair = true;
            return;
        }   
    }
    
    void iuAguardaAccao()
    {
        
    }
    
    void corre()
    {
        while (!sair) 
        {
            IEstado estado = jogo.getEstado();
            if (estado instanceof AguardaInicio)
            {
                iuAguardaInicio();
            }
            else if (estado instanceof AguardaCarta) 
            {
                iuAguardaCarta();
            } 
            else if (estado instanceof AguardaAccao) 
            {
                iuAguardaAccao();
            } 
        }
    }
}
