
package core.visitor;

import core.builder.AbstractBuilderClan;
import core.model.Clan;

public interface Visitor {
    
//    public void visit(AbstractBuilderClan clan) throws Exception;
    public void visit(Clan clan) throws Exception;
    
}
