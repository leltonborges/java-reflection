package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ManipulateMethods {
    private String nameMethod;
    private Method method;
    private Map<String, Object> params;

    public ManipulateMethods(String nameMethod, Method method, Map<String, Object> params) {
        this.nameMethod = nameMethod;
        this.method = method;
        this.params = params;
    }

    public Object InvokeMethod(Object instance){
        try {
            List<Object> parameters = new ArrayList<>();
            Stream.of(method.getParameters())
                    .forEach(p ->
                        parameters.add(params.get(p.getName()))
                    );
            return method.invoke(instance, parameters.toArray());
        } catch (IllegalAccessException e) {
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            return new RuntimeException("Erro no metodo! "+ e.getTargetException());
        }
    }

}
