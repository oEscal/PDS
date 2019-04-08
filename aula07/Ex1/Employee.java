package aula07.Ex1;

public class Employee implements EmployeeInterface{

    private String name;

    public Employee (String name){
        this.name=name;
    }

    @Override
    public void start(String date) {
        System.out.println( this.name+" start work "+date+"!");
    }

    @Override
    public void terminate(String date) {
        System.out.println( this.name+" end their work "+date+"!");
    }

    @Override
    public void work() {
        System.out.print( this.name+" work ");
    }
}
