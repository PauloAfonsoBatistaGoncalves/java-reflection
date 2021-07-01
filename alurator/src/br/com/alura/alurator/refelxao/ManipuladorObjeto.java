package br.com.alura.alurator.refelxao;

import java.lang.reflect.Method;

public class ManipuladorObjeto {

	private Object instancia;

	public ManipuladorObjeto(Object instancia) {
		this.instancia = instancia;
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo) {
		Method metodo;
		try {
			metodo = instancia
					.getClass().getDeclaredMethod(nomeMetodo);
			
			return new ManipuladorMetodo(metodo, instancia);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}


}
