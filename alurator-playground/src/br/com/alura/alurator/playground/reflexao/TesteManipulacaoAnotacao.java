package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.anotacao.NomeTagXml;
import br.com.alura.alurator.playground.modelo.Produto;

public class TesteManipulacaoAnotacao {

	public static void main(String[] args) {
		Object produto = new Produto("Produto 1", 20.0, "Marca 1");
		Class<?> classe = produto.getClass();
		
		Object valorAnotacao = classe
		.getDeclaredAnnotation(NomeTagXml.class)
		.value();
		
		System.out.println(valorAnotacao);
	}
}
