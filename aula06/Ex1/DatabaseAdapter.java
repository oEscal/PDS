package aula06.Ex1;

import java.util.Arrays;

public class DatabaseAdapter implements DatabaseAdapterInterface {

    private Database database1;
    private Registos database2;

    public DatabaseAdapter(Database database1, Registos database2){

        this.database1 = database1;
        this.database2 = database2;
    }

    @Override
    public void addEmployee(Employee new_employee) {

        database1.addEmployee(new_employee);
    }

    @Override
    public void addEmployee(Empregado new_employee) {

        database2.insere(new_employee);
    }

    @Override
    public void deleteEmployee(long code) {

        database1.deleteEmployee(code);
        database2.remove((int) code);
    }

    @Override
    public boolean verify(long code) {

        for (Employee emp : Arrays.asList(database1.getAllEmployees())) {

            if (emp.getEmpNum() == code)
                return true;
        }

        return database2.isEmpregado((int) code);
    }

    @Override
    public void getAllEmployees() {

        Arrays.asList(database1.getAllEmployees()).forEach(
                emp -> System.out.println(
                        "Name: " + emp.getName() +
                        "; Code: " + emp.getEmpNum() +
                        "; Salary: " + emp.getSalary()
                )
        );

        database2.listaDeEmpregados().forEach(
                emp -> System.out.println(
                        "First: " + emp.nome() +
                        "LastName: " + emp.apelido() +
                        "; Code: " + emp.codigo() +
                        "; Salary: " + emp.salario()
                )
        );
    }
}
