package aula11.ex02;

public class Inventario extends StateLivro {

    @Override
    public boolean regista(Book book) {

        book.setState(new Disponivel());
        return true;
    }
}
