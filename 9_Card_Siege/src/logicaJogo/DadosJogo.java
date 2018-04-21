/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import logicaJogo.Cartas.*;

/**
 *
 * @author eu
 */
public class DadosJogo implements Constantes, Serializable {

    //Variaveis de Motor dejogo
    private int dia;
    private ArrayList<ArrayList<Card>> deck;
    private ArrayList<ArrayList<Card>> originalDeck;
    private int turnActionPoints;
    private boolean badWheather;
    private boolean hasSiegeTower;
    private boolean hasLadderns;
    private boolean hasBattRam;
    private boolean unusedBoilingWater;
    private int[] closeCombatUnits;

    //Variaveis de Bonus
    private int laddersBonus;
    private int battRamBonus;
    private int siegeTowerBonus;
    private int closeCombatAttBonus;
    private int coupureBonus;
    private int moraleBonus;
    private int sabotageBonus;
    private int circleSpacesBonus;

    //Variaveis Status card jogador
    private int playerSupplies;
    private int playerMorale;
    private int playerWallStrength;

    // Variaveis Tracks cards dos enimigos
    private int enemiesLaddersLocation;
    private int enemiesSiegeTowerLocation;
    private int enemiesTrebuchetCount;
    private int enemiesBattRamLocation;

    private Jogador jog;

    public DadosJogo() {
        jog = new Jogador("DEFAULT", this);
        dia = 1;
        moraleBonus = 0;
        playerSupplies = 0;
        enemiesLaddersLocation = 2;
        enemiesSiegeTowerLocation = 4;
        enemiesTrebuchetCount = 3;
        enemiesBattRamLocation = 4;
        playerMorale = 4;
        playerSupplies = 4;
        turnActionPoints = 0;
        playerWallStrength = 4;

        closeCombatUnits = new int[2];
        closeCombatUnits[0] = 1;
        closeCombatUnits[1] = 1;

        deck = new ArrayList<>();
        originalDeck = new ArrayList<>();
        List<Card> card1 = new ArrayList<>();
        List<Card> card2 = new ArrayList<>();
        List<Card> card3 = new ArrayList<>();
        List<Card> card4 = new ArrayList<>();
        List<Card> card5 = new ArrayList<>();
        List<Card> card6 = new ArrayList<>();
        List<Card> card7 = new ArrayList<>();

        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 3));
        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 2));
        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 1));

        card2.add(new Illness("Illness", "Reduce morale by 1 \n\t| Reduce supplies by 1", 2));
        card2.add(new GuardsDistracted("Guards Distracted", "+1 to sabotage action \n\t| +1 to morale action", 2));
        card2.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 1));

        card3.add(new SuppliesSpoiled("Supplies Spoiled", "Reduce supplies by 1", 2));
        card3.add(new BadWeather("Bad Weather", "Only raid and sabotage actions allowed this turn", 2));
        card3.add(new BoilingOil("Boiling Oil", "+2 to attacks on enemy units in circle spaces ", 2));

        card4.add(new DeathOfALeader("Death of a Leader", "Reduce moral by 1", 2));
        card4.add(new GateFortified("Gate Fortified", "+1 attacks on the Battering Ram", 2));
        card4.add(new FlamingArrows("Flaming Arrows", "+1 to attacks on the Siege Engine", 3));

        deck.add((ArrayList<Card>) card1);
        deck.add((ArrayList<Card>) card2);
        deck.add((ArrayList<Card>) card3);
        deck.add((ArrayList<Card>) card4);

        originalDeck = deck;

        Collections.shuffle(deck);

    }

    @Override
    public String toString() {
        String s = new String();
        s += "\n Todos os elemtnos";
        for (ArrayList<Card> c : deck) {
            for (Card cIner : c) {
                s += c.toString();
            }
        }
        s += "\n ";

        for (ArrayList<Card> c : deck) {
            c.get(dia).ApplyEvent(this);
        }
        AdvanceToCloseCombat();
        deck.get(1).get(1).AdvanceEnemies(this);
        s += "\n Variaveis de jogo \n";
        s += " Jogador moraleBonus: " + moraleBonus + " sabotage: " + sabotageBonus + " morale: " + playerMorale
                + " Supplies: " + playerSupplies + " Wall strength: " + playerWallStrength;
        s += "\n Enimigos battLocation: " + enemiesBattRamLocation + " ladders Loc: " + enemiesLaddersLocation
                + " siegeTower Location " + enemiesSiegeTowerLocation + " trebuchet Count: " + enemiesTrebuchetCount;
        return s;
    }

    ///////////// funções do jogo 
    public void AvancaMaisLonge() {
        int maisLonge;

        if (this.enemiesBattRamLocation >= this.enemiesLaddersLocation) {
            maisLonge = this.enemiesBattRamLocation;
        } else {
            maisLonge = this.enemiesLaddersLocation;
        }

        if (maisLonge < this.enemiesSiegeTowerLocation && hasSiegeTower) {
            maisLonge = this.enemiesSiegeTowerLocation;
        }

        if (maisLonge == this.enemiesSiegeTowerLocation && hasSiegeTower) {
            this.enemiesSiegeTowerLocation--;
        }
        if (maisLonge == this.enemiesBattRamLocation) {
            this.enemiesBattRamLocation--;
        }
        if (maisLonge == this.enemiesLaddersLocation) {
            this.enemiesLaddersLocation--;
        }
    }

    public void AdvanceSiegeTower(int v) {
        if (hasSiegeTower) {
            this.enemiesSiegeTowerLocation -= v;
            if (this.enemiesSiegeTowerLocation == -1) {//se está a menos 1 vai para o close combat
                this.hasSiegeTower = false;
                AdvanceToCloseCombat(SIEGETOWERID);
            }
        }
    }
    
    public void AdvanceLadders(int v){
        if (hasLadderns) {
            this.enemiesLaddersLocation -= v;
            if (this.enemiesLaddersLocation == -1) {//se está a menos 1 vai para o close combat
                this.hasLadderns = false;
                AdvanceToCloseCombat(LADDERSID);
            }
        }
    }

    public void AdvanceBattRam(int v){
        if (hasBattRam) {
            this.enemiesBattRamLocation -= v;
            if (this.enemiesBattRamLocation == -1) {//se está a menos 1 vai para o close combat
                this.hasBattRam = false;
                AdvanceToCloseCombat(BATTRAMID);
            }
        }
    }
    
    public void RemoveSiegeTower() {
        if (this.enemiesSiegeTowerLocation == POSICAO_INICIAL) {
            this.hasSiegeTower = false;
        }
    }

    public void AddTrabuchet(int v) {
        if (this.enemiesTrebuchetCount < 3) {
            this.enemiesTrebuchetCount += v;
        }
    }

    public void AdvanceToCloseCombat(int id)  {
       int i;
        for ( i = 0; i < this.closeCombatUnits.length; i++) {
            if (this.closeCombatUnits[i] == 0) {
                this.closeCombatUnits[i] = id;
                return;
            } 
        }
        try {
        this.closeCombatUnits[i] = id;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("perdeu");
            //perde automaticamente 
        }
    }

    //////////////////// GETS E SETS
    public void setNomeJogador(String nome) {
        jog.setNomeJogador(nome);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getTurnActionPoints() {
        return turnActionPoints;
    }

    public void setTurnActionPoints(int turnActionPoints) {
        this.turnActionPoints = turnActionPoints;
    }

    public int getMoraleBonus() {
        return moraleBonus;
    }

    public void setMoraleBonus(int moraleBonus) {
        this.moraleBonus = moraleBonus;
    }

    public int getSabotageBonus() {
        return sabotageBonus;
    }

    public void setSabotageBonus(int sabotageBonus) {
        this.sabotageBonus = sabotageBonus;
    }

    public int getPlayerSupplies() {
        return playerSupplies;
    }

    public void setPlayerSupplies(int playerSupplies) {
        this.playerSupplies = playerSupplies;
    }

    public int getPlayerMorale() {
        return playerMorale;
    }

    public void setPlayerMorale(int playerMorale) {
        this.playerMorale = playerMorale;
    }

    public int getPlayerWallStrength() {
        return playerWallStrength;
    }

    public void setPlayerWallStrength(int playerWallStrength) {
        this.playerWallStrength = playerWallStrength;
    }

    public int getEnemiesLaddersLocation() {
        return enemiesLaddersLocation;
    }

    public void setEnemiesLaddersLocation(int enemiesLaddersLocation) {
        this.enemiesLaddersLocation = enemiesLaddersLocation;
    }

    public int getEnemiesSiegeTowerLocation() {
        return enemiesSiegeTowerLocation;
    }

    public void setEnemiesSiegeTowerLocation(int enemiesSiegeTowerLocation) {
        this.enemiesSiegeTowerLocation = enemiesSiegeTowerLocation;
    }

    public int getEnemiesTrebuchetCount() {
        return enemiesTrebuchetCount;
    }

    public void setEnemiesTrebuchetCount(int enemiesTrebuchetCount) {
        this.enemiesTrebuchetCount = enemiesTrebuchetCount;
    }

    public int getEnemiesBattRamLocation() {
        return enemiesBattRamLocation;
    }

    public void setEnemiesBattRamLocation(int enemiesBattRamLocation) {
        this.enemiesBattRamLocation = enemiesBattRamLocation;
    }

    public Jogador getJog() {
        return jog;
    }

    public void setJog(Jogador jog) {
        this.jog = jog;
    }

    public ArrayList<ArrayList<Card>> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<ArrayList<Card>> deck) {
        this.deck = deck;
    }

    public boolean isBadWheather() {
        return badWheather;
    }

    public void setBadWheather(boolean badWheather) {
        this.badWheather = badWheather;
    }

    public boolean isHasSiegeTower() {
        return hasSiegeTower;
    }

    public void setHasSiegeTower(boolean hasSiegeTower) {
        this.hasSiegeTower = hasSiegeTower;
    }

    public boolean isUnusedBoilingWater() {
        return unusedBoilingWater;
    }

    public void setUnusedBoilingWater(boolean unusedBoilingWater) {
        this.unusedBoilingWater = unusedBoilingWater;
    }

    public int getArchersAttBonus() {
        return laddersBonus;
    }

    public void setArchersAttBonus(int ArchersAttBonus) {
        this.laddersBonus = ArchersAttBonus;
    }

    public int getCloseCombatAttBonus() {
        return closeCombatAttBonus;
    }

    public void setCloseCombatAttBonus(int CloseCombatAttBonus) {
        this.closeCombatAttBonus = CloseCombatAttBonus;
    }

    public int getCoupureBonus() {
        return coupureBonus;
    }

    public void setCoupureBonus(int CoupureBonus) {
        this.coupureBonus = CoupureBonus;
    }

    public int getCircleSpacesBonus() {
        return circleSpacesBonus;
    }

    public void setCircleSpacesBonus(int circleSpacesBonus) {
        this.circleSpacesBonus = circleSpacesBonus;
    }

    public int getLaddersBonus() {
        return laddersBonus;
    }

    public void setLaddersBonus(int laddersBonus) {
        this.laddersBonus = laddersBonus;
    }

    public int getBattRamBonus() {
        return battRamBonus;
    }

    public void setBattRamBonus(int battRamBonus) {
        this.battRamBonus = battRamBonus;
    }

    public int getSiegeTowerBonus() {
        return siegeTowerBonus;
    }

    public void setSiegeTowerBonus(int siegeTowerBonus) {
        this.siegeTowerBonus = siegeTowerBonus;
    }

}
