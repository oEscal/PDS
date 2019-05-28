package aula10.ex01;

import java.util.ArrayList;
import java.util.List;

public class Gestor implements Observer{

    private String name;
    private List<Produto> products_list;

    public Gestor(String name){

        this.name = name;
        this.products_list = new ArrayList<>();
    }

    public void addProcuct(Produto new_prod) {
        products_list.add(new_prod);
    }

    public boolean startAuction(Produto prod_to_auction){

        if(products_list.contains(prod_to_auction)){
            ProdutoLeilao.addProductToAuction(prod_to_auction);
            return true;
        }

        return false;
    }

    public List<ProdutoLeilao> getAuctionList() {

        List<ProdutoLeilao> auction_prods = new ArrayList<>();

        this.products_list.forEach(prod -> {

            if (prod.getState() == Estado.Leilao)
                auction_prods.add(ProdutoLeilao.addProductToAuction(prod));
        });

        return auction_prods;
    }


    @Override
    public void notifyAll(String notification) {
        System.out.println(notification);
    }
}
