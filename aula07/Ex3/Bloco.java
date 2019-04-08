package aula07.Ex3;

import java.util.ArrayList;
import java.util.List;

public class Bloco implements Figure {

    private String position;
    //List of geometric figures
    private List<Figure> drawing = new ArrayList<>();

    public Bloco (String position){
        this.position = position;
    }

    public void add(Figure fig){
        drawing.add(fig);
    }

    @Override
    public void draw() {

        System.out.println(indent.toString() + "Window "+this.position);
        indent.append("   ");
        for (Figure fig: drawing)
            fig.draw();
        indent.setLength(indent.length() - 3);
    }
}
