
package logicaJogo.Actions;
import java.io.Serializable;
import logicaJogo.DadosJogo;


public class Action implements Constantes,Serializable
{  
    private String name;
    private int cost;

    public Action(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void ApplyRules(DadosJogo j,int track){}
    
    public void ApplyRules(DadosJogo j){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
}
