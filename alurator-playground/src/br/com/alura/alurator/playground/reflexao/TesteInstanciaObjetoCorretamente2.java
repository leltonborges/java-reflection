package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<SubControle> subControleClass1 = SubControle.class;

        Class<?> subControleClass2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle2");

        Class<?> controlerClass1 = Class.forName("br.com.alura.alurator.playground.controle.Controle2");

        try {
            controlerClass1.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(e.getTargetException());
        }
        //Não captura as exceções
        controlerClass1.newInstance();
    }
}
