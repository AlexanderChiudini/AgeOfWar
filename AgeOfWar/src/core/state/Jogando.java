
package core.state;

import core.model.Player;

public class Jogando extends EstadoJogo {

    public Jogando(Player player) {
        super(player);
    }
    
    @Override
    public void jogar() throws Exception {
        
    }

    @Override
    public String toString() {
        return "Jogando";
    }
}
