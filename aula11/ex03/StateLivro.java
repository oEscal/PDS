package aula11.ex03;

public abstract class StateLivro {

    public boolean regista(Book book) {
        return false;
    }

    public boolean requisita(Book book) {
        return false;
    }

    public boolean devolve(Book book) {
        return false;
    }

    public boolean reserva(Book book) {
        return false;
    }

    public boolean cancelaReserva(Book book) {
        return false;
    }
}
