package br.com.alura.alurator.reflexao;

public class ManipuladorObject {

    private Object object;

    public ManipuladorObject(Object object) {
        this.object = object;
    }

    public Object invocar() {
            return object;
    }
}
