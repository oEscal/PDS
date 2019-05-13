package aula09.ex3;

public abstract class Tradutor {

    private Tradutor successor;

    public void traduzir (String word, String language) {
        if (this.successor != null)
            this.successor.traduzir(word, language);
        else
            System.out.println("A linguagem " + language + " ainda não foi adicionada");
    }

    public Tradutor setSuccessor(Tradutor successor) {
        this.successor = successor;
        return this;
    }
}
