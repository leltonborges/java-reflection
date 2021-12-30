package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<SubControle> subControleClass1 = SubControle.class;

        Class<?> subControleClass2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controlerClass1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        System.out.println("SubControle");
        Constructor<SubControle> constructorSubControleDefault = subControleClass1.getConstructor();
        System.out.println(constructorSubControleDefault);
        SubControle instanceSubControle = constructorSubControleDefault.newInstance();
        System.out.println(instanceSubControle);

        //For default get the standard construct public of instance
        Constructor<SubControle> constructorSubControleWithVarArgs1 =
                subControleClass1.getConstructor(String.class);
        System.out.println(constructorSubControleWithVarArgs1);

        //Contructor Private/Protected/Default
        Constructor<SubControle> constructorSubControleWithVarArgs2 =
                subControleClass1.getDeclaredConstructor(String.class, Long.class);
        System.out.println(constructorSubControleWithVarArgs2);

        // Manipulatiog construct protected
        constructorSubControleWithVarArgs2.setAccessible(true);
        SubControle instanceConstructorProtected = constructorSubControleWithVarArgs2.newInstance("txt", 1l);
        System.out.println("protected: " + instanceConstructorProtected);
        constructorSubControleWithVarArgs2.setAccessible(false);

    }
}
