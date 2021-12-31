package br.com.alura.alurator;

import br.com.alura.alurator.conversor.ConvertXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorClasse;
import br.com.alura.alurator.reflexao.ManipuladorObject;
import br.com.alura.alurator.reflexao.Reflexao;

import java.util.Map;

public class Alurator {

    private String pacoteBase;
    private ContainerIoC containerIoC;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.containerIoC = new ContainerIoC();
    }

    public Object executa(String url) {
        Request request = new Request(url);
        String nomeControle = request.getNomeControle();
        String nameMethod = request.getNameMethod();
        Map<String, Object> params = request.getParams();
        String fullQualifiedName = pacoteBase + nomeControle;

        Class<?> classControle = new Reflexao().getClasse(fullQualifiedName);
        Object instanciaControle = containerIoC.getInstancia(classControle);

        ManipuladorClasse manipuladorClasse = new Reflexao()
                .refleteClasse(fullQualifiedName);

        Object instanciaController = new ManipuladorObject(instanciaControle).invocar();

        Object result = manipuladorClasse
                .getMethod(nameMethod, params)
                .InvokeMethod(instanciaController);

        result = ConvertXML.convert(result);

        return result;
    }
}
