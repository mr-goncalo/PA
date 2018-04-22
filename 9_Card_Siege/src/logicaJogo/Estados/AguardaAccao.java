package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaAccao extends EstadoAdapter implements IEstado {

    public AguardaAccao(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarAccao(int action) 
    {
        //ter em cuidado o numero de accoes permitidas por turno (1 a 3)
        if(getJogo().getTurnActionPoints()>0)
        {
            switch (action) 
            {
                case 1://Archers attack
                 //   return new ArcherAwaitSlection(getJogo());
                    break;
                case 2://Boiling water attack (!APENAS 1 VEZ POR TURNO!)
                    getJogo().setTurnActionPoints(0); //action points a 0 para não ser possivel fazer mais vezes no turno
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
                default:
                    return this;
            }
            getJogo().setTurnActionPoints(getJogo().getTurnActionPoints()-1);
        }
        else
            return new AguardaCarta(getJogo());//não tenho a certeza se é isto
       
        return this;        
    }

}
