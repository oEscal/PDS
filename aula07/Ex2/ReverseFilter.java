package aula07.Ex2;

import java.io.FileNotFoundException;

public class ReverseFilter extends TextReaderDecorator {

    public ReverseFilter(TextReaderInterface this_text_reader) throws FileNotFoundException {
        super(this_text_reader);
    }

    @Override
    public String next() {

        return (new StringBuilder(super.next()))
                .reverse()
                .toString();
    }
}
