package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ContainerIoC {
    public Object getInstancia(Class<?> tipoClass){
            Stream<Constructor<?>> constructorStream = Stream.of(tipoClass.getConstructors());
            Optional<Constructor<?>> optionalConstructor = constructorStream.filter(c -> c.getParameterCount() == 0)
                    .findFirst();

        try {
            if(optionalConstructor.isPresent()){
                return optionalConstructor.get().newInstance();
            }else {
                Constructor<?> constructor = tipoClass.getDeclaredConstructors()[0];
                List<Object> params = new ArrayList<>();
                for(Parameter parameter: constructor.getParameters()){
                    Class<?> typeParam = parameter.getType();
                    params.add(getInstancia(typeParam));
                }
                return constructor.newInstance(params.toArray());
            }
        }catch (InstantiationException | IllegalAccessException
            | IllegalArgumentException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }
}
