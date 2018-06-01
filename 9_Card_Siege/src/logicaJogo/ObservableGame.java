
package logicaJogo;

import UiJogo.vista.gui.CardSiegeFrame;
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

    public int getTurno() 
    {
        return jogo.getTurno();
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
    }

    public void realizarAccaoRallyTroops() 
    {
        jogo.realizarAccaoRallyTroops();
    }

    public void realizarAccaoTunnelMov() 
    {   
        jogo.realizarAccaoTunnelMov();
    }

    public void realizarAccaoSupplyRaid() 
    {
        jogo.realizarAccaoSupplyRaid();
    }

    public void realizarAccaoSabotage() 
    {
        jogo.realizarAccaoSabotage();
    }
}
