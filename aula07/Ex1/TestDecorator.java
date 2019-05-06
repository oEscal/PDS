package aula07.Ex1;

public class TestDecorator {

    public static void main(String[] args) {

        EmployeeInterface empregado = new TeamLeader(new Manager( new Employee("Nicolau Pedro")));
        TeamMember membroEmp = new TeamMember(new Employee("Baiao"));
        TeamLeader boss = new TeamLeader(new Manager(new TeamMember(new Employee("Joana"))));

        EmployeeInterface listEmp[] = { empregado, membroEmp, boss};
        for (EmployeeInterface emp : listEmp){
            emp.start("31/02/2019");
            emp.work();
            emp.terminate("31/02/2020");
        }
    }
}
