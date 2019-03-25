package aula05.V1;

public class FruitJuice extends Beverage {

    private FruitName fruit_name;

    public FruitJuice(Temperature t) {
        super(t);

        this.fruit_name = FruitName.Orange;
    }

    public FruitJuice(Temperature t, FruitName f){
        super(t);

        this.fruit_name = f;
    }

    @Override
    public String toString() {
        return "FruitJuice [fruit=" + this.fruit_name + " " + super.toString() + "]";
    }
}
