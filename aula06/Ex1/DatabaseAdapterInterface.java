package aula06.Ex1;

public interface DatabaseAdapterInterface {

    // add new employee to database
    public void addEmployee(Employee new_employee);

    // add new employee to database
    public void addEmployee(Empregado new_employee);

    // delete employee from database with the given code
    public void deleteEmployee(long code);

    // verify if the employee with the id=code is in the database
    public boolean verify(long code);

    // print all employees
    public void getAllEmployees();
}
