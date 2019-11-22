
package core.visitor;

import core.model.Clan;

public interface Visitor {
    
    public void visit(Clan clan) throws Exception;
    
}
