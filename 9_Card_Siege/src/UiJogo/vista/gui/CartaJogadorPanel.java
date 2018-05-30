
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
      setMaximumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
      setPreferredSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
      setMinimumSize(new Dimension(DIM_X_CARTA, DIM_Y_CARTA));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        g.drawImage(CardSiegePanel.getImgCartaJogador(),0, 0, DIM_X_CARTA, DIM_Y_CARTA, this);   
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
