package br.com.alura.alurator.reflexao;

public class Reflexao {

    public ManipuladorClasse refleteClasse(String fullQualifiedName){
        try {
            Class<?> nameClass = Class.forName(fullQualifiedName);
            return new ManipuladorClasse(nameClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
