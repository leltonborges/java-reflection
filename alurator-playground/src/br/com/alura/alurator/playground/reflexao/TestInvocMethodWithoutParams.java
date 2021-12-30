package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestInvocMethodWithoutParams {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> subControleClass = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
        Constructor<?> constructor = subControleClass.getConstructor();
        constructor.setAccessible(true);
        Object instanceSubControle = constructor.newInstance();
        constructor.setAccessible(false);

        Arrays.stream(subControleClass.getMethods()).forEach(System.out::println);
        System.out.println("\n======================================\n");
        Arrays.stream(subControleClass.getDeclaredMethods()).forEach(System.out::println);

        // access methdos protecteds
        Method methodProtected = subControleClass.getDeclaredMethod("methodSubControle2");
        methodProtected.setAccessible(true);
        Object returnMethod = methodProtected.invoke(instanceSubControle);
        System.out.println(returnMethod);

        System.out.println("\n");
        // Access methods publics
        Method methodPublic = subControleClass.getDeclaredMethod("methodSubControle1");
        System.out.println(methodPublic.invoke(instanceSubControle));
    }
}
