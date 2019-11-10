
package core.state;

import core.model.Player;

public class Derrota extends EstadoJogo {

    public Derrota(Player player) {
        super(player);
    }

    @Override
    public void jogar() throws Exception {
        throw new Exception("VocU+00EA perdeu, mais sorte na prU+00F3xima vez!!");
    }
    
    @Override
    public String toString() {
        return "Derrota";
    }
    
}
