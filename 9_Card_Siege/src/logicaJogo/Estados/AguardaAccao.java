package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class AguardaAccao extends EstadoAdapter implements IEstado {

    public AguardaAccao(DadosJogo jogo) {

        super(jogo);

    }

    @Override
    public IEstado mudarTurno() {
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().AdvanceTurn()) {
            return new FimJogo(getJogo());
        }
        return new AguardaCarta(getJogo());
    }

    @Override
    public IEstado realizarAccaoExtraPoint() {
        if (!getJogo().isExtraPointUsed()) 
        {
            return new AguardaExtraPoint(getJogo());
        }
        getJogo().setLog("Extra point already used!");
        return this;
    }

    @Override
    public IEstado realizarAccaoArchersAtt() {
        if (getJogo().isBadWheather()) {
            return this;
        }
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().getTurnActionPoints() > 0) {
            return new AguardaArchersAttack(getJogo());
        }
        getJogo().setLog("Not enought Action Points");
        return this;
    }

    @Override
    public IEstado realizarAccaoBoilWater() {
        if (getJogo().isBadWheather()) {
            return this;
        }
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().getTurnActionPoints() > 0) 
        {
            if (getJogo().isUnusedBoilingWater() && getJogo().troopsInCircleSpaces())
            {
                getJogo().setUnusedBoilingWater(false); //action points a 0 para não ser possivel fazer mais vezes no turno
                return new AguardaBoilingWaterAttack(getJogo());
            }
        }
        getJogo().setLog("Not enought Action Points");

        return this;
    }

    @Override
    public IEstado realizarAccaoCloseCombat() {
        if (getJogo().isBadWheather()) {
            return this;
        }
         
        if (getJogo().getTurnActionPoints() > 0) {
            if (getJogo().CountEnemiesInCloseCombat() != 0) {
                return new AguardaCloseCombatAttack(getJogo());
            }
        }
        getJogo().setLog("Not enought Action Points");

        return this;
    }

    @Override
    public IEstado realizarAccaoCoupure() {
        if (getJogo().isBadWheather()) {
            return this;
        }
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().getTurnActionPoints() > 0) {

            if (getJogo().getPlayerWallStrength() < 4) {
                getJogo().repairWall();
                return new AguardaAccao(getJogo());
            }
            getJogo().setLog("Wall is at max!");
            return this;
        }
        getJogo().setLog("Not enought Action Points");

        return this;
    }

    @Override
    public IEstado realizarAccaoRallyTroops() {
        if (getJogo().isBadWheather()) {
            return this;
        }
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().getTurnActionPoints() > 0) {

            if (getJogo().getPlayerMorale() < 4) {
                return new AguardaRallyTroops(getJogo());

            } else {
                getJogo().setLog("Morale is at MAX!");
                return this;
            }
        }
        getJogo().setLog("Not enought Action Points");

        return this;
    }

    @Override
    public IEstado realizarAccaoSabotage() {
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().getTurnActionPoints() > 0) {
            if (getJogo().troopsInEnemyLines()) {
                if (getJogo().getSabotage().ApplyRules(getJogo()) == 1) {
                    getJogo().setTurnActionPoints(getJogo().getTurnActionPoints() - getJogo().getSabotage().getCost());
                }
                
                if(getJogo().isPerdeu())
                    return new FimJogo(getJogo());
                 
                return this;
            }
            getJogo().setLog("Your troops aren't in enemy! ");

            return this;
        }
        getJogo().setLog("Not enought Action Points");

        return this;

    }

    @Override
    public IEstado realizarAccaoSupplyRaid() {
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (getJogo().getTurnActionPoints() > 0) 
        {
            if (getJogo().troopsInEnemyLines()) 
            {
                if (getJogo().getSupplyRaid().ApplyRules(getJogo()) == 1) 
                {
                    getJogo().setTurnActionPoints(getJogo().getTurnActionPoints() - getJogo().getSupplyRaid().getCost());
                }
                
                if(getJogo().isPerdeu())
                    return new FimJogo(getJogo());
                
                return this;
            }
            getJogo().setLog("Your troops aren't in enemy! ");

            return this;
        }
        getJogo().setLog("Not enought Action Points");

        return this;
    }

    @Override
    public IEstado realizarAccaoTunnelMov() {
        if (getJogo().isBadWheather()) {
            return this;
        }
        if(getJogo().checkTwoEnemiesCloseCombat())
        {
             return this;
        }
        if (!getJogo().troopsInsideTunnel()) {
            if (getJogo().getTurnActionPoints() > 0) {
                return new AguardaTunnelMovement(getJogo()).realizarTunnelMovement();
            }
            getJogo().setLog("Not enought Action Points");
            return this;
        } else {
            return new AguardaTunnelMovement(getJogo());
        }
    }

}
