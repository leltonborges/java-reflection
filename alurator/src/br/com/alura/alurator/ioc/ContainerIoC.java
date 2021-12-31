package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

public class ContainerIoC {
    private Map<Class<?>, Class<?>> mapTypes = new HashMap<>();

    public Object getInstancia(Class<?> tipoClass) {
        Class<?> typeDistino = mapTypes.get(tipoClass);

        if(typeDistino != null){
            return getInstancia(typeDistino);
        }

        Stream<Constructor<?>> constructorStream = Stream.of(tipoClass.getConstructors());
        Optional<Constructor<?>> optionalConstructor = constructorStream.filter(c -> c.getParameterCount() == 0)
                .findFirst();

        try {
            if (optionalConstructor.isPresent()) {
                return optionalConstructor.get().newInstance();
            } else {
                Constructor<?> constructor = tipoClass.getDeclaredConstructors()[0];
                List<Object> params = new ArrayList<>();
                for (Parameter parameter : constructor.getParameters()) {
                    Class<?> typeParam = parameter.getType();
                    params.add(getInstancia(typeParam));
                }
                return constructor.newInstance(params.toArray());
            }
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void registrar(Class<?> typeFont, Class<?> typeDistino) {
        mapTypes.put(typeFont, typeDistino);
    }
}
