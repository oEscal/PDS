package aula11.ex02;

public class Disponivel extends StateLivro {

    @Override
    public boolean requisita(Book book) {

        book.setState(new Emprestado());
        return true;
    }

    @Override
    public boolean reserva(Book book) {

        book.setState(new Reservado());
        return true;
    }
}
