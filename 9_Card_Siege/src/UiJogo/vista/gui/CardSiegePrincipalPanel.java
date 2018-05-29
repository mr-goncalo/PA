
package UiJogo.vista.gui;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import logicaJogo.Estados.AguardaInicio;
import logicaJogo.Estados.FimJogo;
import logicaJogo.ObservableGame;
import logicaJogo.Estados.IEstado;

public class CardSiegePrincipalPanel extends JPanel implements Observer, ConstantesGUI
{
    
    ObservableGame game;
    CardSiegePanel gamePanel;
    CardSiegePanelStart startPanel;
    CardSiegePanelEnd endPanel;
          
    CardLayout cardManager = new CardLayout();
   

    CardSiegePrincipalPanel(ObservableGame game) 
    {
        this.game=game;
        this.game.addObserver(this);             
        setupComponents();
        setupLayout();   
        update(this.game, null);
    }
    
    private void setupComponents()
    {
        startPanel = new CardSiegePanelStart(game);
        gamePanel = new  CardSiegePanel(game);
        endPanel = new CardSiegePanelEnd(game);
        
    }

    private void setupLayout()
    {
        setLayout(cardManager);
        add(startPanel, "start"); 
        add(gamePanel, "game"); 
        add(endPanel, "end");        
        validate();
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        IEstado estado = game.getStates();
        
        if(estado instanceof AguardaInicio )
        {
            cardManager.show(this, "start");
        }
        else if(estado instanceof FimJogo)
        { 
            cardManager.show(this, "end");
        }else
        {           
           cardManager.show(this, "game");
        }
    }

    
}
