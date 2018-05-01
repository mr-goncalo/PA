
package logicaJogo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GereFicheirosJogo 
{
    public static final String SEPARADORES_FICH_TEXTO = ";";
     
    //guarda jogo em ficheiro binario
    public static boolean guardaJogo(Jogo jogo, String nomeFicheiro)
    {   
        ObjectOutputStream out = null;
                
        try
        {
            out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            out.writeObject(jogo);
        }
        catch(IOException e)
        {
            
            return false;
            
        }
        finally
        {
            if(out != null)
            {
                try 
                {
                    out.close();
                }
                catch (IOException e) 
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //carrega jogo de ficheiro binario
    public static Jogo carregaJogo(String nomeFicheiro) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Jogo jogo;
        ObjectInputStream in = null;
        
        try
        {
            in = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            jogo = (Jogo)in.readObject();
        }
        finally
        {
            if(in!=null)
            {
                in.close();
            }
        }
        
        //Livro.setOrdemCriacao(jogo.getMaxCodigoLivro());
        
        return jogo;
    }
    
}
