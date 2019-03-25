package aula05.V1;

import java.util.Random;

public class ContainerFactory {

    private static Random rand = new Random();

    public static Container createContainerFor(Commodity c) {

        if (c.getState() == State.Liquid){

            if (c.getTemperature() == Temperature.COLD)
                return (rand.nextDouble() > 0.5) ? new PlasticBottle() : new TermicBottle();

            if (c.getTemperature() == Temperature.WARM)
                return new TermicBottle();
        }

        if (c.getState() == State.Solid){

            if (c.getTemperature() == Temperature.COLD)
                return (rand.nextDouble() > 0.5) ? new Tupperware() : new PlasticBag();

            if (c.getTemperature() == Temperature.WARM)
                return new Tupperware();
        }

        return null;
    }
}
