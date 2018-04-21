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
public class BadWeather extends Card{

    public BadWeather(String eventName, String eventDesc, int actionPoint) {
        super(eventName, eventDesc, actionPoint);
    }
    
   
  
    @Override
    public void ApplyEvent(DadosJogo j) {
        j.setBadWheather(true);
    }

    @Override
    public void RemoveEventBonus(DadosJogo j) {
        j.setBadWheather(false);
     }

     
    
    
}
