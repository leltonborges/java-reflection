package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

public class TestInstanciaObjeto {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // url -> /controle/list

        // First form
        Class<Controle> controleClass1 = Controle.class;

        //Secund from
        Controle controle = new Controle();
        Class<? extends Controle> controleClass2 = controle.getClass();

        //Last form
        Class<?> controleClass3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Controle objControle1  = controleClass1.newInstance();
        System.out.println(objControle1 instanceof Controle);

        Object objControle2 = controleClass3.newInstance();
        System.out.println(objControle2 instanceof Controle);
    }
}
