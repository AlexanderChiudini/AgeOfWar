package src.utils.adapter;

import br.tecfile.GravarArquivo;
import java.util.List;

public class TecFileForObject implements Adapter{
    
    private GravarArquivo file;

    public TecFileForObject() {
        this.file = new GravarArquivo();
    }

    @Override
    public void savePlayer(String file, String player, int points, List<String> castleConquered) {
        String castles = "";
        for(String castle : castleConquered){
            castles += castle+",";
        }
        
        String data = "Player : "+player+"\n"
                     +"Points : "+points+"\n"
                     +"Castles Conquered for this player : "+castles
                     +"\n\n\n";
    }
    
}