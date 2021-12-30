package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

import java.lang.reflect.InvocationTargetException;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        String nomeControle = new Request(url).getNomeControle();

        Object instanciaController = new Reflexao()
                .refleteClasse(pacoteBase + nomeControle)
                .getConstrutorPadrao()
                .invocar();

        System.out.println(instanciaController);
        return null;
    }
}
