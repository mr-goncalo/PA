package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaAccao extends EstadoAdapter implements IEstado {

    public AguardaAccao(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarAccao(int action) {
        //ter em cuidado o numero de accoes permitidas por turno (1 a 3)
        if (getJogo().getTurnActionPoints() > 0) {
            switch (action) {
                case 1://Archers attack
                    return new AguardaArchersAttack(getJogo());
                case 2://Boiling water attack (!APENAS 1 VEZ POR TURNO!)
                    // a variavel unusedBoilingWater é que vai controlar isso
                    if (getJogo().isUnusedBoilingWater() && getJogo().troopsInCircleSpaces()) {
                        getJogo().setUnusedBoilingWater(false); //action points a 0 para não ser possivel fazer mais vezes no turno
                        return new AguardaBoilingWaterAttack(getJogo());
                    }
                    return this;
                case 3://Close Combat attack
                    if (getJogo().CountEnemiesInCloseCombat() != 0) {
                        return new AguardaCloseCombatAttack(getJogo());
                    }
                    return this;
                case 4://coupure
                    if (getJogo().getPlayerWallStrength() < 4) {
                        return realizarCoupure();
                    }
                    return this;
                case 5://rally Troops
                    if (getJogo().getPlayerMorale() < 4) {
                        return new AguardaRallyTroops(getJogo());
                    } else {
                        getJogo().setLog("Invalid Option!");
                        return this; 
                    }
                case 6://Tunnel movement
                    if (!getJogo().troopsInsideTunnel()) {
                        return new AguardaTunnelMovement(getJogo()).realizarTunnelMovement();
                    } else {
                        return new AguardaTunnelMovement(getJogo());
                    }
                case 7://supply raid
                    break;
                case 8://Sabotage
                    break;
                default:
                    return this;
            }
        }
        return this;
    }

}
