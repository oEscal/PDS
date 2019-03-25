package aula05.V2;

public class CentralCantineLunchBuilder implements LunchBuilder {

    protected Lunch lunch;

    public CentralCantineLunchBuilder(){

        this.lunch = new Lunch();
    }

    @Override
    public void buildDtrink() {
        this.lunch.setDrink("Água");
    }

    @Override
    public void buildMainCourse() {
        this.lunch.setMainCourse("Grelhada mista");
    }

    @Override
    public void buildSide() {
        this.lunch.setSide("Queijo fresco");
    }

    @Override
    public Lunch getMeal() {
        return this.lunch;
    }
}
