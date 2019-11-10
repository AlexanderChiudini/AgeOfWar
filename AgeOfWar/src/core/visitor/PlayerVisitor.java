
package core.visitor;

import core.model.Dice;
import core.model.Player;
import java.util.ArrayList;
import java.util.List;

public class PlayerVisitor implements Visitor {

    private List<Dice> dice = new ArrayList<>();
    
    @Override
    public void visit(Player player) throws Exception {
        dice = player.getDice();
    }

    public List<Dice> getDice() {
        return dice;
    }
    
}
