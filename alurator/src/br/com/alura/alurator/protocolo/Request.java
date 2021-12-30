package br.com.alura.alurator.protocolo;

public class Request {
	private String nomeControle;
	private String method;

	public Request(String url) {
		String[] parteUrl = url.replaceFirst("/", "")
				.split("/");

		this.nomeControle = Character.toUpperCase(parteUrl[0].charAt(0))
				+ parteUrl[0].substring(1)
				+ "Controller";
		method = parteUrl[1];
	}

	public String getNomeControle(){
		return this.nomeControle;
	}

	public String getNameMethod(){return this.method;}
}
