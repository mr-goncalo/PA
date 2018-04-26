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
        getJogo().AdvanceTurn();
        return new AguardaCarta(jogo);
    }

    @Override
    public IEstado verificaEnimigosAreaCombate() {
        return this;
    }

    @Override
    public IEstado realizarAccao(int action) {
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
        getJogo().repairWall();
        return new AguardaAccao(jogo);
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

    
}
