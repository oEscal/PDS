package aula05.V1;

public abstract class Beverage implements Commodity{

    private Temperature temperature;
    final private State state;

    public Beverage(Temperature t){
        this.temperature = t;

        this.state = State.Liquid;
    }

    @Override
    public Temperature getTemperature() {
        return this.temperature;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return "temperature=" + temperature +
                ", state=" + state;
    }
}
