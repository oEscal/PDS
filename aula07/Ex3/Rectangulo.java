package aula07.Ex3;

public class Rectangulo extends Figure {

    private String name;

    public Rectangulo(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println(indent.toString() + "Retângulo "+this.name);
    }
}
