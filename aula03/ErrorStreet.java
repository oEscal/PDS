package aula03;

public class ErrorStreet {

    public static void nonExistDoorError() {
        throw new ArithmeticException("Door must be upper than 0!");
    }

    public static void errDoorsIntervalError() {
        throw new ArithmeticException("x2 must be bigger or equal than x1");
    }

    public boolean check_familyName(String name) {

        return name.length() <= 40 &&  //Check if name had dimension less then 40
                (name.charAt(0) + "").matches("[A-Za-z]") && //Check if name starts with letter
                !(name.charAt(name.length() - 1) + "").matches("[@._]") && //Check if name dont finish with {@_.}
                name.matches("[A-Za-z0-9._@]+"); //Check if name had some invalid characters

    }

}