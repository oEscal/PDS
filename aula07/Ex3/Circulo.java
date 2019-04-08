package aula07.Ex3;

public class Circulo extends Figure {

    private String color;

    public Circulo(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() +"Circulo "+  this.color);
    }
}
