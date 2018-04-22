
package logicaJogo.Estados;

public interface IEstado 
{
    IEstado defineNomeJogador(String nome);
    IEstado comecarJogo();
    IEstado retirarCarta();
    IEstado verificaFimJogo();//POR IMPLEMENTAR, TALVEZ EM QUASE TODOS OS ESTADOS(VER AINDA) - VERIFICA SE EXISTEM 3 ENIMIGOS NA ZONA DE COMBATE, SE CHEGAMOS A 0 EM ALGUMA UNIDADE OU SE PASSARAM 3 DIAS
    IEstado verificaEnimigosAreaCombate();
    IEstado mudarTurno();
    IEstado realizarAccao(int n);

}
