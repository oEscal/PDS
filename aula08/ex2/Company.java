package aula08.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    public static User user;
    private List<Employee> emps = new ArrayList<>();
    public void admitPerson(Person person, double salary) {
        Employee e = new Employee(person.getName(), salary);
        emps.add(e);

        SocialSecurity.regist(person);
        Insurance.regist(person);
        EmployeeCard card = new EmployeeCard(person);
        Parking.allow(person);
    }
    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }
    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }

}
