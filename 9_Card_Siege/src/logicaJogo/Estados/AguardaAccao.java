package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaAccao extends EstadoAdapter implements IEstado {

    public AguardaAccao(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado playerAction(int action) {

        switch (action) {
            case 1://Archers attack
             //   return new ArcherAwaitSlection(getJogo());
                break;
            case 2://Boiling water attack
                break;
            case 3://Close Combat attack
                break;
            case 4://coupure
                break;
            case 5://rally Troops
                break;
            case 6://Tunnel movement
                break;
            case 7://supply raid
                break;
            case 8://Sabotage
                break;
            case 0://avança o turn 
                return new AguardaCarta(getJogo());
            default:
                return this;

        }
        return this;
    }

}
