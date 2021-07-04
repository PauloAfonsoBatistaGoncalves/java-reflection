package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import br.com.alura.alurator.conversor.ConversorXML;
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
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		Object retorno = new Reflexao()
				.refleteClasse(pacoteBase + nomeControle)
				.criaInstancia()
				.getMetodo(nomeMetodo, params)
				.comTratamentoDeExcecao((metodo, ex) ->{
					System.out.println("Erro no m�todo" + metodo.getName() + " da classe " + metodo.getDeclaringClass().getName() + ".\n\n");
					
					throw new RuntimeException("Erro no m�todo");
				})
				.invoca();
		
		System.out.println(retorno);

		retorno = new ConversorXML().converte(retorno);
		
		return retorno;
	}
}
