
package UiJogo.vista.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import logicaJogo.Estados.AguardaInicio;
import logicaJogo.Estados.FimJogo;
import logicaJogo.Jogo;
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
        validate();
        update(game,null);
    }
     
    @Override
    public void update(Observable o, Object o1) 
    {
        menuBar.setVisible( !( (game.getEstado() instanceof AguardaInicio) || (game.getEstado() instanceof FimJogo))  );
        repaint();
    }

    private void addComponents() 
    {            
        Container cp = getContentPane(); 
        cp.setLayout(new BorderLayout());
        cp.add(painelPrincipal,BorderLayout.CENTER);
    }

    private void menus()
    {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        //Menus do jogo
        JMenu menuJogo = new JMenu("Jogo");
        menuJogo.setMnemonic(KeyEvent.VK_H);       
        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic(KeyEvent.VK_H);
        
        //Submenus do jogo
        JMenuItem novoJogo = new JMenuItem("Novo Jogo");
        novoJogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); 
        
        JMenuItem carregarJogo = new JMenuItem("Carregar Jogo");
        carregarJogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); 
        
        JMenuItem guardarJogo = new JMenuItem("Guardar Jogo");
        guardarJogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); 
        
        JMenuItem sairJogo = new JMenuItem("Sair");
        sairJogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); 
        
        //montar o JMenu - file
        menuJogo.add(novoJogo);
        menuJogo.add(carregarJogo);
        menuJogo.add(guardarJogo);
        menuJogo.add(sairJogo);
        menuJogo.addSeparator();   
        menuBar.add(menuJogo);
        
        //add listeners
        novoJogo.addActionListener(new novoJogoMenuBarListener());
        carregarJogo.addActionListener(new carregarJogoMenuBarListener());
        guardarJogo.addActionListener(new guardarJogoMenuBarListener());
        sairJogo.addActionListener(new sairJogoMenuBarListener());
        
        //submenu de help
        JMenuItem ajuda = new JMenuItem("Help");
        ajuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //atalho

        JMenuItem sobre = new JMenuItem("About");
        sobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)); //atalho

        //montar o Jmenu - help   
        menuAjuda.add(ajuda);
        menuAjuda.add(sobre);
        menuBar.add(menuAjuda);

        //add listeners para sub help opções
        sobre.addActionListener(new ajudaObjMenuBarListener());
        sobre.addActionListener(new sobreObjMenuBarListener());

    }
    
    class novoJogoMenuBarListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
           // game.novoJogo();
        }
    }
    
    class carregarJogoMenuBarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        /* JFileChooser fc  = new JFileChooser("./data");
         int returnval = fc.showOpenDialog(MicroSpaceEmpireFrame.this);         
            if(returnval == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                Jogo jogo = (Jogo)FileUtility.retrieveGameFromFile(file);
                if(jogo != null){
                game.setJogo(jogo);
                }
                }catch(IOException | ClassNotFoundException ex){
                     JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,"operaçao falhou\r\n\r\n" + ex,"ERRO",JOptionPane.PLAIN_MESSAGE);              
                }
            }else{System.out.println("operaçao cancelada");}*/
        }
    }
    
    class guardarJogoMenuBarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
          /*  JFileChooser fc  = new JFileChooser("./data");

            int returnval = fc.showSaveDialog(MicroSpaceEmpireFrame.this);
            if(returnval == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                FileUtility.saveGameToFile(file,game.getJogo());
                }catch(IOException ex){
                JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,"operaçao falhou\r\n\r\n" + ex,"ERRO",JOptionPane.PLAIN_MESSAGE);
                }

            }else{System.out.println("operaçao cancelada");}*/
        }
    }
    
    class sairJogoMenuBarListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }
    
    class ajudaObjMenuBarListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
          //JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,game.help(),"Help",JOptionPane.PLAIN_MESSAGE);
        }
    }

    class sobreObjMenuBarListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,game.about(),"About",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    

}
