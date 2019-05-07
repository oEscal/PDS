package aula08.ex1b;

import java.util.List;

public class SharkCompany {

        public static void main(String[] args) {
            Person[] persons = { new Person("Maria Silva"),
                    new Person("Manuel Pereira"),
                    new Person("Aurora Machado"),
                    new Person("Augusto Lima")
            };
            Company shark = new Company();
            Company.user = User.COMPANY;
            shark.admitPerson(persons[0].getName(), 1000);
            shark.admitPerson(persons[1].getName(), 900);
            shark.admitPerson(persons[2].getName(), 1200);
            shark.admitPerson(persons[3].getName(), 1100);
            List<Employee> sharkEmps = shark.employees();
            for (Employee e : sharkEmps)
                System.out.println(e.getSalary());
            shark.paySalaries(1);
        }
}
