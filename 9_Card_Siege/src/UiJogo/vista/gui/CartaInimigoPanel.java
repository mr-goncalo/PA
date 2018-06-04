
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
        setPosicaoLadders(g);
        setPosicaoSiegeTower(g);
        setPosicaoBattRam(g);
        setPosicaoTrebuchet(g);
    }

    private void setPosicaoLadders(Graphics g) 
    {
        
        int x = 47;
        int y = 20;
        boolean closeCombat=false;
        switch(game.getEnemiesLaddersLocation()) 
        { 
            case 4:
                y = 440;
                break;
            case 3:
                y = 335;
                break;
            case 2:
                y = 225;
                break;
            case 1:
                y = 120;
                break;
            case 0:
                closeCombat=true;
                break;
        }
        if(closeCombat)
        {
            int cc[] = game.closeCombatUnits();
            if(cc[0]==1)
            {
                x = 165;
                y = 20;
            }
            else if(cc[1]==1)
            {
                x = 235;
                y = 20;
            }  
        }
        g.drawImage(CardSiegePanel.getImgMarcadorInimigo(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
    }

    private void setPosicaoBattRam(Graphics g) 
    {
        int x = 200;
        int y = 20;
        boolean closeCombat=false;
        switch(game.getEnemiesBattRamLocation()) 
        { 
            case 4:
                y = 440;
                break;
            case 3:
                y = 335;
                break;
            case 2:
                y = 225;
                break;
            case 1:
                y = 120;
                break;
            case 0:
                closeCombat=true;
                break;
        }
        if(closeCombat)
        {
            int cc[] = game.closeCombatUnits();
            if(cc[0]==2)
            {
                x = 165;
                y = 20;
            }
            else if(cc[1]==2)
            {
                x = 235;
                y = 20;
            }     
        }
        g.drawImage(CardSiegePanel.getImgMarcadorInimigo(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
    }

    private void setPosicaoSiegeTower(Graphics g) 
    {
        int x = 353;
        int y = 20;
        boolean closeCombat=false;
        switch(game.getEnemiesSiegeTowerLocation()) 
        { 
            case 4:
                y = 440;
                break;
            case 3:
                y = 335;
                break;
            case 2:
                y = 225;
                break;
            case 1:
                y = 120;
                break;
            case 0:  
                closeCombat=true;
                break;
        }
        
        if(closeCombat)
        {   
            int cc[] = game.closeCombatUnits();
            if(cc[0]==3)
            {
                x = 165;
                y = 20;
            }
            else if(cc[1]==3)
            {
                x = 235;
                y = 20;
            }  
        }
        g.drawImage(CardSiegePanel.getImgMarcadorInimigo(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
    }

    private void setPosicaoTrebuchet(Graphics g) 
    {
        int x = 0;
        int y = 567;
        boolean zeroTrabuchets = false;
        switch(game.getEnemiesTrebuchetCount()) 
        { 
            case 3:
                x = 353;
                break;
            case 2:
                x = 200;
                break;
            case 1:
                x = 47;
                break;
            default:
                y=0;
                zeroTrabuchets=true;
        }
        if(!zeroTrabuchets)
            g.drawImage(CardSiegePanel.getImgMarcadorInimigo(),x, y, DIM_X_MARCADOR_PRINCIPAL, DIM_Y_MARCADOR_PRINCIPAL, this); 
        else
            g.drawImage(CardSiegePanel.getImgMarcadorInimigo(),x, y, 0, 0, this);          
    }

}
