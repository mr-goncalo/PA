package logicaJogo.Estados;

import java.io.Serializable;
import logicaJogo.DadosJogo;

public class AguardaCarta extends EstadoAdapter implements IEstado {

    public AguardaCarta(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado retirarCarta() 
    {
        if (!getJogo().DeckEmpty()) 
        {
            getJogo().EnemyLineCheck();
            getJogo().DrawCard();
           // getJogo().AdvanceTurn();
            return this;//new AguardaAccao(getJogo());
        } 
        else
        {
            getJogo().EndOfDay();
            return this;
        }

    }
    
//    @Override
//    public IEstado mudarTurno() {
//        getJogo().AdvanceTurn();
//        return new AguardaCarta(getJogo());
//        //return this;
//    }

    @Override
    public IEstado mudarTurno() 
    {
        getJogo().AdvanceTurn();
        return this;// new AguardaCarta(jogo);
    }
}
