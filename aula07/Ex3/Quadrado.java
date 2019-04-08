package aula07.Ex3;

public class Quadrado implements Figure {

    private String color;

    public Quadrado(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() + "Quadrado "+this.color);
    }
}
