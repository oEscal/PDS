package aula10.ex01;

public class Test {

    public static void main(String[] args) {

        Gestor manager = new Gestor("Jacinto");

        Produto prod1 = new Produto(manager, "Fiat Panda", 3000);
        Produto prod2 = new Produto(manager, "PC lenovo", 800);
        Produto prod3 = new Produto(manager, "Vinho do porto", 20);
        Produto prod4 = new Produto(manager, "Sapatilhas da nike", 50);
        Produto prod5 = new Produto(manager, "Bolo", 1);


        Cliente cl1 = new Cliente(manager,"Escaleira");
        Cliente cl2 = new Cliente(manager,"André");
        Cliente cl3 = new Cliente(manager,"Pedro");

        manager.addProcuct(prod1);
        manager.addProcuct(prod5);
        manager.addProcuct(prod2);

        manager.startAuction(prod1);
        manager.startAuction(prod5);
        manager.startAuction(prod2);


        cl1.makeBid(manager.getAuctionList().get(0),4000);
        cl2.makeBid(manager.getAuctionList().get(0),5000);
        cl3.makeBid(manager.getAuctionList().get(1),10);
        cl2.makeBid(manager.getAuctionList().get(1),20);

        manager.getAuctionList().get(0).endAuction();
        manager.getAuctionList().get(0).endAuction();

    }




}
