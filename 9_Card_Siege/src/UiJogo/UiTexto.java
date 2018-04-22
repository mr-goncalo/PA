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
        String s = new String(); 
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
        
        if(c=='1')
        {
            int n;
            do
            {
                System.out.println("\n1 - Archers Attack\n2 - Boiling Water Attack\n3 - Close Combat Attack\n"
                + "4 - Coupure\n5 - Rally Troops\n6 - Tunnel Movement\n7 - Supply Raid\n8 - Sabotage\n9 - Voltar Atrás\n");         
                n = sc.nextInt();
            }while(n>9 || n<1);
 
            if(n!=9)
                jogo.realizarAccao(n);   
            
            return;                         
        }
        if(c=='2')
        {       
            jogo.retirarCarta(); 
            System.out.println(jogo.toStringCarta());
            System.out.println(jogo.toStringDados());
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
