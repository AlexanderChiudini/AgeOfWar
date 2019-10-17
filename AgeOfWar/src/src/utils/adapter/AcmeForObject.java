package src.utils.adapter;

import bu.xml.acme.XMLSave;
import java.util.List;

public class AcmeForObject implements Adapter{
    
    private XMLSave xml;
    
    public AcmeForObject(String rootName) {
        this.xml = new XMLSave(rootName);
    }

    @Override
    public void savePlayer(String file, String player, int points, List<String> castleConquered) {
        
    }
    
    
}