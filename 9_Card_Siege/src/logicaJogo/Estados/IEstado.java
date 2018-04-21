
package logicaJogo.Estados;

public interface IEstado 
{
    IEstado defineNomeJogador(String nome);
    IEstado comecarJogo();
    IEstado retirarCarta();

}
