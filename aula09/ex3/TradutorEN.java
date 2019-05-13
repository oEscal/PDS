package aula09.ex3;

public class TradutorEN extends Tradutor {

    private static final String language = "EN";

    @Override
    public void traduzir (String word, String l) {

        if (language.equals(l))
            System.out.println("Hello");
        else
            super.traduzir(word, l);
    }
}
