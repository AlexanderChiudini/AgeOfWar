package core.visitor;

import core.model.Clan;

public class ClanVisitor implements Visitor {

    private boolean clanConquistado;
    
    @Override
    public void visit(Clan clan) throws Exception {
        int tamanho = clan.sizeCastleList();
        int conquistas = 0;
        for (int i = 0; i < tamanho; i++) {
            if (clan.getCastle(i).isConquered()) {
                conquistas++;
            }
        }
        this.clanConquistado = (tamanho == conquistas);
    }

    public boolean isClanConquistado() {
        return clanConquistado;
    }

}
