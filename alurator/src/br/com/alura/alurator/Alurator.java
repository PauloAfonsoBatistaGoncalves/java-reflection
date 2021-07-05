package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.refelxao.ManipuladorObjeto;
import br.com.alura.alurator.refelxao.Reflexao;

public class Alurator {

	private String pacoteBase;
	private ContainerIoC container;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
		this.container = new ContainerIoC();
	}

	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao

		Request request = new Request(url);

		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		Class<?> classeControle =
				new Reflexao()
				.getClasse(pacoteBase + nomeControle);
		
		Object instanciaControle = container.getInstancia(classeControle);
	
		Object retorno = new ManipuladorObjeto(instanciaControle)
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

	public void registra(Class<?> tipoFonte, Class<?> tipoDestino) {
		container.registra(tipoFonte, tipoDestino);
	}
}
