/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import logicaJogo.Cartas.*;
/**
 *
 * @author eu
 */
public class Jogo {
    
 private ArrayList<ArrayList<Card>> deck;
    public Jogo() {
        deck = new  ArrayList<>();
        List<Card> card1 = new ArrayList<>();
        card1.add(new SuppliesSpoiled("coisa", "boas", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        card1.add(new SuppliesSpoiled("coisa2", "boas2", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        deck.add((ArrayList<Card>) card1);
        
        
    }

    @Override
    public String toString() {
          String s  = new String();
          for(ArrayList<Card> c : deck){
              for(Card cIner : c){
                  s+= "\n " + cIner.getEventName();
              }
          }
          
        return s;
    }

    
    
   
}
