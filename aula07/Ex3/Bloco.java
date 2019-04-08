package aula07.Ex3;

import java.util.ArrayList;
import java.util.List;

public class Bloco extends Figure {

    private static final int INDENTATION = 3;

    private String position;
    private List<Figure> drawing;               //List of geometric figures

    public Bloco (String position){

        this.position = position;
        this.drawing = new ArrayList<>();
    }

    public void add(Figure fig){
        this.drawing.add(fig);
    }

    @Override
    public void draw() {

        System.out.println(this.indent.toString() + "Window " + this.position);

        for (int i = 0; i < INDENTATION; i++)
            this.indent.append(" ");

        for (Figure fig: this.drawing)
            fig.draw();
        this.indent.setLength(this.indent.length() - INDENTATION);
    }
}
