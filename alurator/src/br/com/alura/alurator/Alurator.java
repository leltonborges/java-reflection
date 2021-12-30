package br.com.alura.alurator;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;

    }

    public Object executa(String url) {
        // TODO - processa a requisicao executando o metodo

        String[] parteUrl = url.replaceFirst("/", "")
                .split("/");

        String nomeController = Character.toUpperCase(parteUrl[0].charAt(0))
                + parteUrl[0].substring(1)
                + "Controller";

        try {
            Class<?> classeControle = Class.forName(pacoteBase + nomeController);
            Object instanceController = classeControle.newInstance();

            System.out.println(instanceController);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
