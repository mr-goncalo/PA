
package UiJogo.vista.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;

public class CartaFundoPanel extends JPanel implements ConstantesGUI
{
     private ObservableGame game;
    
    public CartaFundoPanel(ObservableGame game)
    {
        this.game=game;
        setTamanho();
    }
    
    private void setTamanho()
    {
        setMaximumSize(new Dimension(DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO));
        setPreferredSize(new Dimension(DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO));
        setMinimumSize(new Dimension(DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        g.drawImage(CardSiegePanel.getImgCartaFundo(),0, 0, DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO, this);   
    }

}
