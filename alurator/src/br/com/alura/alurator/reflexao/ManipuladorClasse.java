package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

    private Class<?> nameClass;

    public ManipuladorClasse(Class<?> nameClass) {
        this.nameClass = nameClass;
    }

    public ManipuladorConstrutor getConstrutorPadrao() {
        try {
            Constructor<?> constructor = nameClass.getDeclaredConstructor();
            return new ManipuladorConstrutor(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
