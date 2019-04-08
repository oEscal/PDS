package aula07.Ex2;

import java.io.FileNotFoundException;

public class TermFilter extends TextReaderDecorator {

    public TermFilter(TextReaderInterface this_text_reader) throws FileNotFoundException {
        super(this_text_reader);
    }
}
