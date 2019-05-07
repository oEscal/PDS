package aula08.ex1b;

public class Employee {

    private String name;
    private double salary;
    private BankAccount bankAccount;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        return new BankAccountImplProxy(bankAccount);
    }

}
