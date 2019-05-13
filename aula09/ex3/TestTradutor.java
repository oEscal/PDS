package aula09.ex3;

public class TestTradutor {

    public static void main(String args[]) {

        Tradutor tr = new TradutorES().setSuccessor(new TradutorEN());

        tr.traduzir("Olá", "ES");
        tr.traduzir("Olá", "FR");
    }
}
