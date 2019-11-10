
package core.state;

import core.model.Player;

public class Vitoria extends EstadoJogo {

    public Vitoria(Player player) {
        super(player);
    }

    @Override
    public void jogar() throws Exception {
        throw new Exception("VocU+00EA venceu, parabU+00E9ns!!");
    }
    
    @Override
    public String toString() {
        return "Vitória";
    }
    
}
