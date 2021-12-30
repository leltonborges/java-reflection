package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {

    private Constructor<?> constructor;

    public ManipuladorConstrutor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Object invocar() {
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            return new RuntimeException("Erro no construtor! "+ e.getTargetException());
        }
    }
}
