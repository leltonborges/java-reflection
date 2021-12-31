package br.com.alura.alurator.reflexao;

public class Reflexao {

    public ManipuladorClasse refleteClasse(String fullQualifiedName) {
        Class<?> nameClass = getClasse(fullQualifiedName);
        return new ManipuladorClasse(nameClass);
    }

    public Class<?> getClasse(String fullQualifiedName) {
        try {
            Class<?> nameClass = Class.forName(fullQualifiedName);
            return nameClass;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
