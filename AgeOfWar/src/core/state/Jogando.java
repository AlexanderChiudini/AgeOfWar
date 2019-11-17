
package core.state;

import core.model.Castle;
import core.model.Player;

public class Jogando extends EstadoJogo {

    public Jogando(Player player) {
        super(player);
    }
    
    @Override
    public void jogar() throws Exception {
        Player player = super.getPlayer();
        
        player.removeDiceForChoose();
        
//        for(Castle castle : player.getConqueredCastle()){
//            if(!castle.isConquered()){
//                if(castle.getBattleLine().size() == 0){
//                    
//                }
//            }
//        }
    }

    @Override
    public String toString() {
        return "Jogando";
    }
}
