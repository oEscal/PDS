package aula10.ex01;

public class Produto {

    private static int id = 0;
    private int id_product = ++id;

    private String description;
    private double base_price;
    private Estado state;
    private Gestor manager;

    public Produto (Gestor manager, String description, double base_price){

        this.manager = manager;
        manager.addProcuct(this);

        this.description = description;
        this.base_price = base_price;
        this.state = Estado.Stock;
    }

    public void changeState(Estado new_state) {
        this.state = new_state;
    }

    public int getId() {
        return this.id_product;
    }

    public Estado getState() {
        return this.state;
    }

    public double getBasePrice() {
        return this.base_price;
    }

    public String getDescription() {
        return this.description;
    }

    public Gestor getManager() {
        return this.manager;
    }
}
