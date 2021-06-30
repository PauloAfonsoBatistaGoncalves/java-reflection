package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<SubControle> subControleClasse1  =  SubControle.class;
		
		Class<?> subControleClasse2
			= Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Class<?> controleClasse1
		= Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Constructor<SubControle> construtorSubControle1 =
				subControleClasse1.getConstructor();
		
		Constructor<SubControle> construtorSubControle2 =
				subControleClasse1.getDeclaredConstructor(String.class);
		
		construtorSubControle2.setAccessible(true);
		
		System.out.println(construtorSubControle1);
		System.out.println(construtorSubControle2);
		
		Object subControle1 = construtorSubControle1.newInstance();
		System.out.println(subControle1);
		
		Object subControle2 = construtorSubControle2.newInstance("");
		System.out.println(subControle2);
		
		
	}

}
