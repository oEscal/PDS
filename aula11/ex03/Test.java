package aula11.ex03;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    private static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {

        Book[] books = new Book[] {
                new Book("Java Anti-Stress", "Omodionah", 1, 1990),
                new Book("A Guerra dos Padrões", "Jorge Omel", 2, 1991),
                new Book("A Procura da Luz", "Khumatkli", 3, 1992)
        };

        while (true) {
            System.out.println("*** Biblioteca ***");
            Arrays.asList(books).forEach(b -> System.out.println(b.toString()));
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela\n");

            System.out.printf(">> ");
            String opt = input.nextLine();

            String[] options = opt.split(",");
            Book current_book = books[Integer.parseInt(options[0]) - 1];
            if (Integer.parseInt(options[1]) == 5)
                break;
            if (!changeState(Integer.parseInt(options[1]), current_book))
                System.out.println("Operação não disponível\n\n");
        }
    }

    private static boolean changeState(int option, Book b) {

        switch (option) {
            case 1:
                return b.regista();
            case 2:
                return b.requisita();
            case 3:
                return b.devolve();
            case 4:
                return b.reserva();
        }
        return false;
    }
}
