
package UiJogo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaJogo.Jogo;

public class Main 
{
    public static void main(String[] args) 
    {
        UiTexto iuTexto = new UiTexto(new Jogo());
        try {
            iuTexto.corre();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
