package aula06.Ex1;

import java.util.Arrays;
import java.util.Scanner;

public class Pst {

    private static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {

        // Create a new database and a new "registos" object (database2)
        Database database1 = new Database();
        Registos database2 = new Registos();

        // test add new employees (10) to database1 and to database2
        for(int i = 0; i < 10; i++){
            database1.addEmployee(new Employee("Olá" + i, i*2, i/10.0 + 500));
            database2.insere(new Empregado("Olá" + i, "Adeus", i*2 + 1, i/10.0 + 700));
        }


        // simple menu to choose if the user wants to test with or without the adapter
        System.out.print("Menu:\n" +
                "1 - without Adapter\n" +
                "2 - with Adapter\n" +
                "> ");
        try{
            int opt = input.nextInt();

            if(opt == 1)
                checkWithoutAdapter(database1, database2);
            else
            if (opt == 2)
                checkWithAdapter(database1, database2);
        }catch (java.util.InputMismatchException e){
        }
    }

    private static void checkWithoutAdapter(Database database1, Registos database2){

        // print all info about the two databases
        printTwoDatabases(database1, database2);

        // verify if some employee belongs to database2
        System.out.println("\n\nVerify if they are employees");
        for(int i = 0; i < 10; i++)
            System.out.println(database2.isEmpregado(i));

        // remove a employee from database and print the result
        System.out.println("\n\nRemove the first five employees from the two databases");
        for(int i = 0; i < 5; i++){
            database1.deleteEmployee(i);
            database2.remove(i);
        }
        printTwoDatabases(database1, database2);
    }

    private static void checkWithAdapter(Database database1, Registos database2) {

        DatabaseAdapterInterface database = new DatabaseAdapter(database1, database2);

        // add more employees to the database
        for (int i = 20; i < 25; i++){
            database.addEmployee(new Employee("Adeus" + i, i*2, i/10.0 + 500));
            database.addEmployee(new Empregado("Adeus" + i, "Olá", i*2 + 1, i/10.0 + 700));
        }

        // print all info about the two databases
        database.getAllEmployees();

        // verify if some employee belongs to database
        System.out.println("\n\nVerify if they are employees");
        for(int i = 0; i < 20; i++)
            System.out.println(database.verify(i));

        // remove a employee from database and print the result
        System.out.println("\n\nRemove the first five employees from the two databases");
        for(int i = 0; i < 5; i++)
            database.deleteEmployee(i);
        database.getAllEmployees();
    }

    // print all info about the two databases
    private static void printTwoDatabases(Database database1, Registos database2){

        System.out.println("Database1:");
        Arrays.asList(database1.getAllEmployees()).forEach(
                emp -> System.out.println(
                        "Name: " + emp.getName() +
                                "; Code: " + emp.getEmpNum() +
                                "; Salary: " + emp.getSalary()
                )
        );

        System.out.println("\n\nDatabase2:");
        database2.listaDeEmpregados().forEach(
                emp -> System.out.println(
                        "First: " + emp.nome() +
                                "; LastName: " + emp.apelido() +
                                "; Code: " + emp.codigo() +
                                "; Salary: " + emp.salario()
                )
        );
    }
}
