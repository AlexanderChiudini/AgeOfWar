
package core.visitor;

import core.model.Dice;
import core.model.Player;

public interface Visitor {
    
    public void visit(Player player) throws Exception;
    
}
