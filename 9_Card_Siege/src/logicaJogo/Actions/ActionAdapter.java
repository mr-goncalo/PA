/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Actions;

import logicaJogo.DadosJogo;

/**
 *
 * @author eu
 */
public class ActionAdapter extends Action {

    public ActionAdapter(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int ApplyRules(DadosJogo j, int track) {
        return 0;
    }

    @Override
    public int ApplyRules(DadosJogo j) {
        return 0;
     }

}
