
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
        setPosicaoSupplies(g);
        setPosicaoMorale(g);
        setPosicaoWallStrength(g);
        setPosicaoTunnel(g);
        setPosicaoSuppliesCarried(g);
      
    }

    private void setPosicaoSupplies(Graphics g) 
    {
        int x = 330;
        int y = 0;

        switch(game.getPlayerSupplies()) 
        { 
            case 4:
                y = 25;
                break;
            case 3:
                y = 135;
                break;
            case 2:
                y = 240;
                break;
            case 1:
                y = 345;
                break;
            case 0:
                x = 185;
                y = 460;
                break;
        }
        g.drawImage(CardSiegePanel.getImgMarcadorJogador(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
    }

    private void setPosicaoMorale(Graphics g) 
    {
        int x = 185;
        int y = 0;

        switch(game.playerMorale()) 
        { 
            case 4:
                y = 25;
                break;
            case 3:
                y = 135;
                break;
            case 2:
                y = 240;
                break;
            case 1:
                y = 345;
                break;
            case 0:
                y = 460;
                break;   
        }
        g.drawImage(CardSiegePanel.getImgMarcadorJogador(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
    }
    
    private void setPosicaoWallStrength(Graphics g) 
    {
        int x = 42;
        int y = 0;
        
        switch(game.wallStrg()) 
        { 
            case 4:
                y = 25;
                break;
            case 3:
                y = 135;
                break;
            case 2:
                y = 240;
                break;
            case 1:
                y = 345;
                break;
            case 0:
                x = 185;
                y = 460;
                break;   

        }
        g.drawImage(CardSiegePanel.getImgMarcadorJogador(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 

    }

    private void setPosicaoTunnel(Graphics g) 
    {
        
        int tunnel[] = game.getTunnel();
        int x = 0;
        int y = 570;

        if(tunnel[0]==1)
            x=20;
        if(tunnel[1]==1)
            x=90;
        if(tunnel[2]==1)
            x=150;
        if(tunnel[3]==1)
            x=237;
        
        g.drawImage(CardSiegePanel.getImgMarcadorTunnel(),x, y, DIM_X_MARCADOR_SECUNDARIO, DIM_Y_MARCADOR_SECUNDARIO, this); 
        
    }

    private void setPosicaoSuppliesCarried(Graphics g)
    {
        int x = 343;
        int y = 0;
        boolean zeroSC=false;

        switch(game.getSuppliesCarried()) 
        { 
            case 1:
                y=568; 
                break;
            case 2:
                 y=492;   
                 break;
            default:
                zeroSC=true;
        }
        if(!zeroSC)
            g.drawImage(CardSiegePanel.getImgMarcadorSupplies(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
                    
    }

  

}
