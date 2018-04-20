/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import logicaJogo.Cartas.*;

/**
 *
 * @author eu
 */
public class Jogo implements Constantes, Serializable {

    //Variaveis de Motor dejogo
    private int dia;
    private ArrayList<ArrayList<Card>> deck;
    public int turnActionPoints;

    //Variaveis de Bonus
    public int moraleBonus;
    public int sabotageBonus;

    //Variaveis Status card jogador
    public int playerSupplies;
    public int playerMorale;
    public int playerWallStrength;
    // Variaveis Tracks cards dos enimigos
    public int enemiesLaddersLocation;
    public int enemiesSiegeTowerLocation;
    public int enemiesTrebuchetCount;
    public int enemiesBattRamLocation;

    private Jogador jog;

    public Jogo() {
        jog = new Jogador("DEFAULT", this);
        dia = 0;
        moraleBonus = 0;
        playerSupplies = 0;
        enemiesLaddersLocation = 4;
        enemiesSiegeTowerLocation = 4;
        enemiesTrebuchetCount = 3;
        enemiesBattRamLocation = 4;
        playerMorale = 4;
        playerSupplies = 4;
        turnActionPoints = 0;
        playerWallStrength = 4;

        deck = new ArrayList<>();
        List<Card> card1 = new ArrayList<>();
        List<Card> card2 = new ArrayList<>();
        List<Card> card3 = new ArrayList<>();
        List<Card> card4 = new ArrayList<>();
        List<Card> card5 = new ArrayList<>();
        List<Card> card6 = new ArrayList<>();
        List<Card> card7 = new ArrayList<>();

        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n 2T - 1 Damage to wall \n 1T - 1 Damage to wall on Dice roll of 4,5,6", 3));
        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n 2T - 1 Damage to wall \n 1T - 1 Damage to wall on Dice roll of 4,5,6", 2));
        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n 2T - 1 Damage to wall \n 1T - 1 Damage to wall on Dice roll of 4,5,6", 1));

        card2.add(new Illness("Illness", "Reduce morale by 1 \n Reduce supplies by 1", 2));
        card2.add(new GuardsDistracted("Guards Distracted", "+1 to sabotage action \n +1 to morale action", 2));
        card2.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n 2T - 1 Damage to wall \n 1T - 1 Damage to wall on Dice roll of 4,5,6", 1));

            
        deck.add((ArrayList<Card>) card1);
        deck.add((ArrayList<Card>) card2);

    }

    public void setNomeJogador(String nome) {
        jog.setNomeJogador(nome);
    }

    @Override
    public String toString() {
        String s = new String();
        s += "\n Todos os elemtnos";
        for (ArrayList<Card> c : deck) {
            for (Card cIner : c) {
                s += "\n " + cIner.getEventDesc();
            }
        }
        s += "\n ";
        for (ArrayList<Card> c : deck)  
           c.get(dia).ApplyEvent(this); 
        s += "\n Variaveis de jogo \n";
        s +=" Jogador moraleBonus: " +moraleBonus+ " sabotage: " + sabotageBonus + " morale: " +playerMorale+
                " Supplies: " + playerSupplies + " Wall strength: " +playerWallStrength;
        s+= "\n Enimigos battLocation: " +enemiesBattRamLocation + " ladders Loc: " +enemiesLaddersLocation +
                " siegeTower Location "+ enemiesSiegeTowerLocation + " trebuchet Count: " +enemiesTrebuchetCount;
        return s;
    }

    public void AvancaMaisLonge() {
        int maisLonge;

        if (this.enemiesBattRamLocation >= this.enemiesLaddersLocation) {
            maisLonge = this.enemiesBattRamLocation;
        } else {
            maisLonge = this.enemiesLaddersLocation;
        }
        if (maisLonge < this.enemiesSiegeTowerLocation) {
            maisLonge = this.enemiesSiegeTowerLocation;
        }

        if (maisLonge == this.enemiesSiegeTowerLocation) {
            this.enemiesSiegeTowerLocation--;
        }
        if (maisLonge == this.enemiesBattRamLocation) {
            this.enemiesBattRamLocation--;
        }
        if (maisLonge == this.enemiesLaddersLocation) {
            this.enemiesLaddersLocation--;
        }
    }

}
