
package core.visitor;

import core.builder.AbstractBuilderClan;

public interface Visitor {
    
    public void visit(AbstractBuilderClan clan) throws Exception;
    
}
