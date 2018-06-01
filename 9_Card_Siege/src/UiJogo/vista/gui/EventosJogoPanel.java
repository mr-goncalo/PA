
package UiJogo.vista.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import javax.swing.JPanel;
import logicaJogo.ObservableGame;

public class EventosJogoPanel extends JPanel implements ConstantesGUI
{
    private ObservableGame game;

    public EventosJogoPanel(ObservableGame game) 
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
        int x=0,y=0;
        g.fillRect(x, y, DIM_X_CARTA_JOGADOR, DIM_Y_CARTA_JOGADOR);
       
//        
//        Evento eventoAtual = observableGame.getCurrentEvento();
//        
//        if(eventoAtual!= null){      
//       
//            String nome = eventoAtual.getNome();
//        
//       
//            Image imagem = MicroSpaceEmpirePanel.getEventImg(nome);
//            
//            if (imagem != null){
//                // System.out.println("vou pintar a imagem");
//                g.drawImage( imagem, x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
//            }else{
//                System.err.println(" imagem == null");
//            }
//        }  else{
//         g.drawImage( MicroSpaceEmpirePanel.getEventImg(EVENT), x , y ,DIM_X_CARTA, DIM_Y_CARTA, this );
//        }
    
    }
    
}
