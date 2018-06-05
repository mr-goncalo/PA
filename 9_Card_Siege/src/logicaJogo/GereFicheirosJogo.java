
package logicaJogo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GereFicheirosJogo 
{
    
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
    public static void guardaJogoGUI(File file, Object o) throws IOException
    {
        ObjectOutputStream oout = null;

        try{

            oout = new ObjectOutputStream(new FileOutputStream(file));        
            oout.writeObject(o);

        }finally{
            if(oout != null)
                oout.close();
        }
    }
    
    public static Object carregaJogoGUI(File file) throws IOException, ClassNotFoundException
    {
        ObjectInputStream oin = null;

        try{

            oin = new ObjectInputStream(new FileInputStream(file));        
            return oin.readObject();

        }finally{
            if(oin != null)
                oin.close();
        }
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
        
        return jogo;
    }    

}
