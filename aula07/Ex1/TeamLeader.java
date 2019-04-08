package aula07.Ex1;

public class TeamLeader extends EmployeeDecorator {

    public TeamLeader(EmployeeInterface employee) {
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
        System.out.println("as TeamLeader");
    }

    public void plan(){
        employee.work();
        System.out.println("planning!");
    }
}
