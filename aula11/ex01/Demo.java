package aula11.ex01;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        Telemovel t1 = new Telemovel("Xiomi mi A1", 220.99, "Octa Core", 4, 12);
        Telemovel t2 = new Telemovel("Xiomi mi A2", 200.99, "Octa Core", 4, 11);
        Telemovel t3 = new Telemovel("LG", 150, "Octa Core", 5, 9);
        Revista myRev = new Revista(new Growing());
        List<Telemovel> catalog = new ArrayList<>();

        myRev.addTlmv(t1);
        myRev.addTlmv(t2);
        myRev.addTlmv(t3);

        catalog = myRev.ordering("camara");

        for(Telemovel t : catalog)
            System.out.println(t);

        myRev.setOpSort(new Descendent());
        myRev.ordering("camara");
        System.out.println("");

        for(Telemovel t : catalog)
            System.out.println(t);

        myRev.setOpSort(new ComparatorTlmv());
        myRev.ordering("nome");

        System.out.println("");
        for(Telemovel t : catalog)
            System.out.println(t);

    }




}
