package aula05.V1;

public class Milk extends Beverage {


    public Milk(Temperature t) {
        super(t);
    }

    @Override
    public String toString() {
        return "Milk [" + super.toString() + "]";
    }
}
