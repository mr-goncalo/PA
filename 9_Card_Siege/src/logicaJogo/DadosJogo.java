package logicaJogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import logicaJogo.Cartas.*;

public class DadosJogo implements Constantes, Serializable {

    //Variaveis de Motor dejogo
    private int dia;
    private int ronda;
    private ArrayList<ArrayList<Card>> deck;
    private ArrayList<ArrayList<Card>> originalDeck;
    private int turnActionPoints;
    private boolean badWheather;
    private boolean hasSiegeTower;
    private boolean hasLadderns;
    private boolean hasBattRam;
    private boolean unusedBoilingWater;
    private boolean LaddersInCircleSpace;
    private boolean BattRamInCircleSpace;
    private boolean SiegeTowerInCircleSpace;
    private int[] closeCombatUnits;

    //Variaveis de Bonus
    private int laddersBonus;
    private int battRamBonus;
    private int siegeTowerBonus;
    private int closeCombatAttBonus;
    private int raidBonus;
    private int coupureBonus;
    private int moraleBonus;
    private int sabotageBonus;
    private int circleSpacesBonus;

    //Variaveis Status card jogador
    private int playerSupplies;
    private int playerMorale;
    private int playerWallStrength;
    private int[] tunnel;
    private int suppliesCarried;

    // Variaveis Tracks cards dos enimigos
    private int enemiesLaddersLocation;
    private int enemiesSiegeTowerLocation;
    private int enemiesTrebuchetCount;
    private int enemiesBattRamLocation;

    private Jogador jog;

    public DadosJogo() {
        jog = new Jogador("DEFAULT", this);
        suppliesCarried = 0;
        this.dia = 1;
        this.ronda = 0;
        this.turnActionPoints = 0;
        this.badWheather = false;
        this.hasSiegeTower = true;
        this.hasLadderns = true;
        this.hasBattRam = true;
        this.tunnel = new int[]{0, 0, 0, 0};
        this.unusedBoilingWater = true;
        this.LaddersInCircleSpace = false;
        this.BattRamInCircleSpace = false;
        this.SiegeTowerInCircleSpace = false;
        this.closeCombatUnits = new int[3];
        this.laddersBonus = 0;
        this.battRamBonus = 0;
        this.siegeTowerBonus = 0;
        this.closeCombatAttBonus = 0;
        this.raidBonus = 0;
        this.coupureBonus = 0;
        this.moraleBonus = 0;
        this.sabotageBonus = 0;
        this.circleSpacesBonus = 0;
        this.playerSupplies = 4;
        this.playerMorale = 4;
        this.playerWallStrength = 4;
        this.enemiesLaddersLocation = 4;
        this.enemiesSiegeTowerLocation = 4;
        this.enemiesTrebuchetCount = 3;
        this.enemiesBattRamLocation = 4;

        deck = new ArrayList<>();
        originalDeck = new ArrayList<>();

        List<Card> card1 = new ArrayList<>();
        List<Card> card2 = new ArrayList<>();
        List<Card> card3 = new ArrayList<>();
        List<Card> card4 = new ArrayList<>();
        List<Card> card5 = new ArrayList<>();
        List<Card> card6 = new ArrayList<>();
        List<Card> card7 = new ArrayList<>();

        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T - 2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 3));
        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T - 2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 2));
        card1.add(new TrebuchetAttack("Trebuchet Attack", "3T - 2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 1));

        card2.add(new Illness("Illness", "Reduce morale by 1 \n\t| Reduce supplies by 1", 2));
        card2.add(new GuardsDistracted("Guards Distracted", "+1 to sabotage action \n\t| +1 to morale action", 2));
        card2.add(new TrebuchetAttack("Trebuchet Attack", "3T -2 Damage to wall \n\t| 2T - 1 Damage to wall \n\t| 1T - 1 Damage to wall on Dice roll of 4,5,6", 1));

        card3.add(new SuppliesSpoiled("Supplies Spoiled", "Reduce supplies by 1", 2));
        card3.add(new BadWeather("Bad Weather", "Only raid and sabotage actions allowed this turn", 2));
        card3.add(new BoilingOil("Boiling Oil", "+2 to attacks on enemy units in circle spaces ", 2));

        card4.add(new DeathOfALeader("Death of a Leader", "Reduce moral by 1", 2));
        card4.add(new GateFortified("Gate Fortified", "+1 attacks on the Battering Ram", 2));
        card4.add(new FlamingArrows("Flaming Arrows", "+1 to attacks on the Siege Engine", 3));

        card5.add(new VolleyOfArrows("Volley of Arrows", "+1 to all attacks", 3));
        card5.add(new Collapsed("Collapsed", "Siege Tower removed from game if on starting space", 2));
        card5.add(new RepairedTrebuchet("Repaired Trebuchet", "Add 1 Trebuchet (max 3) \n\t| +1 to Coupure action", 2));

        card6.add(new CoverOfDarkness("Cover of Darkness", "+1 to Raid and Sabotade actions", 3));
        card6.add(new EnemyFatigue("Enemy Fatigue", "+1 to Coupure, Raid and Sabotage actions", 3));
        card6.add(new Rally("Rally", "+1 to attacks on Close Combant or Circle Spaces", 3));

        card7.add(new DeterminedEnemy("Determined Enemy", "-1 to attacks on the Battering Ram", 2));
        card7.add(new IronShields("Iron Shields", "-1 to attacks on the Siege Tower", 2));
        card7.add(new Faith("Faith", "+1 to attacks on the Battering Ram,Ladders and Morale actions", 3));

        originalDeck.add((ArrayList<Card>) card1);
        originalDeck.add((ArrayList<Card>) card2);
        originalDeck.add((ArrayList<Card>) card3);
        originalDeck.add((ArrayList<Card>) card4);
        originalDeck.add((ArrayList<Card>) card5);
        originalDeck.add((ArrayList<Card>) card6);
        originalDeck.add((ArrayList<Card>) card7);

        deck.addAll(originalDeck);
        Collections.shuffle(deck);

    }

    @Override
    public String toString() {
        String s = new String();
        s += "Dia: " + dia;
        s += deck.get(0).get(dia - 1).toString();

        //Mostra apenas os bonus que tem para o turno
        s += "Player Action Points: " + turnActionPoints;
        s += "\nPlayer Bonus: ";
        s += (moraleBonus != 0 ? "Morale Actions Bonus : " + moraleBonus : "");
        s += (sabotageBonus != 0 ? " Sabotage Bonus: " + sabotageBonus : "");
        s += (laddersBonus != 0 ? " Ladders Bonus: " + laddersBonus : "");
        s += (battRamBonus != 0 ? " Battering Ram Bonus: " + battRamBonus : "");
        s += (siegeTowerBonus != 0 ? " Siege Tower Bonus: " + siegeTowerBonus : "");
        s += (closeCombatAttBonus != 0 ? " Close Combat Bonus: " + closeCombatAttBonus : "");
        s += (raidBonus != 0 ? " Raid Bonus" + raidBonus : "");
        s += (coupureBonus != 0 ? "Coupure Bonus: " + coupureBonus : "");
        s += (circleSpacesBonus != 0 ? " Circle Space Bonus: " + circleSpacesBonus : "");

        s += "\nPlayer Status: morale: " + playerMorale + " Supplies: " + playerSupplies + " Wall strength: " + playerWallStrength;

        s += "\nEnemies Locations:";
        s += (CountEnemiesInCloseCombat() > 0 ? " Enemies in Close Combat: " + CountEnemiesInCloseCombat() : "");
        s += (hasBattRam ? "B attering Ram: " + enemiesBattRamLocation : "");
        s += (hasLadderns ? " Ladders Location: " + enemiesLaddersLocation : "");
        s += (hasSiegeTower ? " SiegeTower Location: " + enemiesSiegeTowerLocation : "");
        s += " Trebuchet Count: " + enemiesTrebuchetCount;

        return s;
    }

    ///////////// funções do jogo 
    public void EnemyLineCheck() {

        // tunel array a primeira posição é o castelo a ultima é a linha do inimigo
        if (tunnel[tunnel.length - 1] == 1) {
            if (lancaDado() == 1) {
                tunnel[tunnel.length - 1] = 0;
                suppliesCarried = 0;
                playerMorale--;
            }
        }
    }

    public int CountEnemiesInCloseCombat() {
        int cont = 0;
        for (int i = 0; i < closeCombatUnits.length; i++) {
            if (closeCombatUnits[i] == BATTRAMID || closeCombatUnits[i] == LADDERSID || closeCombatUnits[i] == SIEGETOWERID) {
                cont++;
            }
        }
        return cont;
    }

    public String DrawedCardToString() {
        return deck.get(0).get(dia - 1).toString();
    }

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
            if (this.enemiesSiegeTowerLocation == 0) {//se está a 0 vai para o close combat
                this.hasSiegeTower = false;
                AdvanceToCloseCombat(SIEGETOWERID);
            } else if (this.enemiesSiegeTowerLocation == 1) {
                this.SiegeTowerInCircleSpace = true;
            }

            if (this.enemiesSiegeTowerLocation > 4) {
                this.enemiesSiegeTowerLocation = 4;
            }
        }
    }

    public void AdvanceLadders(int v) {
        if (hasLadderns) {
            this.enemiesLaddersLocation -= v;
            if (this.enemiesLaddersLocation == 0) {//se está a 0 vai para o close combat
                this.hasLadderns = false;
                AdvanceToCloseCombat(LADDERSID);
            } else if (this.enemiesLaddersLocation == 1) {
                this.LaddersInCircleSpace = true;
            }

            if (this.enemiesLaddersLocation > 4) {
                this.enemiesLaddersLocation = 4;
            }
        }
    }

    public void AdvanceBattRam(int v) {
        if (hasBattRam) {
            this.enemiesBattRamLocation -= v;
            if (this.enemiesBattRamLocation == 0) {//se está a 0 vai para o close combat
                this.hasBattRam = false;
                AdvanceToCloseCombat(BATTRAMID);
            } else if (this.enemiesBattRamLocation == 1) {
                this.BattRamInCircleSpace = true;
            }
            if (this.enemiesBattRamLocation > 4) {
                this.enemiesBattRamLocation = 4;
            }
        }
    }

    public void AdvanceTurn() {
        Card c = deck.get(0).get(dia - 1);
        c.RemoveEventBonus(this);
        turnActionPoints = 0;
        deck.remove(0);

        //Check enemie lines etc etc -.....
    }

    public void EndOfDay() {

        //Copia o deck original para o de jogo e baralha 
        deck.addAll(originalDeck);
        Collections.shuffle(deck);

        //Aumenta o dia 
        dia++;
        //reduz o supplies by 1 os aldeoes precisam de comer
        playerSupplies--;

        //os soldados no tunel voltam para o castelo. 
        //Ainda por implementar
        //se os soldados estiveram na linha dos enimigos são capturados
        //ainda por implementar
        // se o dia == 4 é porque sobrevivemos os 3 dias e ganhamos os jogo
    }

    public void DrawCard() {
        Card c = deck.get(0).get(dia - 1);
        c.AdvanceEnemies(this);
        c.ApplyEvent(this);
        c.TurnActionPoints(this);

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

    public void AdvanceToCloseCombat(int id) {
        int i;
        for (i = 0; i < this.closeCombatUnits.length; i++) {
            if (this.closeCombatUnits[i] == 0) {
                this.closeCombatUnits[i] = id;
                return;
            }
        }
        try {
            this.closeCombatUnits[i] = id;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("perdeu");
            //perde automaticamente 
        }
    }

    public int lancaDado() {
        Dado d = new Dado();
        return d.LancaDado();
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

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        if (ronda == 8) {
            this.ronda = 1;
        } else {
            this.ronda = ronda;
        }
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

    public int getRaidBonus() {
        return raidBonus;
    }

    public void setRaidBonus(int raidBonus) {
        this.raidBonus = raidBonus;
    }

    public boolean DeckEmpty() {
        return deck.isEmpty();
    }

}
