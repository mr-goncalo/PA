package logicaJogo.Estados;

import java.io.Serializable;
import logicaJogo.DadosJogo;

public class AguardaCarta extends EstadoAdapter implements IEstado {

    public AguardaCarta(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado retirarCarta() {
        if (!getJogo().DeckEmpty()) {
            getJogo().DrawCard();
            getJogo().setRonda(getJogo().getRonda() + 1);
            return this;
        }else
        { 
            getJogo().EndOfDay();
            return this;
        }
        
    }

}
