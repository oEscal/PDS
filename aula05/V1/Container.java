package aula05.V1;

public abstract class Container {

    protected Commodity commodity;

    public boolean placeCommodity(Commodity c){

        this.commodity = c;

        return true;
    }

    @Override
    public String toString() {
        return "Container{" +
                "commodity=" + commodity +
                '}';
    }
}
