package aula11.ex01;


import java.util.ArrayList;
import java.util.List;

public class Revista {

    private List<Telemovel> catalog = new ArrayList<>();
    private Sort opSort;

    public Revista (Sort opSort){
        this.opSort = opSort;
    }

    public boolean addTlmv (Telemovel tlmv){

        if(!catalog.contains(tlmv)){
            catalog.add(tlmv);
            return true;
        }
        return false;
    }

    public void setOpSort(Sort opSort){
        this.opSort = opSort;
    }

    public List<Telemovel> ordering(String attr){
            return this.opSort.ordering(this.catalog , attr);
    }


}
