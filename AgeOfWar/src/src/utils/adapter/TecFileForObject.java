package src.utils.adapter;

import br.tecfile.GravarArquivo;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scr.core.model.Castle;

public class TecFileForObject implements Adapter{
    
    private GravarArquivo file;

    public TecFileForObject() {
        this.file = new GravarArquivo();
    }

    @Override
    public void savePlayer(String player, int points, List<Castle> castleConquered, String arquivo) {
        String castles = "";
        for(Castle castle : castleConquered){
            castles += castle.toString()+",";
        }
        
        String data = "Player : "+player+"\n"
                     +"Points : "+points+"\n"
                     +"Castles Conquered for this player : "+castles
                     +"\n\n\n";
        
        try {
            if (!Files.exists(Paths.get(arquivo))) {
                this.file.salvar(arquivo, data);
            }else{
                this.file.addNoFim(arquivo, data);
            }
        } catch (Exception ex) {
            Logger.getLogger(TecFileForObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}