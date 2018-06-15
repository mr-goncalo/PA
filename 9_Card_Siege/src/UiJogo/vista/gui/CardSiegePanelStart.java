
package UiJogo.vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import logicaJogo.GereFicheirosJogo;
import logicaJogo.ObservableGame;

public class CardSiegePanelStart extends JPanel implements Observer, ConstantesGUI
{
    JButton btnNovoJogo;
       
    JLabel lblTitulo; 
       
    ObservableGame observableGame;
    
    static private BufferedImage fundo = null;
    
    public CardSiegePanelStart(ObservableGame jogo) 
    {
        observableGame=jogo;
        observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }
    
    public static BufferedImage getFundoInicio() 
    {
        return fundo;
    }
    
    static 
    {
        try 
        {         
            fundo = ImageIO.read(Resources.getResourceFile("imagens/fundo.png"));
        } 
        catch (IOException e) 
        {
            System.out.println("Erro ao carregar imagem de fundo!");
        }
    }

    private void setupComponents()
    {  
        btnNovoJogo = new JButton("Iniciar Jogo");
        lblTitulo = new JLabel("9 Card Siege"); 
        
        btnNovoJogo.addActionListener(new ActionListener()
        {        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.novoJogo();
            }
        });
       
    }
    
    @Override
    public void update(Observable o, Object o1) 
    {
 
    }
    
    private void setupLayout()
    {
        JPanel parteDeCima = new JPanel();
        JPanel parteDeBaixo = new JPanel();
        

        setLayout(new BorderLayout());

        lblTitulo.setFont(new Font("Arial", Font.ITALIC, 30));
        lblTitulo.setForeground(Color.WHITE);
                  
        btnNovoJogo.setSize(100,100);
        
        add(parteDeCima, BorderLayout.NORTH);
        add(parteDeBaixo, BorderLayout.SOUTH);
        
    
        parteDeBaixo.add(Box.createRigidArea(new Dimension(0,100)));
        
        parteDeBaixo.setBackground(new Color(0,0,0,0)); //torna o fundo transparente
        parteDeCima.setBackground(new Color(0,0,0,0));
      
        parteDeCima.add(lblTitulo);
        parteDeBaixo.add(btnNovoJogo);
       
        validate();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);        
        g.drawImage(getFundoInicio(), 0, 0, getWidth(), getHeight(), this);        
    }
}
