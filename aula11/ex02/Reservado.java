package aula11.ex02;

public class Reservado extends StateLivro {

    @Override
    public boolean cancelaReserva(Book book) {

        book.setState(new Disponivel());
        return true;
    }
}
