package aula05.V1;

public class BeverageFactory{

    public static Commodity createBeverage(Temperature t) {
        if (t == Temperature.COLD)
            return new FruitJuice(t);
        else
            if (t == Temperature.WARM)
                return new Milk(t);

        return null;
    }
}
