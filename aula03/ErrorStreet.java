package aula03;

public class ErrorStreet {

    public static void nonExistDoorError() {
        System.out.println("Door must be bigger than 0!");
    }

    public static void doorsIntervalError() {
        System.out.println("x2 must be bigger or equal than x1");
    }

    public static void memberNameError() {
        System.out.println("Members's names must begin with a letter, " +
                "can't end in a symbol, " +
                "can't have more than 40 characters " +
                "and can contain letters, digits and the symbols _.@");
    }

}