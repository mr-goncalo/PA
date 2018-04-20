
package UiJogo;

import logicaJogo.MaquinaEstados;

public class Main 
{
    public static void main(String[] args) 
    {
        UiTexto iuTexto = new UiTexto(new MaquinaEstados());
        iuTexto.corre();
    }
}
