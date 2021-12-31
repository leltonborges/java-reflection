package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.anotacao.NomeTagXML;
import br.com.alura.alurator.playground.modelo.Produto;

public class TestManipulateAnnotation {
    public static void main(String[] args) {
        Object produto = new Produto("Produto 1", 20.0, "Marca 1");
        Class<?> produtoClasse = produto.getClass();

        NomeTagXML annotation = produtoClasse.getDeclaredAnnotation(NomeTagXML.class);

        System.out.println(annotation.name());
    }
}
