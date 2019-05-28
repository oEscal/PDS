package aula10.ex01;

import java.util.*;

public class ProdutoLeilao {

    private double current_bid;
    private Cliente current_winner;
    private Produto product;

    private Set<Cliente> clients;

    private static Map<Integer, ProdutoLeilao> prods = new HashMap<>();

    private ProdutoLeilao(Produto product) {

        this.current_bid = product.getBasePrice();
        this.product = product;

        this.clients = new TreeSet<>();
    }

    public static ProdutoLeilao addProductToAuction (Produto new_prod) {

        int id = new_prod.getId();

        if (!prods.containsKey(id)) {

            new_prod.changeState(Estado.Leilao);

            ProdutoLeilao new_product_auction = new ProdutoLeilao(new_prod);
            prods.put(id, new_product_auction);

            return new_product_auction;
        }

        return prods.get(id);
    }

    public boolean makeBid(double new_bid, Cliente client) {

        if (this.current_bid < new_bid) {

            this.current_bid = new_bid;
            this.current_winner = client;

            // notify manager and clients
            String message = "O produto de id " + this.product.getId()
                    + " e descrição " + this.product.getDescription()
                    + " recebeu uma oferta mais elevada, de valor " + this.current_bid;
            notifyClientsAndManager(message);

            // add this client to client's set
            this.clients.add(client);

            return true;
        }

        return false;
    }

    public void endAuction() {

        if (this.current_winner == null) {

            this.product.changeState(Estado.Stock);
            System.out.println("O produto não foi leiloado!");
        } else {

            this.product.changeState(Estado.Vendas);
            System.out.println("O produto foi leiloado a " + this.current_winner.getName() + " !");
        }

        // notify manager and clients
        String message = "O produto de id " + this.product.getId()
                + " e descrição " + this.product.getDescription()
                + " foi vendido por " + this.current_bid;
        notifyClientsAndManager(message);


        prods.remove(this.product);
    }

    private void notifyClientsAndManager(String message) {

        Iterator<Cliente> clients_iterator = clients.iterator();
        while(clients_iterator.hasNext())
            clients_iterator.next().notifyAll(message);

        this.product.getManager().notifyAll(message);
    }

    public String getDescription() {
        return this.product.getDescription();
    }

    public int getId() {
        return this.product.getId();
    }

    public double getCurrentBid() {
        return this.current_bid;
    }
}
