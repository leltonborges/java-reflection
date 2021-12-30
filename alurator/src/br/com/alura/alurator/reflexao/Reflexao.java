package br.com.alura.alurator.reflexao;

public class Reflexao {

    public ManipuladorClasse refleteClasse(String fullQualifyName){
        try {
            Class<?> nameClass = Class.forName(fullQualifyName);
            return new ManipuladorClasse(nameClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
