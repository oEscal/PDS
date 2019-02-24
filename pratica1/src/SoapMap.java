import java.util.TreeMap;

public class SoapMap extends TreeMap {

    @Override
    public Object put(Object key, Object value) {
        if(this.containsKey(key))
            ErrorsSoapSolver.duplicationInPuzzleError();
        return super.put(key, value);
    }
}
