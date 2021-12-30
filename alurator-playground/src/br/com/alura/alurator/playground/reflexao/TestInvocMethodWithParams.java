package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestInvocMethodWithParams {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> subControleClass = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
        Constructor<?> constructor = subControleClass.getConstructor();
        constructor.setAccessible(true);
        Object instanceSubControle = constructor.newInstance();
        constructor.setAccessible(false);
        ;

        Method methodProtected = subControleClass
                .getDeclaredMethod("methodSubControleWithParams1", String.class);
        methodProtected.setAccessible(true);
        Object returnMethod = methodProtected
                .invoke(instanceSubControle, "Hello world!!");
        System.out.println(returnMethod);

        System.out.println("");
        Method methodPublic = subControleClass.getDeclaredMethod("methodSubControleWithParams2", String.class, Long.class);
        System.out.println(methodPublic.invoke(instanceSubControle, "Rice", 3l));
    }
}