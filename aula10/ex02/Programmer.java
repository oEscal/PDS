package aula10.ex02;

public class Programmer extends Employee {
    public Programmer(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
