package br.com.alura.alurator.reflexao;

public class ManipuladorObjeto {
    private Object instance;

    public ManipuladorObjeto(Object instance) {
        this.instance = instance;
    }

    public Object getInstance(){return this.instance;}
}
