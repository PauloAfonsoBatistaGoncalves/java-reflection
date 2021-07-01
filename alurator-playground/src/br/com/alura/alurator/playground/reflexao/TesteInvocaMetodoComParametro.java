package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> controleClasse
		= Class.forName("br.com.alura.alurator.playground.controle.Controle");

		Constructor<?> construtorPadrao =
				controleClasse.getDeclaredConstructor();
		
		Object controle = construtorPadrao.newInstance();
		
		Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class, Integer.class);
	
		Object retorno = m.invoke(controle, "Pintassilgo do Agreste",2);
		
		System.out.println(retorno);
	}
	
}
