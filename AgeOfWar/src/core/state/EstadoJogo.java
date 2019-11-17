
package core.state;

import core.model.Player;

public abstract class EstadoJogo {
    
    private Player player;
    
    public EstadoJogo(Player player) {
        this.player = player;
    }
    
    public abstract void jogar() throws Exception;

    public Player getPlayer() {
        return player;
    }
}
