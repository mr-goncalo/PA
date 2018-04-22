/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas;

import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class RepairedTrebuchet extends Card{
    
    public RepairedTrebuchet(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
 
    @Override
    public void ApplyEvent(DadosJogo j) {
        
        j.AddTrabuchet(1); 
        j.setCoupureBonus(j.getCoupureBonus()+1);
        
    }

    @Override
    public void AdvanceEnemies(DadosJogo j) {
        j.AdvanceLadders(1);
     }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
         j.setCoupureBonus(0);
     }

    

     
    
}
