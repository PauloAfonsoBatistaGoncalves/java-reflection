package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.refelxao.Reflexao;

public class Alurator {
	
	private String pacoteBase;
	
	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		
		Request request = new Request(url);
		
		String nomeControle = request.getNomeControle();
		
			Object instanciaControle = new Reflexao()
			.refleteClasse(pacoteBase + nomeControle)
			.getConstrutorPadrao()
			.invoca();
			
			
			System.out.println(instanciaControle);
			
			return null;
	}
}
