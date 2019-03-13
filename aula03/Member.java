package aula03;

public class Member {

    // parameters
    private String name;
    private int num_initial,
                num_final;

    // private constructor
    private Member(String name, int num_initial, int num_final){
        this.name = name;
        this.num_initial = num_initial;
        this.num_final = num_final;
    }

    // public factory
    public static Member factory(String name, int num_initial, int num_final){

        // verify name
        if(!checkNames(name))
            return null;
        return new Member(name, num_initial, num_final);
    }

    public String getName() {
        return name;
    }

    public int getNum_initial() {
        return num_initial;
    }

    public int getNum_final() {
        return num_final;
    }

    private static boolean checkNames(String name) {

        return name.length() <= 40 &&  //Check if name had dimension less then 40
                (name.charAt(0) + "").matches("[A-Za-z]") && //Check if name starts with letter
                !(name.charAt(name.length() - 1) + "").matches("[@._]") && //Check if name dont finish with {@_.}
                name.matches("[A-Za-z0-9._@]+"); //Check if name had some invalid characters

    }


    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", num_initial=" + num_initial +
                ", num_final=" + num_final +
                '}';
    }
}
