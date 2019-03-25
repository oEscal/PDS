package aula05.V2;

public class LunchDirector {

    private static LunchBuilder lunch_builder;

    public LunchDirector(LunchBuilder lb){

        this.lunch_builder = lb;
    }

    public void constructMeal() {

        lunch_builder.buildDtrink();
        lunch_builder.buildMainCourse();
        lunch_builder.buildSide();
    }

    public Lunch getMeal() {
        return lunch_builder.getMeal();
    }
}
