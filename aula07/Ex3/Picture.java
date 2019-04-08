package aula07.Ex3;

public class Picture implements Figure{

    private String position;

    public Picture(String position){
        this.position = position;
    }


    @Override
    public void draw() {
        System.out.println(indent.toString() + this.position);
    }
    
}
