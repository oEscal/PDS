package aula05.V2;

public class SnackLunchBuilder implements LunchBuilder {

    protected Lunch lunch;

    public SnackLunchBuilder(){

        this.lunch = new Lunch();
    }

    @Override
    public void buildDtrink() {
        this.lunch.setDrink("Sumo");
    }

    @Override
    public void buildMainCourse() {
        this.lunch.setMainCourse("Pão com panado");
    }

    @Override
    public void buildSide() {
        this.lunch.setSide("Rissol");
    }

    @Override
    public Lunch getMeal() {
        return this.lunch;
    }
}
