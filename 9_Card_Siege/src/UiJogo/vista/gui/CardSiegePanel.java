
package UiJogo.vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import logicaJogo.Cartas.Card;
import logicaJogo.ObservableGame;

public class CardSiegePanel extends JPanel implements Observer, ConstantesGUI
{


    ObservableGame game;
    CartaJogadorPanel cartaJogadorPanel;
    static private BufferedImage fundo = null;
    static private BufferedImage cartaJogador = null;
    static private BufferedImage cartaInimigo = null;
    static private BufferedImage cartaVerso = null;
    static Map<String, Image> cartas;
    
    JPanel JPanelCartas;
    JLabel anoLabel;
    
    
    static
    {
        cartas = new HashMap<String, Image>();
        try 
        {
            cartas.put(CARTA1, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD1)));
            cartas.put(CARTA2, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD2)));
            cartas.put(CARTA3, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD3)));
            cartas.put(CARTA4, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD4)));
            cartas.put(CARTA5, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD5)));
            cartas.put(CARTA6, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD6)));
            cartas.put(CARTA7, ImageIO.read(Resources.getResourceFile(PATH_IMG_CARD7)));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CardSiegePanel.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    static 
    {
        try 
        {              
            cartaJogador = ImageIO.read(Resources.getResourceFile("imagens/cartaJogador.png"));            
            cartaInimigo = ImageIO.read(Resources.getResourceFile("imagens/cartaInimigo.png"));
            cartaVerso = ImageIO.read(Resources.getResourceFile("imagens/cartaVerso.png"));
            fundo = ImageIO.read(Resources.getResourceFile("imagens/fundo.png"));            
        } 
        catch (IOException e) 
        {
            System.out.println("Erro a carregar imagens!");
        }
    }
    
    public CardSiegePanel(ObservableGame game) 
    {
        this.game=game;   
        this.game.addObserver(this);

        setupComponents();
        setupLayout();

        update(this.game, null);

        validate();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(getImgFundo(), 0, 0, getWidth(), getHeight(), this);
        
    }
    private void setupComponents()
    {
        //panel com info e os listeners
        
        cartaJogadorPanel = new CartaJogadorPanel(game);
 
           anoLabel = new JLabel("Ano: ");
         anoLabel.setFont(new Font("Arial", Font.BOLD,58));
        anoLabel.setAlignmentX(TOP_ALIGNMENT);
        anoLabel.setForeground(Color.BLACK);
    }
    
    private void setupLayout()
    {
        JPanelCartas.add(cartaJogadorPanel);
//        Box principal = Box.createVerticalBox();
        Box h = Box.createHorizontalBox();
//        Box horizontal = Box.createHorizontalBox();
        h.add(anoLabel);
 //       principal.setBorder(new LineBorder(Color.blue));
        h.setBorder(new LineBorder(Color.GREEN));
      //  add(h, BorderLayout.SOUTH);
        validate();
        //------------------------------------------------------------------------------------------//
    }
    
    
    @Override
    public void update(Observable o, Object o1) 
    {
        
        repaint(); 
        anoLabel.setText("Ano: ");
        //...
    }
    
    public static Image getImgCarta(String nomeCarta)
    {
        return cartas.get(nomeCarta);
    }
     
    public static BufferedImage getImgCartaJogador()
    {
        return cartaJogador;
    }
    
    public static BufferedImage getImgFundo() 
    {
        return fundo;
    }
 
}
