
package logicaJogo.Estados;

import java.io.Serializable;
import java.util.ArrayList;
import logicaJogo.Cartas.Card;
import logicaJogo.DadosJogo;

public class AguardaCarta extends EstadoAdapter
{
    public AguardaCarta(DadosJogo jogo) 
    {
       super(jogo);
    }

    public IEstado retirarCarta() 
    {
        ArrayList<ArrayList<Card>> carta = getJogo().getDeck();
        Card c = carta.get(getJogo().getRonda()-1).get(getJogo().getDia()-1);
        c.AdvanceEnemies(getJogo());
        c.ApplyEvent(getJogo());
        c.RemoveEventBonus(getJogo());
        c.TurnActionPoints(getJogo());
        System.out.println("Carta: " + c.toString());
        getJogo().setRonda(getJogo().getRonda()+1);
        return this;
    }
       
}
