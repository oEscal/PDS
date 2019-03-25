package aula05.V1;

public class Tuna extends Meat {

    public Tuna(Temperature t) {
        super(t);
    }

    @Override
    public String toString() {
        return "Tuna [" + super.toString() + "]";
    }
}
