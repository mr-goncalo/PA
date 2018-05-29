
package logicaJogo;

import UiJogo.vista.gui.CardSiegeFrame;
import java.util.List;
import java.util.Observable;
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
    
    public void addObserver(CardSiegeFrame aThis) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IEstado getStates(){
        return jogo.getEstado();
    }
    
}
