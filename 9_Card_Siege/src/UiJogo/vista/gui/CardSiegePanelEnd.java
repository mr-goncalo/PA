
package UiJogo.vista.gui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;

public class CardSiegePanelEnd extends JPanel implements Observer, ConstantesGUI
{
    CardSiegePanelEnd(ObservableGame game) 
    {
        
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
