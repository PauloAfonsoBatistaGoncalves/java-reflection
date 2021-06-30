package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<Controle> controleClasse1 = Controle.class;
		
		Controle controle = new Controle();
		Class<? extends Controle> controleClasse2 = controle.getClass();

		Class<?> controleClasse3 =  Class.forName("br.com.alura.alurator.playground.controle.Controle");
	
		Controle objetoControle1 = controleClasse1.newInstance();
		Object objetoControle2 = controleClasse3.newInstance();
		
		System.out.println(objetoControle1 instanceof Controle);
		System.out.println(objetoControle2 instanceof Controle);
	}

}
