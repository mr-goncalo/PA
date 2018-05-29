
package UiJogo;

import UiJogo.vista.gui.CardSiegeFrame;
import logicaJogo.ObservableGame;

public class UiGUI 
{
    public static void main(String[] args) 
    {
        CardSiegeFrame GUI = new CardSiegeFrame(new ObservableGame());
    }
}
       