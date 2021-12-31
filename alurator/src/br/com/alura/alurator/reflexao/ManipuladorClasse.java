package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorClasse {

    private Class<?> nameClass;

    public ManipuladorClasse(Class<?> nameClass) {
        this.nameClass = nameClass;
    }

    public ManipuladorObjeto newInstance() {
        Object instance = getConstrutorPadrao().invocar();
        return new ManipuladorObjeto(instance);
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

    public ManipulateMethods getMethod(String nameMethod, Map<String, Object> params) {

        Stream<Method> methods = Stream.of(this.nameClass.getDeclaredMethods());
        Method selectedMethod = methods.filter(m ->
                        m.getName().equals(nameMethod) &&
                                m.getParameterCount() == params.values().size() &&
                                Stream.of(m.getParameters()).allMatch(p -> {
                                            return params.keySet().contains(p.getName()) &&
                                                    params.get(p.getName()).getClass().equals(p.getType());
                                        }
                                )
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Method not found!"));

        return new ManipulateMethods(nameMethod, selectedMethod, params);
    }
}
