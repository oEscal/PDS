package aula07.Ex1;

public  abstract class EmployeeDecorator implements EmployeeInterface  {

    protected EmployeeInterface employee;

    public EmployeeDecorator  (EmployeeInterface employee){
        this.employee=employee;
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
    }
}
