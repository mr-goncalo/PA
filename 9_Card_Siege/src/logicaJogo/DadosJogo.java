package logicaJogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import logicaJogo.Actions.*;
import logicaJogo.Cartas.*;

public class DadosJogo implements Constantes, Serializable {

    //Variaveis de Motor dejogo
    private String log;
    private int dia;
    private int turno;
    private boolean perdeu;
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
    private boolean troopsStartedInCastle;
    private boolean troopsStartedInEnemyLines;
    private boolean troopsEnteredInThisTurn;
    private boolean extraPointUsed;

    private boolean usedFreeMovement;

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

    //objectos das açoes
    private Action archersAttack;
    private Action boilingWaterAttack;
    private Action closeCombatAttack;
    private Action coupureAction;
    private Action rallyTroops;
    private Action supplyRaid;
    private Action sabotage;

    public DadosJogo() {
        jog = new Jogador("DEFAULT", this);
        suppliesCarried = 0;
        this.dia = 1;
        this.turno = 1;
        this.perdeu = false;
        this.turnActionPoints = 0;
        this.badWheather = false;
        this.hasSiegeTower = true;
        this.hasLadderns = true;
        this.hasBattRam = true;
        this.tunnel = new int[]{1, 0, 0, 0};
        this.unusedBoilingWater = true;
        this.LaddersInCircleSpace = false;
        this.BattRamInCircleSpace = false;
        this.SiegeTowerInCircleSpace = false;
        this.closeCombatUnits = new int[]{0, 0};
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
        this.enemiesLaddersLocation = 4;//1;
        this.enemiesSiegeTowerLocation = 4;//1;
        this.enemiesTrebuchetCount = 3;
        this.enemiesBattRamLocation = 4;
        this.troopsStartedInCastle = true;
        this.troopsStartedInEnemyLines = false;
        this.troopsEnteredInThisTurn = false;
        this.usedFreeMovement = false;

        extraPointUsed = false;

        archersAttack = new ArchersAttack("Archers Attack", 1);
        boilingWaterAttack = new BoilingWaterAttack("Boiling Water Attack", 1);
        closeCombatAttack = new CloseCombatAttack("Close Combat Attack", 1);
        coupureAction = new Coupure("Coupure", 1);
        rallyTroops = new RallyTroops("Rally Troops", 1);
        supplyRaid = new SupplyRaid("Supply Raid", 1);
        sabotage = new Sabotage("Sabotage", 1);
        this.log = "";
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

    public String toStringDados() {
        String s = new String();
        //s += "Dia: " + dia + " - Turno: " + turno;
        // s += deck.get(0).get(dia - 1).toString();

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
        s += (coupureBonus != 0 ? " Coupure Bonus: " + coupureBonus : "");
        s += (circleSpacesBonus != 0 ? " Circle Space Bonus: " + circleSpacesBonus : "");

        s += "\nPlayer Status: Morale: " + playerMorale + " Supplies: " + playerSupplies + " Wall strength: " + playerWallStrength;

        s += "\nEnemies Locations:";
        s += (CountEnemiesInCloseCombat() > 0 ? " Enemies in Close Combat: " + CountEnemiesInCloseCombat() : "");
        s += (hasLadderns ? " Ladders Location: " + enemiesLaddersLocation : "");
        s += (hasBattRam ? " Battering Ram: " + enemiesBattRamLocation : "");
        s += (hasSiegeTower ? " SiegeTower Location: " + enemiesSiegeTowerLocation : "");
        s += " Trebuchet Count: " + enemiesTrebuchetCount;
        s += "\n      \t|--------------|";
        s += "\nTunnel\t|" + (tunnel[0] == 1 ? " # " : "   ") + "|"
                + (tunnel[1] == 1 ? " # " : "   ") + "|"
                + (tunnel[2] == 1 ? " # " : "   ") + "|"
                + (tunnel[3] == 1 ? " #" : "  ") + "| \t Supplies Carried: " + suppliesCarried;
        s += "\n      \t|--------------|";
        return s;
    }

    public String toStringCarta() {
        String s = new String();
        s += "\nDia: " + dia + " - Turno: " + turno;
        s += deck.get(0).get(dia - 1).toString();
        return s;
    }

    public boolean troopsInEnemyLines() {
        return tunnel[tunnel.length - 1] == 1;
    }

    ///////////// funções do jogo 
    public void EnemyLineCheck() {
        // tunel array a primeira posição é o castelo a ultima é a linha do inimigo
        if (tunnel[tunnel.length - 1] == 1) {
            if (lancaDado() == 1) {
                tunnel[tunnel.length - 1] = 0;
                tunnel[0] = 1;
                suppliesCarried = 0;
                playerMorale--;
                log = "Your Troops have been captured!";
            }
        }
    }

    //Conta quantos inimigos estão no close combat area e retorna o numero.
    public int CountEnemiesInCloseCombat() {
        int cont = 0;
        for (int i = 0; i < closeCombatUnits.length; i++) {
            if (closeCombatUnits[i] == BATTRAMID || closeCombatUnits[i] == LADDERSID || closeCombatUnits[i] == SIEGETOWERID) {
                cont++;
            }
        }
        return cont;
    }

    // procura qual dos 3 está mais longe, caso haja empate avamçam todos os empatados
    public void AvancaMaisLonge() {
        int maisLonge;

        if (this.enemiesBattRamLocation >= this.enemiesLaddersLocation) {
            maisLonge = this.enemiesBattRamLocation;
        } else {
            maisLonge = this.enemiesLaddersLocation;
        }

        if (maisLonge < this.enemiesSiegeTowerLocation && hasSiegeTower) {//A siege tower pode ser destruida logo ao inicio faz a verificação 
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
        if (this.hasSiegeTower) {

            this.enemiesSiegeTowerLocation -= v;

            if (this.enemiesSiegeTowerLocation == 0) {//se está a 0 vai para o close combat
                this.hasSiegeTower = false; // a siege tower desaparece do tabuleiro e vai poara o close combat
                this.SiegeTowerInCircleSpace = false;
                AdvanceToCloseCombat(SIEGETOWERID);
            } else if (this.enemiesSiegeTowerLocation == 1) {
                this.SiegeTowerInCircleSpace = true;//mete a flag que a siege Tower está no circle spaces 
            }
            if (this.enemiesSiegeTowerLocation > 1) {
                this.SiegeTowerInCircleSpace = false;
            }
            if (this.enemiesSiegeTowerLocation > 4) {
                this.enemiesSiegeTowerLocation = 4;
            }
            if (this.enemiesSiegeTowerLocation < 0) {
                this.enemiesSiegeTowerLocation = 0;
            }
        }
    }

    public void AdvanceLadders(int v) {
        if (this.hasLadderns) {
            this.enemiesLaddersLocation -= v;
            if (this.enemiesLaddersLocation == 0) {//se está a 0 vai para o close combat
                this.hasLadderns = false;
                this.LaddersInCircleSpace = false;
                AdvanceToCloseCombat(LADDERSID);
            } else if (this.enemiesLaddersLocation == 1) {
                this.LaddersInCircleSpace = true;
            }
            if (this.enemiesLaddersLocation > 1) {
                this.LaddersInCircleSpace = false;
            }
            if (this.enemiesLaddersLocation > 4) {
                this.enemiesLaddersLocation = 4;
            }
            if (this.enemiesLaddersLocation < 0) {
                this.enemiesLaddersLocation = 0;
            }
        }
    }

    public void AdvanceBattRam(int v) {
        if (this.hasBattRam) {
            this.enemiesBattRamLocation -= v;
            if (this.enemiesBattRamLocation == 0) {//se está a 0 vai para o close combat
                this.hasBattRam = false;
                this.BattRamInCircleSpace = false;
                AdvanceToCloseCombat(BATTRAMID);
            } else if (this.enemiesBattRamLocation == 1) {
                this.BattRamInCircleSpace = true;
            }
            if (this.enemiesBattRamLocation > 1) {
                this.BattRamInCircleSpace = false;
            }
            if (this.enemiesBattRamLocation > 4) {
                this.enemiesBattRamLocation = 4;
            }
            if (this.enemiesBattRamLocation < 0) {
                this.enemiesBattRamLocation = 0;
            }
        }
    }

    public boolean AdvanceTurn() {
        Card c = deck.get(0).get(dia - 1);
        c.RemoveEventBonus(this);
        this.turnActionPoints = 0;
        this.unusedBoilingWater = true;
        this.troopsEnteredInThisTurn = false;

        usedFreeMovement = false;
        extraPointUsed = false;
        deck.remove(0);
        turno++;

        if (closeCombatUnits[0] != 0 && closeCombatUnits[1] != 0) {
            log = "Dois enimigos chegaram à área de combate! O jogador " + jog.getNomeJogador() + " perdeu o jogo!";
            return true;
        }
        if (playerMorale == 0 || playerSupplies == 0 || playerWallStrength == 0) {
            log = "Um dos seus recursos chegou a zero! O jogador " + jog.getNomeJogador() + " perdeu o jogo!";
            return true;
        }

        return false;
    }

    public void tracksAtZero() {
        int cont = 0;
        if (playerMorale == 0) {
            cont++;
        }

        if (playerSupplies == 0) {
            cont++;
        }

        if (playerWallStrength == 0) {
            cont++;
        }

        if (cont > 1) {
            perdeu = true;
        }
    }

    public boolean EndOfDay() {
        //Copia o deck original para o de jogo e baralha 
        deck.addAll(originalDeck);
        Collections.shuffle(deck);
        turnActionPoints = 0; // não deve ser necessario pois depois sai uma carta e volta a colocar o action point
        //Aumenta o dia 
        dia++;
        //reduz o supplies by 1 os aldeoes precisam de comer
        playerSupplies--;
        //reset ao turno
        turno = 1;

        //se no fim do dia existerem soldados no tunel adicionarmos os mantimentos
        if (tunnel[1] == 1 || tunnel[2] == 1) {
            playerSupplies = playerSupplies + getSuppliesCarried();
        }
        if (playerSupplies > 4) //até no máximo 4
        {
            playerSupplies = 4;
        }

        //os soldados no tunel voltam para o castelo
        //se os soldados estiveram na linha dos enimigos são capturados
        tunnel[0] = 1;
        tunnel[1] = 0;
        tunnel[2] = 0;
        tunnel[3] = 0;

        if (dia == 4) {
            log = "Fim dos 3 dias! O jogador " + jog.getNomeJogador() + " ganhou o jogo!";
            return true;
        }
        return false;
    }

    public boolean checkTwoEnemiesCloseCombat() {
        //verificar se existem inimigos na linha de combate para obrigar o jogador a combater no caso de haver 2
        if (closeCombatUnits[0] != 0 && closeCombatUnits[1] != 0) {
            log = "Existem dois enimigos na área de combate, deve combate-los!";
            return true;
        }
        return false;
    }

    public void DrawCard() {
        Card c = deck.get(0).get(dia - 1);
        c.AdvanceEnemies(this);
        c.ApplyEvent(this);
        c.TurnActionPoints(this);

    }

    public boolean troopsInCircleSpaces() {
        return this.LaddersInCircleSpace || this.BattRamInCircleSpace || this.SiegeTowerInCircleSpace;
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

            //perde automaticamente 
            perdeu = true;
        }
    }

    public boolean troopsInsideTunnel() {
        return tunnel[0] == 0 && tunnel[tunnel.length - 1] == 0;
    }

    // funbçoes das açoes
    public void repairWall() {// coupure
        coupureAction.ApplyRules(this);
        this.turnActionPoints -= archersAttack.getCost();

    }

    public void tunnelFreeMovement() {
        int i;
        for (i = 1; i < this.tunnel.length - 2; i++) {
            if (tunnel[i] == 1) {
                break;
            }
        }
        if (isTroopsInCastle()) { // As tropas estão a ir do castelo para as linhas enimigas 
            if (i == tunnel.length - 2) {
                troopsStartedInCastle = false;
                troopsStartedInEnemyLines = false;
                tunnel[i] = 0;
                tunnel[i + 1] = 1;
            } else {
                tunnel[i] = 0;
                tunnel[i + 1] = 1;
            }
        } else if (troopsStartedInEnemyLines) {// das linhas enimigas para o castelo 
            if (i == 1) {
                troopsStartedInEnemyLines = false;
                troopsStartedInCastle = false;
                tunnel[i] = 0;
                tunnel[i - 1] = 1;
                playerSupplies += suppliesCarried;
                if (playerSupplies > 4) {
                    playerSupplies = 4;
                }
                suppliesCarried = 0;
            } else {
                tunnel[i] = 0;
                tunnel[i - 1] = 1;
            }
        }
    }

    public void extraActionPoint(int v) {
        if (v == 1) {
            playerMorale--;
            turnActionPoints++;
            extraPointUsed = true;
        } else if (v == 2) {
            playerSupplies--;
            turnActionPoints++;
            extraPointUsed = true;
        }
    }

    @SuppressWarnings("empty-statement")
    public void tunnelFastMovement() {
        int i;
        for (i = 1; i < this.tunnel.length - 2 && tunnel[i] == 0; i++)
             ;
        if (troopsStartedInCastle) {
            tunnel[i] = 0;
            tunnel[tunnel.length - 1] = 1;
        } else {
            playerSupplies += suppliesCarried;
            if (playerSupplies > 4) {
                playerSupplies = 4;
            }
            suppliesCarried = 0;
            tunnel[i] = 0;
            tunnel[0] = 1;
        }

    }

    public void advanceTotunnel() {
        if (tunnel[0] == 1) {
            tunnel[0] = 0;
            tunnel[1] = 1;
            troopsStartedInEnemyLines = false;
            troopsStartedInCastle = true;
        } else if (tunnel[tunnel.length - 1] == 1) {
            tunnel[tunnel.length - 1] = 0;
            tunnel[tunnel.length - 2] = 1;
            troopsStartedInEnemyLines = true;
            troopsStartedInCastle = false;

        }
    }

    public void performRallyTroops(int bonus) {
        rallyTroops.ApplyRules(this, bonus);
    }

    public boolean ArchersAttack(int pista) {

        if (pista >= 1 && pista <= 3) {
            if (archersAttack.ApplyRules(this, pista) == -1) {
                return false;
            }
            this.turnActionPoints -= archersAttack.getCost();
            return true;
        } else {
            log = "Track selection error!";
            return false;
        }
    }

    public boolean boilingWaterAttack(int pista) {
        if (pista >= 1 && pista <= 3) {
            if (boilingWaterAttack.ApplyRules(this, pista) == -1) {
                return false;
            }
            this.turnActionPoints -= archersAttack.getCost();
            return true;
        } else {
            log = "Track selection error!";
            return false;
        }
    }

    public boolean closeCombatAttack(int track) {
        if (track == 0 || track == 1) {
            if (closeCombatAttack.ApplyRules(this, track) == -1) {
                return false;
            }
            this.turnActionPoints -= closeCombatAttack.getCost();
            return true;
        } else {
            log = "Track selection error!";
            return false;
        }
    }

    public boolean closeCombatAttack() {
        closeCombatAttack.ApplyRules(this);
        this.turnActionPoints -= closeCombatAttack.getCost();
        return true;
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

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        if (turno == 8) {
            this.turno = 1;
        } else {
            this.turno = turno;
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

    public boolean isHasLadderns() {
        return hasLadderns;
    }

    public void setHasLadderns(boolean hasLadderns) {
        this.hasLadderns = hasLadderns;
    }

    public boolean isHasBattRam() {
        return hasBattRam;
    }

    public void setHasBattRam(boolean hasBattRam) {
        this.hasBattRam = hasBattRam;
    }

    public boolean isLaddersInCircleSpace() {
        return LaddersInCircleSpace;
    }

    public void setLaddersInCircleSpace(boolean LaddersInCircleSpace) {
        this.LaddersInCircleSpace = LaddersInCircleSpace;
    }

    public boolean isBattRamInCircleSpace() {
        return BattRamInCircleSpace;
    }

    public void setBattRamInCircleSpace(boolean BattRamInCircleSpace) {
        this.BattRamInCircleSpace = BattRamInCircleSpace;
    }

    public boolean isSiegeTowerInCircleSpace() {
        return SiegeTowerInCircleSpace;
    }

    public void setSiegeTowerInCircleSpace(boolean SiegeTowerInCircleSpace) {
        this.SiegeTowerInCircleSpace = SiegeTowerInCircleSpace;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int[] getCloseCombatUnits() {
        return closeCombatUnits;
    }

    public void setCloseCombatUnits(int[] closeCombatUnits) {
        this.closeCombatUnits = closeCombatUnits;
    }

    public int[] getTunnel() {
        return tunnel;
    }

    public void setTunnel(int[] tunnel) {
        this.tunnel = tunnel;
    }

    public int getSuppliesCarried() {
        return suppliesCarried;
    }

    public void setSuppliesCarried(int suppliesCarried) {
        this.suppliesCarried = suppliesCarried;
    }

    public boolean isTroopsInCastle() {
        return troopsStartedInCastle;
    }

    public void setTroopsInCastle(boolean troopsInCastle) {
        this.troopsStartedInCastle = troopsInCastle;
    }

    public boolean isTroopsInEnemyLines() {
        return troopsStartedInEnemyLines;
    }

    public void setTroopsInEnemyLines(boolean troopsInEnemyLines) {
        this.troopsStartedInEnemyLines = troopsInEnemyLines;
    }

    public boolean isTroopsEnteredInThisTurn() {
        return troopsEnteredInThisTurn;
    }

    public void setTroopsEnteredInThisTurn(boolean troopsEnteredInThisTurn) {
        this.troopsEnteredInThisTurn = troopsEnteredInThisTurn;
    }

    public boolean isUsedFreeMovement() {
        return usedFreeMovement;
    }

    public void setUsedFreeMovement(boolean usedFreeMovement) {
        this.usedFreeMovement = usedFreeMovement;
    }

    public Action getSupplyRaid() {
        return supplyRaid;
    }

    public void setSupplyRaid(Action supplyRaid) {
        this.supplyRaid = supplyRaid;
    }

    public Action getSabotage() {
        return sabotage;
    }

    public void setSabotage(Action sabotage) {
        this.sabotage = sabotage;
    }

    public boolean isExtraPointUsed() {
        return extraPointUsed;
    }

    public void setExtraPointUsed(boolean extraPointUsed) {
        this.extraPointUsed = extraPointUsed;
    }

    public boolean isPerdeu() {
        return perdeu;
    }

    public void setPerdeu(boolean perdeu) {
        this.perdeu = perdeu;
    }

}
