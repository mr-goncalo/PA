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
            getJogo().setTurnActionPoints(0);
           // getJogo().AdvanceTurn();
           //verificaEnimigosAreaCombate
           //if() SE HOUVER SOLDADOS NA LINHA ENIMIGA
           //GIRAR DADO
           //SE DADO 2-6 NAO FAZ NADA, CONTINUA
           //SE 1 SAO CAPTURADOS
           
            return this;//new AguardaAccao(getJogo());
        } 
        else
        {
            getJogo().EndOfDay();
            return this;
        }

    }

    @Override
    public IEstado verificaEnimigosAreaCombate()
    {
        //se houver 2 enimigos na linha de combate
        //new (estado) Aguarda rodar dos dados 
        return this;
    }
    
    @Override
    public IEstado mudarTurno() 
    {
        getJogo().AdvanceTurn();
        return this;// new AguardaCarta(jogo);
    }
    
    
}
