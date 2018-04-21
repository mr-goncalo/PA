
package UiJogo;

import logicaJogo.Jogo;

public class Main 
{
    public static void main(String[] args) 
    {
        UiTexto iuTexto = new UiTexto(new Jogo());
        iuTexto.corre();
    }
}
