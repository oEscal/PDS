package aula09.ex1;

import java.util.Iterator;
import java.util.ListIterator;
import  java.util.ListIterator;

public class TestEx1 {
    public static void main(String[] args) {

        VectorGeneric<String> myVectorG = new VectorGeneric<String>();

        for (int index = 0; index < 10; index++) {

            myVectorG.addElem("ola" + index);

            if(index%2 == 0)
                myVectorG.removeElem("ola"+index);
        }

        Iterator myVectorIter = myVectorG.iterator();

        while(myVectorIter.hasNext()){
            System.out.println(myVectorIter.next());
        }

        ListIterator myVectorListIter = myVectorG.listIterator();

        System.out.println(myVectorListIter.nextIndex());
        while(myVectorListIter.hasNext()){
            System.out.println(myVectorListIter.next());
        }

        while(myVectorListIter.hasPrevious()){
            System.out.println(myVectorListIter.previous());
        }



    }
}
