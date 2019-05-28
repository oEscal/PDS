package aula10.ex01;

public class Cliente implements Observer, Comparable{

    private String name;
    private Gestor manager;

    public Cliente(Gestor manager, String name){
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return this.name;
    }

    public void makeBid(ProdutoLeilao prod, double bid){
        prod.makeBid(bid,this);

    }

    @Override
    public void notifyAll(String notification) {
        System.out.println(notification);
    }

    @Override
    public int compareTo(Object o) {
        return this.name.length() - ((Cliente) o).getName().length();
    }
}
