package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.modelo.Produto;

import java.lang.reflect.Field;
import java.util.Arrays;

public class TestManipulateAttributes {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        Object produto = new Produto("Produto 1", 20.0, "Marca 1");
        Class<?> produtoClasse = produto.getClass();

        System.out.println(produtoClasse.getField("id"));

        for (Field f : produtoClasse.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + ": " + f.get(produto));
            f.setAccessible(false);
        }
    }
}
