
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
        setChanged();
        notifyObservers();
    }
}
