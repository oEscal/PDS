package aula11.ex01;


import java.util.Collections;
import java.util.List;

public class ComparatorTlmv implements Sort {



    @Override
    public List<Telemovel> ordering(List<Telemovel> catalog, String attr) {

        if( attr.toLowerCase() == "nome")
            Collections.sort(catalog, Telemovel.compareByName);

        else if (attr.toLowerCase() == "camara")
            Collections.sort(catalog, Telemovel.compareByCamera);

        else if (attr.toLowerCase() == "memoria")
            Collections.sort(catalog, Telemovel.compareByMemory);

        else if (attr.toLowerCase() == "preco")
            Collections.sort(catalog, Telemovel.compareByPrice);
        else
            Collections.sort(catalog, Telemovel.compareByProcessor);

        return catalog;
    }


}
