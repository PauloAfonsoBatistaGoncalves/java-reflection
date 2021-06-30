package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<SubControle> subControleClasse1  =  SubControle.class;
		
		Class<?> subControleClasse2
			= Class.forName("br.com.alura.playground.controle.SubControle");
		
		Class<?> controleClasse1
		= Class.forName("br.com.alura.playground.controle.Controle");
	}

}
