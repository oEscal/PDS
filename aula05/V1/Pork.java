package aula05.V1;

public class Pork extends Meat {

    public Pork(Temperature t) {
        super(t);
    }

    @Override
    public String toString() {
        return "Pork [" + super.toString() + "]";
    }
}
