
package IUjogo;

import logicaJogo.MaquinaEstados;

public class Main 
{
    public static void main(String[] args) 
    {
        IUtexto iuTexto = new IUtexto(new MaquinaEstados());
        iuTexto.corre();
    }
}
