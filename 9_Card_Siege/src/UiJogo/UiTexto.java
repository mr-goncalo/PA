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
    boolean primeiraJogada = true;
    boolean sair = false;
    
    public UiTexto(Jogo jogo)
    {
        this.jogo = jogo;
    }
    
    void iuAguardaInicio()
    {
                
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
            System.out.println("Valores iniciais:\n"+jogo.toStringDados());
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
        
        if(primeiraJogada)
        {         
            jogo.retirarCarta();  
            
            primeiraJogada=false;
            System.out.println(jogo.toStringCarta());
            System.out.println(jogo.toStringDados());
            jogo.mudarTurno();
        }
        
        System.out.println("1 - Acções\n2 - Retirar Carta\n3 - Sair");
        char c = ' ';
        Scanner sc = new Scanner(System.in);
        c = sc.next().charAt(0);
       //c='2';
        if(c=='1')
        {
            //jogo.playerAction();
            System.out.println("Ações ainda por fazer...");
            sair = true;
            return;
        }
        if(c=='2')
        {       
            jogo.retirarCarta(); 
            
            //if(!jogo.deckEmpty())
            {
                System.out.println(jogo.toStringCarta());
                System.out.println(jogo.toStringDados());
            } 
            jogo.mudarTurno();
            //jogo.retirarCarta();
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
