package aula09.ex2;

import java.util.Collection;

public class AddCommand<E> implements CollectionCommand<E> {

    private Collection<E> collection;
    private E last_add;

    public AddCommand(Collection<E> c) {
        this.collection = c;
    }

    @Override
    public boolean execute(E new_element) {

        boolean result = this.collection.add(new_element);
        if (result)
            this.last_add = new_element;
        return result;
    }

    @Override
    public void undo() {
        if (this.last_add != null)
            this.collection.remove(this.last_add);
    }
}
