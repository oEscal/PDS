package aula05.V3;

import java.util.Calendar;

public class Test {

    public static void main (String args[]) {

        Person.Builder builder = new Person.Builder("Pedro", "Escaleira");

        builder.city("Viseu").isFemale(false);

        System.out.println(builder.getPerson());
    }
}
