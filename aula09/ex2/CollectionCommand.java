package aula09.ex2;

public interface CollectionCommand<E> {

    public boolean execute(E element);

    public void undo();
}
