package utils.adapter;

import java.util.List;
import core.model.Castle;

public interface Adapter {
    
    void savePlayer(String player, int points, List<Castle> castleConquered, String arquivo);
}
