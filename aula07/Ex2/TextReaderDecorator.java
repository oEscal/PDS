package aula07.Ex2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TextReaderDecorator implements TextReaderInterface {

    protected TextReaderInterface this_text_reader;
    protected List<String> par;

    public TextReaderDecorator(TextReaderInterface this_text_reader) throws FileNotFoundException {

        this.this_text_reader = this_text_reader;
        this.par = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        return this.this_text_reader.hasNext();
    }

    @Override
    public String next() {

        if(this.par.size() == 0)
            this.par.addAll(Arrays.asList(this.this_text_reader.next().split(" ")));

        return this.par.remove(0);
    }
}
