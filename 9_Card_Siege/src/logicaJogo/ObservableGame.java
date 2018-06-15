
package logicaJogo;

import UiJogo.vista.gui.CardSiegeFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import logicaJogo.Cartas.Card;
import logicaJogo.Estados.IEstado;

public class ObservableGame extends Observable
{
    Jogo jogo;
    
    public ObservableGame()
    {
        jogo = new Jogo();
    }
    
    public Jogo getJogo()
    {
        return jogo;
    }

    public void setJogo(Jogo j)
    {
        jogo=j;        
        setChanged();
        notifyObservers();
    }
//    
//    public DadosJogo getJogoDados()
//    {
//        return jogo.getJogoDados();
//    }
    
//    public IStates getStates()
//    {
//        return jogo.getStates();
//    }   
//        public IStates getStates(){
//        return jogo.getStates();
//    }
    

    public IEstado getEstado(){
        return jogo.getEstado();
    }
    
    public void Terminar()
    {
        //jogo.Terminar();        
        setChanged();
        notifyObservers();
    }

    public void reiniciarJogo()
    {
        jogo.novoJogo();
    }
    public void novoJogo() 
    {
        jogo.comecarJogo();// novoJogo(); ???
        jogo.retirarCarta();
        setChanged();
        notifyObservers();
    }

    public void passarTurno() 
    {
        jogo.mudarTurno();
        jogo.retirarCarta();
        setChanged();
        notifyObservers();
    }
    
    public int getDia() 
    {
        return jogo.getDia();
    }
    
    public int getTurno() 
    {
        return jogo.getTurno();
    }
    
    public void voltarAcao() 
    {
        jogo.voltarAcao();
    }
    
    public void realizarAccaoExtraPoint() 
    {
        jogo.realizarAccaoExtraPoint();
    }

    public void realizarAccaoArchersAtt() 
    {
        jogo.realizarAccaoArchersAtt();
    }

    public void realizarAccaoBoilWater() 
    {
        jogo.realizarAccaoBoilWater();
    }

    public void realizarAccaoCloseCombat() 
    {
        jogo.realizarAccaoCloseCombat();
    }

    public void realizarAccaoCoupure() 
    {
        jogo.realizarAccaoCoupure();
        setChanged();
        notifyObservers();
    }

    public void realizarAccaoRallyTroops() 
    {
        jogo.realizarAccaoRallyTroops();
    }

    public void realizarAccaoTunnelMov() 
    {   
        jogo.realizarAccaoTunnelMov();
        setChanged();
        notifyObservers();
    }

    public void realizarAccaoSupplyRaid() 
    {
        jogo.realizarAccaoSupplyRaid();
        setChanged();
        notifyObservers();
    }

    public void realizarAccaoSabotage() 
    {
        jogo.realizarAccaoSabotage();
        setChanged();
        notifyObservers();
    }

    public boolean badWeather() 
    {
         return jogo.badWeather();
    }

    public boolean troopsInEnemyLines() 
    {
        return jogo.TroopsInEnemyLines();
    }

    public boolean troopsInCircleSpaces() 
    {
        return jogo.troopsInCircleSpaces();
    }

    public boolean unusedBoilingWater()
    {
        return jogo.unusedBoilingWater();
    }

    public boolean troopsInCloseCombat() 
    {
        return jogo.troopsIncloseCombat();
    }

    public int wallStrg() 
    {
        return jogo.wallStrg();
    }

    public int playerMorale() 
    {
        return jogo.playerMorale();
    }

    public int getPlayerSupplies()
    {
        return jogo.getPlayerSupplies();
    }
    
    public int[] getTunnel()
    {
        return jogo.getTunnel();
    }
    
    public int getSuppliesCarried()
    {
        return jogo.getSuppliesCarried();
    }
    
    public int getEnemiesLaddersLocation()
    {
        return jogo.getEnemiesLaddersLocation();
    }
        
    public int getEnemiesBattRamLocation()
    {
        return jogo.getEnemiesBattRamLocation();
    }
    
    public int getEnemiesSiegeTowerLocation()
    {
        return jogo.getEnemiesSiegeTowerLocation();
    }
   
    public int getEnemiesTrebuchetCount()
    {
        return jogo.getEnemiesTrebuchetCount();
    }
    
    public int[] closeCombatUnits()
    {
        return jogo.closeCombatUnits();
    }

    public String getCartaJogo() 
    {
       return jogo.getCartaJogo();
    }
    public int getTurnActionPoints()
    {
        return jogo.getTurnActionPoints();
    }

    public int getMoraleBonus() 
    {
        return jogo.getMoraleBonus();
    }

    public int getSabotageBonus() 
    {
       return jogo.getSabotageBonus();
    }
    
    public int getLaddersBonus()
    {
        return jogo.getLaddersBonus();
    }
    
    public int getBattRamBonus()
    {
        return jogo.getBattRamBonus();
    }
    
    public int getSiegeTowerBonus()
    {
        return jogo.getSiegeTowerBonus();
    }
   
    public int getCloseCombatAttBonus()
    {
        return jogo.getCloseCombatAttBonus();
    }
    
    public int getRaidBonus()
    {
        return jogo.getRaidBonus();
    }
    
    public int getCoupureBonus()
    {
        return jogo.getCoupureBonus();
    }
    
    public int getCircleSpacesBonus()
    {
        return jogo.getCircleSpacesBonus();
    }

    public void realizarExtraPoint(int i) 
    {
        jogo.realizarExtraPoint(i);
        setChanged();
        notifyObservers();
    }

    public boolean hasLaddres() 
    {    
        return jogo.hasLadders();
    }

    public boolean hasBattRam() 
    {
        return jogo.hasBattRam();
    }

    public boolean hasSiegeTower() 
    {
        return jogo.hasSiegeTower();
    }

    public void realizarArchersAttack(int i) 
    {
        jogo.realizarArchersAttack(i);
        setChanged();
        notifyObservers();
    }

    public String getLog() 
    {
        return jogo.getLog();
    }

    public boolean laddersIncircle() 
    {
       return jogo.laddersIncircle();
    }

    public boolean battRamInCircle() 
    {
        return jogo.battRamInCircle();
    }

    public boolean siegeTowerInCircle() 
    {
        return jogo.siegeTowerInCircle();
    }

    public void realizarBoilingWaterAttack(int i) 
    {
        jogo.realizarBoilingWaterAttack(i);
        setChanged();
        notifyObservers();
    }

    public void realizarCloseCombatAttack(int i)
    {
        jogo.realizarCloseCombatAttack(i);
        setChanged();
        notifyObservers();
    }

    public void realizarRallyTroops(int i) 
    {
        jogo.realizarRallyTroops(i);
        setChanged();
        notifyObservers();
    }

    public void realizarTunnelMovement(int i) 
    {
        jogo.realizarTunnelMovement(i);
        setChanged();
        notifyObservers();
    }

    public void carregarJogo(String nomeFicheiro) throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        GereFicheirosJogo.carregaJogo(nomeFicheiro);
    }

    public String sobre() 
    {
        return jogo.sobre();
    }

    public boolean troopsInsideTunnel() 
    {
        return jogo.troopsInsideTunnel();
    }

}
