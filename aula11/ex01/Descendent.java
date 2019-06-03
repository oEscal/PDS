package aula11.ex01;

import java.util.Comparator;
import java.util.List;

public class Descendent implements Sort {


    @Override
    public List<Telemovel> ordering(List<Telemovel> catalog, String attr) {

        if( attr.toLowerCase() == "nome")
            catalog.sort(Comparator.comparing(Telemovel::getName).thenComparingDouble(Telemovel::getPrice).reversed());

        else if (attr.toLowerCase() == "camara")
            catalog.sort(Comparator.comparingInt(Telemovel::getCamera).thenComparing(Telemovel::getName).reversed());

        else if (attr.toLowerCase() == "memoria")
            catalog.sort(Comparator.comparingInt(Telemovel::getMemory).thenComparingDouble(Telemovel::getPrice).reversed());

        else if (attr.toLowerCase() == "preco")
            catalog.sort(Comparator.comparingDouble(Telemovel::getPrice).thenComparing(Telemovel::getName).reversed());

        else
            catalog.sort(Comparator.comparing(Telemovel::getProcessor).thenComparingDouble(Telemovel::getPrice).reversed());

        return catalog;
    }
}
