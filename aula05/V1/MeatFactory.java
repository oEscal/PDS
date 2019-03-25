package aula05.V1;

public class MeatFactory {

    public static Commodity createMeat(Temperature t) {

        if (t == Temperature.COLD)
            return new Tuna(t);
        else
            if (t == Temperature.WARM)
                return new Pork(t);

        return null;
    }
}
