
package UiJogo.vista.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;
import static UiJogo.vista.gui.ConstantesGUI.DIM_X_CARTA_JOGADOR;
import static UiJogo.vista.gui.ConstantesGUI.DIM_Y_CARTA_JOGADOR;

public class CartaJogoPanel extends JPanel implements ConstantesGUI
{
    private ObservableGame game;
    
    CartaJogoPanel(ObservableGame game) 
    {
        this.game = game;
        setTamanho();
    }
    
    private void setTamanho()
    {
        setBackground(new Color(0,0,0,0));
        setMaximumSize(new Dimension(DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO));
        setPreferredSize(new Dimension(DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO));
        setMinimumSize(new Dimension(DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO));        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        String s = new String();
        s = game.getCartaJogo();
        g.drawImage(CardSiegePanel.getImgCartaJogo(s),0, 0, DIM_X_CARTA_JOGO, DIM_Y_CARTA_JOGO, this);   
    }
    
    
}
