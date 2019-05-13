package aula09.ex3;

public class TradutorES extends Tradutor{

    private static final String language = "ES";

    @Override
    public void traduzir (String word, String l) {

        if (language.equals(l))
            System.out.println("Hola");
        else
            super.traduzir(word, l);
    }
}
