package aula10.ex01;

public class Produto {

    static int id = 0;
    private int id_product = id + 1;

    private String description;
    private double price;

    public Produto (String description, double price){
        this.description = description;
        this.price = price;
    }

}
