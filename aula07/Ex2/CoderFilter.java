package aula07.Ex2;

import java.io.FileNotFoundException;

public class CoderFilter extends TextReaderDecorator {

    public CoderFilter(TextReaderInterface this_text_reader) throws FileNotFoundException {
        super(this_text_reader);
    }

    @Override
    public String next() {
        return changeRandomLetters(super.next());
    }

    private String changeRandomLetters(String n) {

        StringBuilder sb = new StringBuilder(n);
        for (int index = 0; index < sb.length(); index++)
            if(Math.random() < 0.5)
                sb.setCharAt(index, (char) ((int) (Math.random()*(122 - 48) + 48)));

        return sb.toString();
    }
}
