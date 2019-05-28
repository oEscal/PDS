package aula11.ex03;

public class Book {

    private StateLivro current_state;
    private String title,
            first_author;
    private int isbn,
            year;

    public Book(String title, String first_author, int isbn, int year) {
        this.title = title;
        this.first_author = first_author;
        this.isbn = isbn;
        this.year = year;

        this.current_state = new Inventario();
    }

    public void setState(StateLivro state) {

        this.current_state = state;
    }


    public boolean regista() {
        return this.current_state.regista(this);
    }

    public boolean requisita() {
        return this.current_state.requisita(this);
    }

    public boolean devolve() {
        return this.current_state.devolve(this);
    }

    public boolean reserva() {
        return this.current_state.reserva(this);
    }

    public boolean cancelaReserva() {
        return this.current_state.cancelaReserva(this);
    }

    @Override
    public String toString() {

        String[] class_name = current_state.getClass().getName().split("\\.");
        String result = String.format("%-5d%-30s%-15s%-15s",
                isbn,
                title,
                first_author,
                "[" + class_name[class_name.length - 1] + "]");

        return result;
    }
}
