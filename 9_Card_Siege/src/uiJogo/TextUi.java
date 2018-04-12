/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiJogo;
import java.util.Scanner;
import logicaJogo.*;
/**
 *
 * @author eu
 */
public class TextUi {
     
    
    /**
     *
     * @param args
     */
 public static void main(String []args)
 {         
    System.out.print("\n\nHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH\n"); 
    System.out.println("\n\n=== AGUARDA INICIO ===\n");
              
        
            System.out.println("\n0 - Comecar jogo\n1 - Recarregar jogo\n2 - Sair");
            
          Jogo jogo = new Jogo();
           
           System.out.println(jogo.toString());
            
         
    }
}
