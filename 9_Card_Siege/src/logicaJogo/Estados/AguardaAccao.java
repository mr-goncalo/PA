package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaAccao extends EstadoAdapter implements IEstado {

    public AguardaAccao(DadosJogo jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizarAccao(int action) {
        //ter em cuidado o numero de accoes permitidas por turno (1 a 3)

        switch (action) {
            case 0:// Extra action point
                if (!getJogo().isExtraPointUsed()) {
                    return new AguardaExtraPoint(getJogo());
                }
                getJogo().setLog("Extra point already used!");
                return this;
            case 1://Archers attack
                if (getJogo().getTurnActionPoints() > 0) {
                    return new AguardaArchersAttack(getJogo());
                }
                return this;
            case 2://Boiling water attack (!APENAS 1 VEZ POR TURNO!)
                // a variavel unusedBoilingWater é que vai controlar isso
                if (getJogo().getTurnActionPoints() > 0) {
                    if (getJogo().isUnusedBoilingWater() && getJogo().troopsInCircleSpaces()) {
                        getJogo().setUnusedBoilingWater(false); //action points a 0 para não ser possivel fazer mais vezes no turno
                        return new AguardaBoilingWaterAttack(getJogo());
                    }
                }
                return this;
            case 3://Close Combat attack
                if (getJogo().getTurnActionPoints() > 0) {
                    if (getJogo().CountEnemiesInCloseCombat() != 0) {
                        return new AguardaCloseCombatAttack(getJogo());
                    }
                }
                return this;
            case 4://coupure
                if (getJogo().getTurnActionPoints() > 0) {

                    if (getJogo().getPlayerWallStrength() < 4) {
                        return realizarCoupure();
                    }
                }
                return this;
            case 5://rally Troops
                if (getJogo().getTurnActionPoints() > 0) {

                    if (getJogo().getPlayerMorale() < 4) {
                        return new AguardaRallyTroops(getJogo());

                    } else {
                        getJogo().setLog("Invalid Option!");
                        return this;
                    }
                }
                return this;

            case 6://Tunnel movement
                if (!getJogo().troopsInsideTunnel()) {
                    if (getJogo().getTurnActionPoints() > 0) {
                        return new AguardaTunnelMovement(getJogo()).realizarTunnelMovement();
                    }
                    return this;
                } else {
                    return new AguardaTunnelMovement(getJogo());
                }
            case 7://supply raid
                if (getJogo().getTurnActionPoints() > 0) {

                    if (getJogo().troopsInEnemyLines()) {
                        if (getJogo().getSupplyRaid().ApplyRules(getJogo()) == 1) {
                            getJogo().setTurnActionPoints(getJogo().getTurnActionPoints() - getJogo().getSupplyRaid().getCost());
                        }

                        return this;
                    }
                }
                return this;
            case 8://Sabotage
                if (getJogo().getTurnActionPoints() > 0) {
                    if (getJogo().troopsInEnemyLines()) {
                        if (getJogo().getSabotage().ApplyRules(getJogo()) == 1) {
                            getJogo().setTurnActionPoints(getJogo().getTurnActionPoints() - getJogo().getSabotage().getCost());
                        }
                        return this;
                    }
                }
                return this;
            default:
                getJogo().setLog("Invalid Option!");
                return this;

        }
    }
}
