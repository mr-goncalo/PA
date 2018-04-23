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
            getJogo().EnemyLineCheck();
            getJogo().DrawCard(); 
            // getJogo().AdvanceTurn();
            //verificaEnimigosAreaCombate
            //if() SE HOUVER SOLDADOS NA LINHA ENIMIGA
            //GIRAR DADO
            //SE DADO 2-6 NAO FAZ NADA, CONTINUA
            //SE 1 SAO CAPTURADOS

            return new AguardaAccao(getJogo());
        } else {
            getJogo().EndOfDay();
            return this;
        }

    }

}
