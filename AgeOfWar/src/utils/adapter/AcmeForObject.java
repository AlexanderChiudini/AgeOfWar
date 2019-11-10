package utils.adapter;

import bu.xml.acme.XMLSave;
import java.util.List;
import core.model.Castle;

public class AcmeForObject implements Adapter{
    
    private XMLSave xml;
    
    public AcmeForObject(String rootName) {
        this.xml = new XMLSave(rootName);
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
        
         this.xml.save(arquivo, player, data);
    }
    
    
}