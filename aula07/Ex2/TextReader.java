package aula07.Ex2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements TextReaderInterface {

    private Scanner file_scanner;

    public TextReader(String file_name) throws FileNotFoundException {

        File file = new File(file_name);
        this.file_scanner = new Scanner(file);
    }

    @Override
    public boolean hasNext() {
        return file_scanner.hasNext();
    }

    @Override
    public String next() {
        return file_scanner.nextLine();
    }
}
