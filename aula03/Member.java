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
        if(/*function(name)*/ false)
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


    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", num_initial=" + num_initial +
                ", num_final=" + num_final +
                '}';
    }
}
