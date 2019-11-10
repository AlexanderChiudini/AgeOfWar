
package core.state;

import core.model.Player;

public class Aguardando extends EstadoJogo {

    public Aguardando(Player player) {
        super(player);
    }

    @Override
    public void jogar() throws Exception {
        throw new Exception("Não U+00E9 a sua vez de jogar!");
    }
    
    @Override
    public String toString() {
        return "Aguardando";
    }
    
}
