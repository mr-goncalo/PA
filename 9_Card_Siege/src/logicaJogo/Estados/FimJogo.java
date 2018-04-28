
package logicaJogo.Estados;

import logicaJogo.DadosJogo;

public class FimJogo extends EstadoAdapter implements IEstado{
    
    public FimJogo(DadosJogo jogo) {
        super(jogo);
    }  
    
    @Override
    public IEstado novoJogo()
    {
        return new AguardaInicio(null);
    } 
}
