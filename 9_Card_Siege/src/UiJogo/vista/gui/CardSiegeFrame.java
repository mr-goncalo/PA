
package UiJogo.vista.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import logicaJogo.ObservableGame;

public class CardSiegeFrame extends JFrame implements Observer, ConstantesGUI
{

    private ObservableGame game;
    private CardSiegePrincipalPanel painelPrincipal;

    JMenuBar menuBar;
    
    public CardSiegeFrame(ObservableGame j) 
    {
        this(j, 200, 100, DIM_X_FRAME, DIM_Y_FRAME);    
    }

     public CardSiegeFrame(ObservableGame j, int x, int y, int largura, int altura) 
     {
        
        super("9 Card Siege"); 

        game = j;
        game.addObserver(this);
        painelPrincipal = new CardSiegePrincipalPanel(game);
        
        addComponents();
        menus();
        setLocation(0, 0); 
        setSize(largura,altura); 
        setMinimumSize(new Dimension(largura,altura));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         File fl = new File("musicGame.wav");
         //playWav(fl);
         validate();
    
        update(game,null);
    }
     
    @Override
    public void update(Observable o, Object o1) 
    {
        //menuBar.setVisible( !( (game.getStates() instanceof AguardaInicio) || (game.getStates() instanceof Fim))  );
        repaint();
    }

    private void addComponents() 
    {            
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());//
        cp.add(painelPrincipal,BorderLayout.CENTER);
    }

    private void menus()
    {
        /*
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //opções de menu
        JMenu Menu_file = new JMenu("File");
        Menu_file.setMnemonic(KeyEvent.VK_G);

        JMenu Menu_help = new JMenu("More");
        Menu_help.setMnemonic(KeyEvent.VK_H);


        //submenu de file
        JMenuItem newObjJMI = new JMenuItem("Stop");
        newObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //atalho

        JMenuItem readObjJMI = new JMenuItem("Load");
        readObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK)); //atalho

        JMenuItem saveObjJMI = new JMenuItem("Save");
        saveObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));//atalho

        JMenuItem ExitJMI = new JMenuItem("Exit");
        ExitJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));//atalho

        //montar o JMenu - file
        Menu_file.add(newObjJMI);
        Menu_file.add(readObjJMI);
        Menu_file.add(saveObjJMI);
        Menu_file.addSeparator(); //separador
        Menu_file.add(ExitJMI);
        menuBar.add(Menu_file);

        //add listeners
        newObjJMI.addActionListener(new newObjMenuBarListener());
        readObjJMI.addActionListener(new loadObjMenuBarListener());
        saveObjJMI.addActionListener(new saveObjtMenuBarListener());
        ExitJMI.addActionListener(new exitObjtMenuBarListener());


        //submenu de help
        JMenuItem helpContentObjJMI = new JMenuItem("Help");
        helpContentObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //atalho

        JMenuItem aboutObjJMI = new JMenuItem("About");
        aboutObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)); //atalho

        //montar o Jmenu - help   
        Menu_help.add(helpContentObjJMI);
        Menu_help.add(aboutObjJMI);
        menuBar.add(Menu_help);

        //add listeners para sub help opções
        helpContentObjJMI.addActionListener(new helpContentObjMenuBarListener());
        aboutObjJMI.addActionListener(new aboutObjMenuBarListener());*/
    }

}
