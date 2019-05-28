package aula11.ex03;

public class Inventario extends StateLivro {

    @Override
    public boolean regista(Book book) {

        book.setState(new Disponivel());
        return true;
    }
}
