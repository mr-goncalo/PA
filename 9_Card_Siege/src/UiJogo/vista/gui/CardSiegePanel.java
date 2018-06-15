
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
import logicaJogo.Estados.AguardaTunnelMovement;
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
    static private BufferedImage marcadorJogador = null;
    static private BufferedImage marcadorInimigo = null;
    static private BufferedImage marcadorTunnel = null;
    static private BufferedImage marcadorSupplies = null;
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
    JButton btnOpcao1;
    JButton btnOpcao2;
    JButton btnOpcao3;
    JButton btnOpcao4;
    
    JLabel lblEstado;        
    JLabel lblTurnActionPoints;
    JLabel lblMoraleBonus;
    JLabel lblSabotageBonus;
    JLabel lblLaddersBonus;
    JLabel lblBattRamBonus;
    JLabel lblSiegeTowerBonus;
    JLabel lblCloseCombatBonus;
    JLabel lblRaidBonus;
    JLabel lblCoupureBonus;
    JLabel lblCircleSpaceBonus;

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
            marcadorJogador = ImageIO.read(Resources.getResourceFile("imagens/marcadorJogador.png"));  
            marcadorInimigo = ImageIO.read(Resources.getResourceFile("imagens/marcadorInimigo.png"));  
            marcadorTunnel = ImageIO.read(Resources.getResourceFile("imagens/marcadorTunnel.png"));  
            marcadorSupplies = ImageIO.read(Resources.getResourceFile("imagens/marcadorSupplies.png"));  
        } 
        catch (IOException e) 
        {
            System.out.println("Erro a carregar imagens!");
        }
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
        
        btnOpcao1 = new JButton();
        btnOpcao1.setEnabled(false);
        btnOpcao1.setVisible(false);
        
        btnOpcao2 = new JButton();
        btnOpcao2.setEnabled(false);
        btnOpcao2.setVisible(false);
        
        btnOpcao3 = new JButton();
        btnOpcao3.setEnabled(false);
        btnOpcao3.setVisible(false);

        btnOpcao4 = new JButton();
        btnOpcao4.setEnabled(false);
        btnOpcao4.setVisible(false);
        
        btnExtraActionPoint = new JButton("Extra Action Point");
        btnExtraActionPoint.setEnabled(false);
        btnExtraActionPoint.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoExtraPoint();
                bloqueiaTodosBotoesPrincipais();
                realizarAccaoExtraPoint();                
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
                bloqueiaTodosBotoesPrincipais();
                realizarAccaoArchersAtt();
            }
        });
        
        btnBoillingWaterAttack = new JButton("Boilling Water Attack");
        btnBoillingWaterAttack.setEnabled(false);
        btnBoillingWaterAttack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoBoilWater();
                bloqueiaTodosBotoesPrincipais();
                realizarAccaoBoilWater();
            }
        });
        
        btnCloseCombatAttack = new JButton("Close Combat Attack");
        btnCloseCombatAttack.setEnabled(false);
        btnCloseCombatAttack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoCloseCombat();
                bloqueiaTodosBotoesPrincipais();
                realizarAccaoCloseCombat();      
            }
        });
        
        btnCoupure = new JButton("Coupure");
        btnCoupure.setEnabled(false);
        btnCoupure.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoCoupure();
            }
        });
         
        btnRallyTroops = new JButton("Rally Troops");
        btnRallyTroops.setEnabled(false);
        btnRallyTroops.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoRallyTroops();
                bloqueiaTodosBotoesPrincipais();
                realizarAccaoRallyTroops();
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
                if(game.getEstado() instanceof AguardaTunnelMovement)
                {
                    bloqueiaTodosBotoesPrincipais();
                    realizarAccaoTunnelMov(); 
                }                
            }
        });
        
        btnSupplyRaid = new JButton("Supply Raid");
        btnSupplyRaid.setEnabled(false);
        btnSupplyRaid.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoSupplyRaid();
            }
        });

        btnSabotage = new JButton("Sabotage");
        btnSabotage.setEnabled(false);
        btnSabotage.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarAccaoSabotage();
            }
        });

        //criar labels para dia e turno 
        lblEstado = new JLabel("Dia:      Turno:      Log:");
        lblEstado.setFont(new Font("Arial", Font.BOLD,18));
        lblEstado.setAlignmentX(TOP_ALIGNMENT);
        lblEstado.setForeground(Color.white);
  

        lblTurnActionPoints = new JLabel("Turn Action Points:     ");
        lblTurnActionPoints.setFont(new Font("Arial", Font.BOLD,16));
        lblTurnActionPoints.setAlignmentX(TOP_ALIGNMENT);
        lblTurnActionPoints.setForeground(Color.white);

        lblMoraleBonus = new JLabel("Morale Bonus:     ");
        lblMoraleBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblMoraleBonus.setAlignmentX(TOP_ALIGNMENT);
        lblMoraleBonus.setForeground(Color.white);
        
        lblSabotageBonus = new JLabel("Sabotage Bonus:     ");
        lblSabotageBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblSabotageBonus.setAlignmentX(TOP_ALIGNMENT);
        lblSabotageBonus.setForeground(Color.white);
    
        lblLaddersBonus = new JLabel("Ladders Bonus:     ");
        lblLaddersBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblLaddersBonus.setAlignmentX(TOP_ALIGNMENT);
        lblLaddersBonus.setForeground(Color.white);
        
        lblBattRamBonus = new JLabel("Battering Ram Bonus:     ");
        lblBattRamBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblBattRamBonus.setAlignmentX(TOP_ALIGNMENT);
        lblBattRamBonus.setForeground(Color.white);
        
        lblSiegeTowerBonus = new JLabel("Siege Tower Bonus:     ");
        lblSiegeTowerBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblSiegeTowerBonus.setAlignmentX(TOP_ALIGNMENT);
        lblSiegeTowerBonus.setForeground(Color.white);

        lblCloseCombatBonus = new JLabel("Close Combat Bonus:     ");
        lblCloseCombatBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblCloseCombatBonus.setAlignmentX(TOP_ALIGNMENT);
        lblCloseCombatBonus.setForeground(Color.white);
        
        lblRaidBonus = new JLabel("Raid Bonus Bonus:     ");
        lblRaidBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblRaidBonus.setAlignmentX(TOP_ALIGNMENT);
        lblRaidBonus.setForeground(Color.white);
        
        lblCoupureBonus = new JLabel("Coupure Bonus:     ");
        lblCoupureBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblCoupureBonus.setAlignmentX(TOP_ALIGNMENT);
        lblCoupureBonus.setForeground(Color.white);
        
        lblCircleSpaceBonus = new JLabel("Circle Space Bonus:     ");
        lblCircleSpaceBonus.setFont(new Font("Arial", Font.BOLD,16));
        lblCircleSpaceBonus.setAlignmentX(TOP_ALIGNMENT);
        lblCircleSpaceBonus.setForeground(Color.white);
        
        jPanelCartasJogo = new JPanel();
        jPanelCartasJogadores = new JPanel();
    }
    
    private void setupLayout()
    {
        jPanelCartasJogo.setLayout(new FlowLayout());
        jPanelCartasJogo.setBackground(new Color(0,0,0,0));
        jPanelCartasJogo.add(cartaFundoPanel);
        jPanelCartasJogo.add(cartaJogoPanel);
        
        jPanelCartasJogadores.setLayout(new FlowLayout());
        jPanelCartasJogadores.setBackground(new Color(0,0,0,0));
        jPanelCartasJogadores.add(cartaJogadorPanel);
        jPanelCartasJogadores.add(Box.createHorizontalGlue());
        jPanelCartasJogadores.add(Box.createHorizontalGlue());
        jPanelCartasJogadores.add(cartaInimigoPanel);

        Box boxInformacoes = Box.createVerticalBox();
        Box boxPrincipal = Box.createVerticalBox();
        
        Box boxLabels = Box.createHorizontalBox();   
        Box boxLabelsBonus = Box.createHorizontalBox();
        Box boxBotoes = Box.createHorizontalBox();
        Box boxBotoesSecundarios = Box.createHorizontalBox();
        
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
        boxBotoesSecundarios.add(btnOpcao1);
        boxBotoesSecundarios.add(Box.createHorizontalGlue());
        boxBotoesSecundarios.add(btnOpcao2);
        boxBotoesSecundarios.add(Box.createHorizontalGlue());
        boxBotoesSecundarios.add(btnOpcao3);
        boxBotoesSecundarios.add(Box.createHorizontalGlue());
        boxBotoesSecundarios.add(btnOpcao4);
        boxBotoesSecundarios.add(Box.createHorizontalGlue());
        
        boxBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxBotoesSecundarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxLabelsBonus.setAlignmentX(Component.LEFT_ALIGNMENT);
        boxLabels.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        boxLabels.add(lblEstado);
        boxLabels.add(Box.createHorizontalBox()); 
        boxLabels.add(Box.createHorizontalBox());
        boxLabelsBonus.add(lblTurnActionPoints);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblMoraleBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblSabotageBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblLaddersBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblBattRamBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblSiegeTowerBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblCloseCombatBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblRaidBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblCoupureBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxLabelsBonus.add(lblCircleSpaceBonus);
        boxLabelsBonus.add(Box.createVerticalGlue());
        boxInformacoes.add(Box.createHorizontalBox());
        boxInformacoes.add(boxLabels);
        boxInformacoes.add(Box.createHorizontalBox());
        boxInformacoes.add(Box.createHorizontalBox());
        boxInformacoes.add(boxLabelsBonus);
        boxInformacoes.add(Box.createHorizontalBox());
        boxPrincipal.add(Box.createVerticalGlue());   
        boxPrincipal.add(boxBotoes);
        boxPrincipal.add(Box.createVerticalGlue());
        boxPrincipal.add(boxBotoesSecundarios);
        boxPrincipal.add(Box.createVerticalGlue());
        boxPrincipal.add(Box.createVerticalGlue());
        
        add(Box.createHorizontalGlue());
        add(boxInformacoes, BorderLayout.NORTH); 
        add(Box.createHorizontalGlue());
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

        lblEstado.setText("Dia: " + game.getDia() + "    Turno: "+ game.getTurno()+"    Log: "+game.getLog()+" ");
        lblTurnActionPoints.setText("Turn Action Points: "+game.getTurnActionPoints()+"   ");
        lblMoraleBonus.setText("Morale Bonus: "+game.getMoraleBonus()+"   ");
        lblSabotageBonus.setText("Sabotage Bonus: "+game.getSabotageBonus()+"   ");
        lblLaddersBonus.setText("Ladders Bonus: "+game.getLaddersBonus()+"   ");
        lblBattRamBonus.setText("Battering Ram Bonus: "+game.getBattRamBonus()+"   ");
        lblSiegeTowerBonus.setText("Siege Tower Bonus: "+game.getSiegeTowerBonus()+"   ");
        lblCloseCombatBonus.setText("Close Combat Bonus: "+game.getCloseCombatAttBonus()+"   ");
        lblRaidBonus.setText("Raid Bonus: "+game.getRaidBonus()+"   ");
        lblCoupureBonus.setText("Coupure Bonus: "+game.getCoupureBonus()+"   ");
        lblCircleSpaceBonus.setText("Circle Space Bonus: "+game.getCircleSpacesBonus()+"   ");

        if(game.badWeather())
        {
            btnExtraActionPoint.setEnabled(true);
            if(game.troopsInEnemyLines())
            {
                btnSupplyRaid.setEnabled(true);
                btnSabotage.setEnabled(true);
            }
        }
        else
        {
            btnExtraActionPoint.setEnabled(true);
            btnArchersAttack.setEnabled(true);
            btnTunnelMovement.setEnabled(true);
            if(game.troopsInCircleSpaces() && game.unusedBoilingWater())
                btnBoillingWaterAttack.setEnabled(true);
            if(game.troopsInCloseCombat())
                btnCloseCombatAttack.setEnabled(true);
            if(game.wallStrg() < 4)
                btnCoupure.setEnabled(true);
            if(game.playerMorale() < 4)
                btnRallyTroops.setEnabled(true);
            if(game.troopsInEnemyLines())
            {
                btnSupplyRaid.setEnabled(true);
                btnSabotage.setEnabled(true);
            }    
        }
    }
    
    private void realizarAccaoExtraPoint() 
    {
        btnOpcao1.setText("Morale");
        btnOpcao2.setText("Supplies");
        btnOpcao3.setText("Cancelar");

        btnOpcao1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarExtraPoint(1);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarExtraPoint(2);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
                
        btnOpcao3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.voltarAcao();
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
    }
    
    private void realizarAccaoArchersAtt() 
    {
        btnOpcao1.setText("Ladders");
        btnOpcao2.setText("Battering Ram");
        btnOpcao3.setText("Siege Tower");
        btnOpcao4.setText("Cancelar");
        btnOpcao4.setVisible(true);
        btnOpcao4.setEnabled(true);
        if(!game.hasLaddres())
        {
            btnOpcao1.setVisible(false);
            btnOpcao1.setEnabled(false);
        }           
        if(!game.hasBattRam())
        {
            btnOpcao2.setVisible(false);
            btnOpcao2.setEnabled(false);
        } 
        if(!game.hasSiegeTower())
        {
            btnOpcao3.setVisible(false);
            btnOpcao3.setEnabled(false);
        }  
       

        btnOpcao1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarArchersAttack(1);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarArchersAttack(2);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
                
        btnOpcao3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarArchersAttack(3);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao4.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.voltarAcao();
                desbloqueiaTodosBotoesPrincipais();
            }
        });
    }
    
    private void realizarAccaoBoilWater() 
    {
        btnOpcao1.setText("Ladders");
        btnOpcao2.setText("Battering Ram");
        btnOpcao3.setText("Siege Tower");
        btnOpcao4.setText("Cancelar");
        btnOpcao4.setVisible(true);
        btnOpcao4.setEnabled(true);
        if(!game.laddersIncircle())
        {
            btnOpcao1.setVisible(false);
            btnOpcao1.setEnabled(false);
        }           
        if(!game.battRamInCircle())
        {
            btnOpcao2.setVisible(false);
            btnOpcao2.setEnabled(false);
        } 
        if(!game.siegeTowerInCircle())
        {
            btnOpcao3.setVisible(false);
            btnOpcao3.setEnabled(false);
        }  
       

        btnOpcao1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarBoilingWaterAttack(1);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarBoilingWaterAttack(2);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
                
        btnOpcao3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarBoilingWaterAttack(3);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao4.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.voltarAcao();
                desbloqueiaTodosBotoesPrincipais();
            }
        });
    }
    
    private void realizarAccaoCloseCombat() 
    {
        btnOpcao1.setText("1º Space");
        btnOpcao2.setText("2º Space");
        btnOpcao3.setText("Cancelar");

        if(game.closeCombatUnits()[0] == 0)
            btnOpcao1.setEnabled(false);
         
        if(game.closeCombatUnits()[1] == 0)
            btnOpcao2.setEnabled(false);

        btnOpcao1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarCloseCombatAttack(1);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarCloseCombatAttack(2);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
                
        btnOpcao3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.voltarAcao();
                desbloqueiaTodosBotoesPrincipais();
            }
        });
    }
    
    private void realizarAccaoRallyTroops() 
    {
        btnOpcao1.setText("Reduce Supplies for Bonus");
        btnOpcao2.setText("Without Bonus");
        btnOpcao3.setText("Cancelar");
        
        btnOpcao1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarRallyTroops(1);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
        
        btnOpcao2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarRallyTroops(2);
                desbloqueiaTodosBotoesPrincipais();
            }
        });
                
        btnOpcao3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.voltarAcao();
                desbloqueiaTodosBotoesPrincipais();
            }
        });
    }
    
    private void realizarAccaoTunnelMov() 
    {
        btnOpcao1.setText("Free Movement");
        btnOpcao2.setText("Fast Movement");
        btnOpcao3.setText("Voltar");
        
        btnOpcao1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarTunnelMovement(1);
                desbloqueiaTodosBotoesPrincipais();
                game.voltarAcao();
            }
        });
        
        btnOpcao2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.realizarTunnelMovement(2);
                desbloqueiaTodosBotoesPrincipais();
                game.voltarAcao();
            }
        });
                
        btnOpcao3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                game.voltarAcao();
                desbloqueiaTodosBotoesPrincipais();
            }
        });
       
    }
     
    private void bloqueiaTodosBotoesPrincipais() 
    {
        btnPassarTurno.setEnabled(false);
        btnExtraActionPoint.setEnabled(false);
        btnArchersAttack.setEnabled(false);
        btnBoillingWaterAttack.setEnabled(false);
        btnCloseCombatAttack.setEnabled(false);
        btnCoupure.setEnabled(false);
        btnRallyTroops.setEnabled(false);
        btnTunnelMovement.setEnabled(false);
        btnSupplyRaid.setEnabled(false);
        btnSabotage.setEnabled(false);
        btnOpcao1.setEnabled(true);
        btnOpcao1.setVisible(true);
        btnOpcao2.setEnabled(true);
        btnOpcao2.setVisible(true);
        btnOpcao3.setEnabled(true);
        btnOpcao3.setVisible(true); 
    }
    
    private void desbloqueiaTodosBotoesPrincipais() 
    {
        update(game, ui);
         btnPassarTurno.setEnabled(true);
        btnOpcao1.setEnabled(false);
        btnOpcao1.setVisible(false);
        btnOpcao2.setEnabled(false);
        btnOpcao2.setVisible(false);
        btnOpcao3.setEnabled(false);
        btnOpcao3.setVisible(false); 
        btnOpcao4.setEnabled(false);
        btnOpcao4.setVisible(false);  
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
    
    static BufferedImage getImgMarcadorJogador() 
    {
        return marcadorJogador;
    }
    
    static BufferedImage getImgMarcadorInimigo() 
    {
        return marcadorInimigo;
    }
    
    static Image getImgMarcadorTunnel() 
    {
        return marcadorTunnel;
    }
    
    static Image getImgMarcadorSupplies() 
    {
        return marcadorSupplies;
    }
}
