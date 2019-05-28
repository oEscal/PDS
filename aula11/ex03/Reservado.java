package aula11.ex03;

public class Reservado extends StateLivro {

    @Override
    public boolean cancelaReserva(Book book) {

        book.setState(new Disponivel());
        return true;
    }
}
