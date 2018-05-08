package logicaJogo.Estados;

import java.io.Serializable;
import logicaJogo.DadosJogo;

public abstract class EstadoAdapter implements IEstado, Serializable {

    private DadosJogo jogo;

    public EstadoAdapter(DadosJogo jogo) {
        this.jogo = jogo;
    }

    public DadosJogo getJogo() {
        return jogo;
    }

    @Override
    public IEstado defineNomeJogador(String nome) {
        return this;
    }

    @Override
    public IEstado comecarJogo() {
        return this;
    }

    @Override
    public IEstado retirarCarta() {
        return this;
    }

    @Override
    public IEstado mudarTurno() {
        return this;
    }

    @Override
    public IEstado verificaEnimigosAreaCombate() {
        return this;
    }

    @Override
    public IEstado realizarAccaoExtraPoint() {
        return this;
    }

    @Override
    public IEstado realizarAccaoArchersAtt() {
        return this;
    }

    @Override
    public IEstado realizarAccaoBoilWater() {
        return this;
    }

    @Override
    public IEstado realizarAccaoCloseCombat() {
        return this;
    }

    @Override
    public IEstado realizarAccaoCoupure() {
        return this;
    }

    @Override
    public IEstado realizarAccaoRallyTroops() {
        return this;
    }

    @Override
    public IEstado realizarAccaoSabotage() {
        return this;
    }

    @Override
    public IEstado realizarAccaoSupplyRaid() {
        return this;
    }

    @Override
    public IEstado realizarAccaoTunnelMov() {
        return this;
    }

    @Override
    public IEstado verificaFimJogo() {
        return this;
    }

    @Override
    public IEstado realizarArchersAttack(int pista) {
        return this;
    }

    @Override
    public IEstado realizarArchersAtt() {
        return this;
    }

    @Override
    public IEstado voltarAcao() {
        return new AguardaAccao(jogo);
    }

    @Override
    public IEstado realizarBoilingWaterAttack(int pista) {
        return this;
    }

    @Override
    public IEstado realizarCloseCombatAttack() {
        return this;
    }

    @Override
    public IEstado realizarCloseCombatAttack(int track) {
        return this;
    }

    @Override
    public IEstado realizarCoupure() {
        return this;
    }

    @Override
    public IEstado realizarRallyTroops(int bonus) {
        return this;
    }

    @Override
    public IEstado realizarTunnelMovement() {
        return this;
    }

    @Override
    public IEstado realizarTunnelMovement(int move) {
        return this;
    }

    @Override
    public IEstado realizarExtraPoint(int c) {
        return this;
    }

    @Override
    public IEstado novoJogo() {
        return this;
    }
}
