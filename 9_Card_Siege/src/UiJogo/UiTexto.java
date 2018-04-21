package UiJogo;

import java.util.Scanner;
import logicaJogo.Estados.AguardaAccao;
import logicaJogo.Estados.AguardaCarta;
import logicaJogo.Estados.AguardaInicio;
import logicaJogo.Estados.IEstado;
import logicaJogo.DadosJogo;
import logicaJogo.MaquinaEstados;

public class UiTexto 
{        
    private MaquinaEstados jogo;
    boolean sair = false;
    
    public UiTexto(MaquinaEstados jogo)
    {
        this.jogo = jogo;
    }
    
    void iuAguardaInicio()
    {
        DadosJogo j = new DadosJogo();
        System.out.println( j.toString());
        
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
         System.out.println("aguarda carta..."); 
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
