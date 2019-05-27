package aula11.ex02;

public class Emprestado extends StateLivro {

    @Override
    public boolean devolve(Book book) {

        book.setState(new Disponivel());
        return true;
    }
}
