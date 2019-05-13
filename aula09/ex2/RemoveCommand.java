package aula09.ex2;

import java.util.Collection;

public class RemoveCommand<E> implements CollectionCommand<E> {

    private Collection<E> collection;
    private E last_remove;

    public RemoveCommand(Collection<E> c) {
        this.collection = c;
    }

    @Override
    public boolean execute(E element) {

        boolean result = this.collection.remove(element);
        if (result)
            this.last_remove = element;
        return result;
    }

    @Override
    public void undo() {
        if (this.last_remove != null)
            this.collection.add(this.last_remove);
    }
}
