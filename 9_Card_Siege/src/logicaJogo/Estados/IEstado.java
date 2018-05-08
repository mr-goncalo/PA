package logicaJogo.Estados;

public interface IEstado {

    IEstado defineNomeJogador(String nome);

    IEstado novoJogo();

    IEstado comecarJogo();

    IEstado retirarCarta();

    IEstado verificaFimJogo();//POR IMPLEMENTAR, TALVEZ EM QUASE TODOS OS ESTADOS(VER AINDA) - VERIFICA SE EXISTEM 3 ENIMIGOS NA ZONA DE COMBATE, SE CHEGAMOS A 0 EM ALGUMA UNIDADE OU SE PASSARAM 3 DIAS

    IEstado verificaEnimigosAreaCombate();

    IEstado mudarTurno();

    IEstado realizarAccaoExtraPoint();

    IEstado realizarAccaoArchersAtt();

    IEstado realizarAccaoBoilWater();

    IEstado realizarAccaoCloseCombat();

    IEstado realizarAccaoCoupure();

    IEstado realizarAccaoRallyTroops();

    IEstado realizarAccaoTunnelMov();

    IEstado realizarAccaoSupplyRaid();

    IEstado realizarAccaoSabotage();

    IEstado realizarArchersAtt();

    IEstado realizarArchersAttack(int pista);

    IEstado voltarAcao();

    IEstado realizarBoilingWaterAttack(int pista);

    IEstado realizarCloseCombatAttack(int track);//este é quando estão lá 2

    IEstado realizarCloseCombatAttack(); //Este é quando está só um espaço ocupado

    IEstado realizarCoupure();

    IEstado realizarRallyTroops(int bonus);

    IEstado realizarTunnelMovement();

    IEstado realizarTunnelMovement(int move);

    IEstado realizarExtraPoint(int c);
}
