
package UiJogo.vista.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import logicaJogo.Cartas.Card;
import logicaJogo.ObservableGame;

public class CartaJogadorPanel extends JPanel implements ConstantesGUI
{
    private ObservableGame game;
    
    public CartaJogadorPanel(ObservableGame game)
    {
        this.game=game;
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
        g.drawImage(CardSiegePanel.getImgCartaJogador(), 0, 0, DIM_X_CARTA_JOGADOR, DIM_Y_CARTA_JOGADOR, this);   
//        setPosicaoSupplies(g);
//        setPosicaoMorale(g);
//        setPosicaoWallStrength(g);
//        setPosicaoTunnel(g);
//        setPosicaoSuppliesCarried(g);
//        
    }

    private void setPosicaoSupplies(Graphics g) 
    {
        
    }

    private void setPosicaoMorale(Graphics g) 
    {
        
    }
    
    private void setPosicaoWallStrength(Graphics g) 
    {
       
    }

    private void setPosicaoTunnel(Graphics g) 
    {
       
    }


    private void setPosicaoSuppliesCarried(Graphics g)
    {
       
    }

  

}
