package br.com.alura.alurator.playground.controle;

import java.io.IOException;
import java.util.List;

public class Controle2 {

	public Controle2() throws IOException {
		throw new IOException();
	}

	public Controle2(String t, Double b) {
	}

	protected Controle2(Integer number, String properties) {
	}

	private Controle2(Controle2 controle) {
	}

	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}
}
