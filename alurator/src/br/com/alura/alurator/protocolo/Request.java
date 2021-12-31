package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String nomeControle;
    private String method;
    private Map<String, Object> params = new HashMap<>();

    public Request(String url) {
        String[] parteUrl = url.replaceFirst("/", "")
                .split("[?]");

        String[] controleMetodo = parteUrl[0].split("/");

        this.nomeControle = Character.toUpperCase(controleMetodo[0].charAt(0))
                + controleMetodo[0].substring(1)
                + "Controller";
        method = controleMetodo[1];

        params = parteUrl.length > 1 ?
            new QueryParamsBuilder().withParams(parteUrl[1]).build() : new HashMap<>();
	}

    public String getNomeControle() {
        return this.nomeControle;
    }

    public String getNameMethod() {
        return this.method;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
