package aula01;

import java.util.TreeMap;

public class SoupMap extends TreeMap {

    @Override
    public Object put(Object key, Object value) {

        if(this.containsKey(key))
            ErrorsSoap.duplicationInPuzzleError();
        return super.put(key, value);
    }
}
