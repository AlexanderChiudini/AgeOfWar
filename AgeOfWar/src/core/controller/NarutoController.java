package core.controller;

import java.util.List;
import core.model.Castle;
import core.model.Clan;
import core.model.Player;
import core.state.Aguardando;
import game.controller.GameController;

public class NarutoController {
    
    private Player naruto;
    private GameController gameController;
    
    public NarutoController(GameController gameController) {
        this.gameController = gameController;
        this.naruto = new Player("Naruto Uzumaki", 0, new Aguardando(naruto));
    }

    /**
     * Retorna a primeira linha de batalha disponível de acordo com a lista de dados que o jogador possui
     * 
     * @return List battleLine
     */
    public List<String> escolherJogada() {
        int maior = Integer.MIN_VALUE;
        for(Clan c: gameController.getClanGlobalList()) {
            if(!c.isIsConquered()) {
                for(Castle ct : c.getCastles()) {
                    if(!ct.isIsConquered()) {
                        if(ct.getCastlePoints() > maior) {
                            maior = ct.getCastlePoints();
                            for(List<String> battleLine : ct.getBattleLine()) {
                                if(battleLine.contains(naruto.getDice().toString())) {
                                    return battleLine;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
