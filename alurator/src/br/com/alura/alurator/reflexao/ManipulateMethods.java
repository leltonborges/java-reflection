package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipulateMethods {
    private Method method;
    private Object[] typeParameters;

    public ManipulateMethods(Method method, Object[] typeParameters) {
        this(method);
        this.typeParameters = typeParameters;
    }

    public ManipulateMethods(Method method) {
        this.method = method;
    }

    public Object InvokeMethod(Object instance){
        try {
            return method.invoke(instance);
        } catch (IllegalAccessException e) {
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            return new RuntimeException("Erro no metodo! "+ e.getTargetException());
        }
    }

    public Object InvokeMethod(Object instance, Object... typeParameters){
        try {
            return method.invoke(instance, typeParameters);
        } catch (IllegalAccessException e) {
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            return new RuntimeException("Erro no metodo! "+ e.getTargetException());
        }
    }
}
