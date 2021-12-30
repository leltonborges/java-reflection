package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorClasse;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        Request request = new Request(url);
        String nomeControle = request.getNomeControle();
        String nameMethod = request.getNameMethod();

        ManipuladorClasse manipuladorClasse = new Reflexao()
                .refleteClasse(pacoteBase + nomeControle);

        Object instanciaController = manipuladorClasse.getConstrutorPadrao().invocar();

        Object result = manipuladorClasse
                .getMethod(nameMethod)
                .InvokeMethod(manipuladorClasse.newInstance().getInstance());
        return result;

    }
}
