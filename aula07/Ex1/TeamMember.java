package aula07.Ex1;

public class TeamMember extends EmployeeDecorator {

    public TeamMember(EmployeeInterface employee) {
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
        System.out.println("as teamMember");
    }

    public void colaborate(){
        employee.work();
        System.out.println("colaboration!");
    }




}
