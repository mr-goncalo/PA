
package UiJogo.vista.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;
import static UiJogo.vista.gui.ConstantesGUI.DIM_X_CARTA_JOGADOR;
import static UiJogo.vista.gui.ConstantesGUI.DIM_Y_CARTA_JOGADOR;


public class CartaInimigoPanel extends JPanel implements ConstantesGUI
{
    private ObservableGame game;
    
    CartaInimigoPanel(ObservableGame game) 
    {
        this.game = game;
        setTamanho();
    }
    
    private void setTamanho()
    {
        setBackground(new Color(0,0,0,0));
        setMaximumSize(new Dimension(DIM_X_CARTA_JOGADOR, DIM_Y_CARTA_JOGADOR));
        setPreferredSize(new Dimension(DIM_X_CARTA_JOGADOR, DIM_Y_CARTA_JOGADOR));
        setMinimumSize(new Dimension(DIM_X_CARTA_JOGADOR, DIM_Y_CARTA_JOGADOR));        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(CardSiegePanel.getImgCartaInimigo(),0, 0, DIM_X_CARTA_JOGADOR, DIM_Y_CARTA_JOGADOR, this);   
    }
    
}
