package aula05.V2;

public class CrastoLunchBuilder implements LunchBuilder {

    protected Lunch lunch;

    public CrastoLunchBuilder(){

        this.lunch = new Lunch();
    }

    @Override
    public void buildDtrink() {
        this.lunch.setDrink("Vinho");
    }

    @Override
    public void buildMainCourse() {
        this.lunch.setMainCourse("Bacalhau à lagareiro");
    }

    @Override
    public void buildSide() {
        this.lunch.setSide("Broa");
    }

    @Override
    public Lunch getMeal() {
        return this.lunch;
    }
}
