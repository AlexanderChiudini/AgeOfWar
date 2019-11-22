
package core.state;

import core.model.Castle;
import core.model.Player;

public class Jogando extends EstadoJogo {

    public Jogando(Player player) {
        super(player);
    }
    
    @Override
    public void jogar() throws Exception {
        Player player = getPlayer();
        System.out.println(player.getName());
        
        player.removeDiceForChoose();
        
        for(Castle castle : player.getConqueredCastle()){
            if(!castle.isConquered()){
                if(castle.getBattleLine().size() == castle.getConqueredLines().size()){
                    castle.setIsConquered(true);
                    player.setPoints(player.getPoints()+castle.getPoints());
                    System.out.println("Castelo"+castle.getPoints());
                    System.out.println("Jogador"+player.getPoints());
                }
            }
        }
        
    }

    @Override
    public String toString() {
        return "Jogando";
    }
}
