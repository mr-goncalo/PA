
package UiJogo.vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import jdk.nashorn.internal.objects.NativeObject;
import logicaJogo.Cartas.Card;
import logicaJogo.ObservableGame;

public class CardSiegePanel extends JPanel implements Observer, ConstantesGUI
{

 

   
    ObservableGame game;
    CartaFundoPanel cartaFundoPanel;
    CartaJogoPanel cartaJogoPanel;
    CartaJogadorPanel cartaJogadorPanel;
    CartaInimigoPanel cartaInimigoPanel;
    
    static private BufferedImage fundo = null;
    static private BufferedImage cartaJogador = null;
    static private BufferedImage cartaInimigo = null;
    static private BufferedImage cartaVerso = null;
    static HashMap<String, Image> cartas;
    static ArrayList<String> nomeCartas;
 
    JPanel jPanelCartasJogo;
    JPanel jPanelCartasJogadores;
    JPanel jPanelAcoes;
    
    JButton btnPassarTurno;
    JButton btnExtraActionPoint;
    JButton btnArchersAttack;
    JButton btnBoillingWaterAttack;
    JButton btnCloseCombatAttack;         
    JButton btnCoupure;
    JButton btnRallyTroops;
    JButton btnTunnelMovement;
    JButton btnSupplyRaid;
    JButton btnSabotage;
    
    JLabel lblDia;        
    JLabel lblTurno;
    
    
//    private void carregaImgCartas()
//    {
      
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

      // [...] fill the map


            
        }
//
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
//        }
    }
    public CardSiegePanel(ObservableGame game) 
    {
        nomeCartas = new ArrayList();
        nomeCartas.add(CARTA1);
        nomeCartas.add(CARTA2);
        nomeCartas.add(CARTA3);
        nomeCartas.add(CARTA3);
        nomeCartas.add(CARTA4);
        nomeCartas.add(CARTA5);
        nomeCartas.add(CARTA6);
        nomeCartas.add(CARTA7);
        Collections.shuffle(nomeCartas);
        this.game=game;   
        this.game.addObserver(this);
//        carregaImgCartas();
        setupComponents();
        setupLayout();

        update(this.game, null);

        validate();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(getImgCartaFundo(), 0, 0, getWidth(), getHeight(), this);
        
    }
    private void setupComponents()
    {
        cartaFundoPanel = new CartaFundoPanel(game);
        cartaJogoPanel = new CartaJogoPanel(game);
        cartaJogadorPanel = new CartaJogadorPanel(game);
        cartaInimigoPanel = new CartaInimigoPanel(game); 
       
        


        btnPassarTurno = new JButton("Passar Turno");
        btnPassarTurno.setEnabled(true);
        btnPassarTurno.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.passarTurno();
            }
        });
        
        btnExtraActionPoint = new JButton("Extra Action Point");
        btnExtraActionPoint.setEnabled(true);
        btnExtraActionPoint.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoExtraPoint();
            }
        });
        
        btnArchersAttack = new JButton("Archeres Attack");
        btnArchersAttack.setEnabled(true);
        btnArchersAttack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoArchersAtt();
            }
        });
        
        btnBoillingWaterAttack = new JButton("Boilling Water Attack");
        btnBoillingWaterAttack.setEnabled(true);
        btnBoillingWaterAttack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoBoilWater();
            }
        });
        
        btnCloseCombatAttack = new JButton("Close Combat Attack");
        btnCloseCombatAttack.setEnabled(true);
        btnCloseCombatAttack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoCloseCombat();
            }
        });
        
        btnCoupure = new JButton("Coupure");
        btnCoupure.setEnabled(true);
        btnCoupure.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoCoupure();
            }
        });
         
        btnRallyTroops = new JButton("Rally Troops");
        btnRallyTroops.setEnabled(true);
        btnRallyTroops.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoRallyTroops();
            }
        });
        
        btnTunnelMovement = new JButton("Tunnel Movement");
        btnTunnelMovement.setEnabled(true);
        btnTunnelMovement.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoTunnelMov();
            }
        });
        
        btnSupplyRaid = new JButton("Supply Raid");
        btnSupplyRaid.setEnabled(true);
        btnSupplyRaid.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoSupplyRaid();
            }
        });

        btnSabotage = new JButton("Sabotage");
        btnSabotage.setEnabled(true);
        btnSabotage.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoSabotage();
            }
        });

        //criar labels para dia e turno 
        lblDia = new JLabel("Dia: ");
        lblDia.setFont(new Font("Arial", Font.BOLD,18));
        lblDia.setAlignmentX(TOP_ALIGNMENT);
        lblDia.setForeground(Color.white);
        
        lblTurno = new JLabel("Turno: ");
        lblTurno.setFont(new Font("Arial", Font.BOLD,18));
        lblTurno.setAlignmentX(TOP_ALIGNMENT);
        lblTurno.setForeground(Color.white);
//        jPanelInformacoes = new JPanel();
        jPanelCartasJogo = new JPanel();
        jPanelCartasJogadores = new JPanel();
    }
    
    private void setupLayout()
    {
        jPanelCartasJogo.setLayout(new FlowLayout());
        jPanelCartasJogo.setBackground(new Color(0,0,0,0));
        jPanelCartasJogo.add(cartaFundoPanel);
        jPanelCartasJogo.add(cartaJogoPanel);
    
//        jPanelCartasJogo.setBorder(new LineBorder(Color.white));
        
        jPanelCartasJogadores.setLayout(new FlowLayout());
        jPanelCartasJogadores.setBackground(new Color(0,0,0,0));
        jPanelCartasJogadores.add(cartaJogadorPanel);
        jPanelCartasJogadores.add(Box.createHorizontalGlue());
        jPanelCartasJogadores.add(Box.createHorizontalGlue());
        jPanelCartasJogadores.add(cartaInimigoPanel);
//        jPanelCartasJogadores.setBorder(new LineBorder(Color.yellow));
  
//        jPanelInformacoes.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        jPanelInformacoes.setBackground(new Color(0,0,0,0));
//        jPanelInformacoes.setBorder(new LineBorder(Color.pink));
        
        Box boxPrincipal = Box.createVerticalBox();
        Box boxLabels = Box.createHorizontalBox();       
        Box boxBotoes = Box.createHorizontalBox();
        
       // boxPrincipal.add(jPanelCartasJogadores);
        //boxPrincipal.add(Box.createHorizontalGlue());
        
//        boxPrincipal.add(jPanelCartasJogo);
//        boxHorizontal.add(Box.createHorizontalGlue());
        
//        boxPrincipal.add(jPanelCartasJogo);
//        boxPrincipal.add(jPanelCartasJogadores);
        
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnPassarTurno);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnExtraActionPoint);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnArchersAttack);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnBoillingWaterAttack);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnCloseCombatAttack);
        boxBotoes.add(Box.createHorizontalGlue());      
        boxBotoes.add(btnCoupure);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnRallyTroops);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnTunnelMovement);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnSupplyRaid);
        boxBotoes.add(Box.createHorizontalGlue());
        boxBotoes.add(btnSabotage);
        boxBotoes.add(Box.createHorizontalGlue());

        boxBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
          
        boxLabels.add(lblDia);
        boxLabels.add(Box.createHorizontalGlue());
        boxLabels.add(lblTurno);
        boxLabels.add(Box.createHorizontalGlue());
        
        boxPrincipal.add(Box.createVerticalGlue());
        boxPrincipal.setAlignmentY(Component.LEFT_ALIGNMENT);
       
        boxPrincipal.add(boxBotoes);
        boxPrincipal.add(boxLabels);
        
               
        add(jPanelCartasJogo);
        add(Box.createHorizontalGlue());
        add(jPanelCartasJogadores);
        add(boxPrincipal, BorderLayout.SOUTH);   
              
        validate();
       
    }
    
    
    @Override
    public void update(Observable o, Object o1) 
    {
        
        repaint(); 
   
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
    
    public static BufferedImage getImgCartaFundo() 
    {
        return fundo;
    }
    
    public static BufferedImage getImgCartaInimigo() 
    {
        return cartaInimigo;
    }
    
    public static Image getImgCartaJogo(String s) 
    {
       return cartas.get(s); 
    }
}
