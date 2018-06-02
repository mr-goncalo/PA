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

    public void novoJogo() {
        setEstado(estado.novoJogo());
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

    public void realizarAccaoExtraPoint() {
        setEstado(estado.realizarAccaoExtraPoint());
    }

    public void realizarAccaoArchersAtt() {
        setEstado(estado.realizarAccaoArchersAtt());
    }

    public void realizarAccaoBoilWater() {
        setEstado(estado.realizarAccaoBoilWater());
    }

    public void realizarAccaoCloseCombat() {
        setEstado(estado.realizarAccaoCloseCombat());
    }

    public void realizarAccaoCoupure() {
        setEstado(estado.realizarAccaoCoupure());
    }

    public void realizarAccaoRallyTroops() {
        setEstado(estado.realizarAccaoRallyTroops());
    }

    public void realizarAccaoTunnelMov() {
        setEstado(estado.realizarAccaoTunnelMov());
    }

    public void realizarAccaoSupplyRaid() {
        setEstado(estado.realizarAccaoSupplyRaid());
    }

    public void realizarAccaoSabotage() {
        setEstado(estado.realizarAccaoSabotage());
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

    public void realizarRallyTroops(int bonus) {
        setEstado(estado.realizarRallyTroops(bonus));
    }

    public void realizarTunnelMovement(int mov) {
        setEstado(estado.realizarTunnelMovement(mov));
    }

    public void realizarTunnelMovement() {
        setEstado(estado.realizarTunnelMovement());
    }

    public void realizarExtraPoint(int c) {
        setEstado(estado.realizarExtraPoint(c));
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
        return jogo.CountEnemiesInCloseCombat();
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

    public int wallStrg() {
        return jogo.getPlayerWallStrength();
    }

    public int playerMorale() {
        return jogo.getPlayerMorale();
    }

    public boolean checkTwoEnemiesCloseCombat() {
        return jogo.checkTwoEnemiesCloseCombat();
    }

    public int getTurnActionPoints() {
        return jogo.getTurnActionPoints();
    }
    public boolean TroopsInEnemyLines(){
        return jogo.troopsInEnemyLines();
    }
    public boolean badWeather(){
        return jogo.isBadWheather();
    }
    
    public void isPerdeu()
    {
        if(jogo.isPerdeu())
            setEstado(estado.novoJogo());
    }
    
    public int getTurno()
    {
        return jogo.getTurno();
    }

    public int getDia() 
    {
        return jogo.getDia();
    }
    
    public int getPlayerSupplies()
    {
        return jogo.getPlayerSupplies();
    }
    
    public int[] getTunnel()
    {
        return jogo.getTunnel();
    }

    public int getSuppliesCarried() 
    {
        return jogo.getSuppliesCarried();
    }
    
    public int getEnemiesLaddersLocation() 
    {
        return jogo.getEnemiesLaddersLocation();
    }
    
    public int getEnemiesBattRamLocation() 
    {
        return jogo.getEnemiesBattRamLocation();
    }
        
    public int getEnemiesSiegeTowerLocation() 
    {
        return jogo.getEnemiesSiegeTowerLocation();
    }
            
    public int getEnemiesTrebuchetCount() 
    {
        return jogo.getEnemiesTrebuchetCount();
    }
}
