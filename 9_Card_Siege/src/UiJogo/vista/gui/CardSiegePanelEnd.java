
package UiJogo.vista.gui;

import static UiJogo.vista.gui.CardSiegePanelStart.getFundoInicio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logicaJogo.ObservableGame;

public class CardSiegePanelEnd extends JPanel implements Observer, ConstantesGUI
{
    ObservableGame game;
    
    JButton btnReiniciar;
    JButton btnSair;
    
    JLabel lblLog;
    JLabel lblTitulo; 
    
    JPanel parteDeBaixo;
    JPanel parteDoMeio;
    JPanel parteDeCima;
        
    CardSiegePanelEnd(ObservableGame jogo) 
    {
        game=jogo;
        game.addObserver(this);
        setupComponents();
        setupLayout();
    }
    
        
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);        
        g.drawImage(getFundoInicio(), 0, 0, getWidth(), getHeight(), this);        
    }

    @Override
    public void update(Observable o, Object o1) 
    {
        lblLog.setText(game.getLog());
    }
    
    private void setupComponents()
    {  
     
        btnReiniciar = new JButton("Reiniciar Jogo");
        btnSair = new JButton("Sair");
        lblLog = new JLabel();
        lblTitulo = new JLabel();
        parteDeBaixo = new JPanel();
        parteDoMeio = new JPanel();
        parteDeCima = new JPanel();
        
        btnReiniciar.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {          
                game.reiniciarJogo();
                CardSiegeFrame GUI = new CardSiegeFrame(new ObservableGame());
            }
        });
        
        btnSair.addActionListener(new ActionListener()
        {        
            @Override
            public void actionPerformed(ActionEvent ev){         
                 System.exit(0);
            }
        });
    }
    
    private void setupLayout()
    {
    
        setLayout(new BorderLayout());

        lblTitulo.setFont(new Font("Arial", Font.ITALIC, 47));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setText("Micro Space Empire");
            
        lblLog.setFont(new Font("Arial", Font.ITALIC, 34));
        lblLog.setForeground(Color.WHITE);
        btnReiniciar.setSize(100,100);                
        
        add(parteDeCima, BorderLayout.NORTH);
        add(parteDoMeio, BorderLayout.CENTER);
        add(parteDeBaixo, BorderLayout.SOUTH);

        parteDeBaixo.add(Box.createRigidArea(new Dimension(0,100)));
        
        parteDeBaixo.setBackground(new Color(0,0,0,0));
        parteDoMeio.setBackground(new Color(0,0,0,0));
        parteDeCima.setBackground(new Color(0,0,0,0));
        
        parteDeCima.add(lblTitulo);
        parteDoMeio.add(lblLog);
        parteDeBaixo.add(btnReiniciar);        
        
  
        validate();
    }
};

