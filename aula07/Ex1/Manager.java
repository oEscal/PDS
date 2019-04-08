package aula07.Ex1;

public class Manager extends EmployeeDecorator {

    public Manager(EmployeeInterface employee) {
        super(employee);
    }

    @Override
    public void start(String date) {
        employee.start(date);
    }

    @Override
    public void terminate(String date) {
        employee.terminate(date);
    }

    @Override
    public void work() {
        employee.work();
        System.out.println("as Manager");
    }

    public void manage(){
        employee.work();
        System.out.println("management!");
    }
}
