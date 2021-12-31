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

    public <T, K extends T> void registrar(Class<T> typeFont, Class<K> typeDistino) {
//        boolean compativel = verificaCompatibilidade(typeFont, typeDistino);
//        if(!compativel) throw new ClassCastException("Não é possivel resolver: "+ typeFont.getName() + " para: " + typeDistino.getName());
        mapTypes.put(typeFont, typeDistino);
    }

//    private boolean verificaCompatibilidade(Class<?> typeFont, Class<?> typeDistino) {
        /// Modelo antigo
//        boolean compativel;
//
//        if(typeFont.isInterface()){
//            compativel = Arrays.stream(typeDistino.getInterfaces()).anyMatch(p -> p.equals(typeFont));
//        }else {
//            compativel = typeDistino.getSuperclass().equals(typeFont)
//                        || typeDistino.equals(typeFont);
//        }
//        return compativel;

        //Usando API Reflection
//        return typeFont.isAssignableFrom(typeDistino);
//    }
}
