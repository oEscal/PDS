package aula07.Ex2;

import java.io.FileNotFoundException;

public class Test {

    public static void main(String args[]) {

        TextReaderInterface reader;

        try {
            reader = new TextReader("lusiadas.txt");
            System.out.println(reader.hasNext());
            System.out.println(reader.next());
            System.out.println(reader.next() + "\n\n");

            reader = new CoderFilter(new TextReader("lusiadas.txt"));
            System.out.println(reader.hasNext());
            System.out.println(reader.next());
            System.out.println(reader.next() + "\n\n");

            reader = new ReverseFilter(new TermFilter(new TextReader("lusiadas.txt")));
            System.out.println(reader.hasNext());
            System.out.println(reader.next());
            System.out.println(reader.next() + "\n\n");
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file!");
        }
    }
}
