package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {

    public SubControle() {
    }

    public SubControle(String txt) {
    }

    private SubControle(String txt, Long id) {
    }

    public void methodSubControle1(){
        System.out.println("Executando método subControlle1");
    }

    private String methodSubControle2(){
        System.out.println("Executando método subControlle2");
        return "resutado do return methodSubControle2";
    }

    private void methodSubControleWithParams1(String name){
        System.out.println("Executando método methodSubControleWithParams");
        System.out.println("name: "+ name);
    }

    public String methodSubControleWithParams2(String name, Long id){
        System.out.println("Executando método methodSubControleWithParams");
        System.out.println("name: "+ name);
        System.out.println("ID: "+ id);
        return "name: "+ name + ", id: " + id;
    }

}
