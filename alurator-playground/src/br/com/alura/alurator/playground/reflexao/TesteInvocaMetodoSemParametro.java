package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> subControleClasse
			= Class.forName("br.com.alura.alurator.playground.controle.SubControle");
	
		Constructor<?> construtorSubControle =
				subControleClasse.getDeclaredConstructor(String.class);
		
		construtorSubControle.setAccessible(true);
		
		Object subControle = construtorSubControle.newInstance("");
		
		for(Method m : subControleClasse.getMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		for(Method m : subControleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		Method m = subControleClasse.getDeclaredMethod("metodoSubControle2");
		m.setAccessible(true);
		Object retorno = m.invoke(subControle);
		
		System.out.println(retorno);
	}

}
