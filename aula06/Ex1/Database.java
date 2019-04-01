package aula06.Ex1;

import java.util.Vector;

public class Database {

    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }


    public boolean addEmployee(Employee employee) {

        if (employees.contains(employee))
            return false;

        employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {

        for (Employee ey : employees)
            if ( ey.getEmpNum() == emp_num){
                employees.remove(ey);
                break;
            }
    }

    public Employee[] getAllEmployees() {

        // Cast de employees para Employee[]
        return employees.toArray(new Employee[0]);
    }
}
