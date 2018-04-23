package logicaJogo;

import java.io.Serializable;
import logicaJogo.Estados.*;

public class Jogo implements Serializable {

    private DadosJogo jogo;
    private IEstado estado;

    public Jogo() {

        this.jogo = new DadosJogo();
        setEstado(new AguardaInicio(jogo));
    }

    private void setEstado(IEstado estado) {
        this.estado = estado;
    }

    public IEstado getEstado() {
        return estado;
    }

    public void defineNomeJogador(String nome) {
        setEstado(estado.defineNomeJogador(nome));
    }

    public void comecarJogo() {
        setEstado(estado.comecarJogo());
    }

    public void retirarCarta() {
        setEstado(estado.retirarCarta());
    }

    public void mudarTurno() {
        setEstado(estado.mudarTurno());
    }

    public void realizarAccao(int action) {
        setEstado(estado.realizarAccao(action));
    }

    public void realizarArchersAttack(int pista) {
        setEstado(estado.realizarArchersAttack(pista));
    }

    public void voltarAcao() {
        setEstado(estado.voltarAcao());
    }

    public void realizarBoilingWaterAttack(int pista) {
        setEstado(estado.realizarBoilingWaterAttack(pista));
    }

    public void realizarCloseCombatAttack() {
        setEstado(estado.realizarCloseCombatAttack());
    }

    public void realizarCloseCombatAttack(int track) {
        setEstado(estado.realizarCloseCombatAttack(track));
    }

    // Outras funçºoes 
    public String toStringDados() {
        return jogo.toStringDados();
    }

    public String toStringCarta() {
        return jogo.toStringCarta();
    }

    public String getLog() {
        return jogo.getLog();
    }

    public void setLog(String log) {
        jogo.setLog(log);
    }

    public boolean troopsIncloseCombat() {
        return jogo.CountEnemiesInCloseCombat() != 0;
    }

    public int troopsIncloseCombatCount() {
        return jogo.CountEnemiesInCloseCombat() ;
    }
    public boolean troopsInCircleSpaces() {
        return jogo.troopsInCircleSpaces();
    }

    public boolean hasLadders() {
        return jogo.isHasLadderns();
    }

    public boolean hasBattRam() {
        return jogo.isHasBattRam();
    }

    public boolean hasSiegeTower() {
        return jogo.isHasSiegeTower();
    }

    public boolean laddersIncircle() {
        return jogo.isLaddersInCircleSpace();
    }

    public boolean battRamInCircle() {
        return jogo.isBattRamInCircleSpace();
    }

    public boolean siegeTowerInCircle() {
        return jogo.isSiegeTowerInCircleSpace();
    }

    public boolean unusedBoilingWater() {
        return jogo.isUnusedBoilingWater();
    }

    public int[] closeCombatUnits() {
        return jogo.getCloseCombatUnits();
    }
    public int wallStrg(){
        return jogo.getPlayerWallStrength();
    }
}
