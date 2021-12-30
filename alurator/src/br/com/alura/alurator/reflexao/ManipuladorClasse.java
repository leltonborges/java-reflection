package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ManipuladorClasse {

    private Class<?> nameClass;

    public ManipuladorClasse(Class<?> nameClass) {
        this.nameClass = nameClass;
    }

    public ManipuladorObjeto newInstance(){
        Object instance = getConstrutorPadrao().invocar();
        return  new ManipuladorObjeto(instance);
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

    public ManipulateMethods getMethod(String nameMethod){
        try {
            Method method = this.nameClass.getDeclaredMethod(nameMethod);
            return new ManipulateMethods(method);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public ManipulateMethods getMethod(String nameMethod, Object... typeParameters){
        try {
            Method method = this.nameClass.getDeclaredMethod(nameMethod);
            return new ManipulateMethods(method, typeParameters);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
