package br.com.alura.alurator.refelxao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMetodo {

	private Method metodo;
	private Object instancia;
	
	public ManipuladorMetodo(Method metodo, Object instancia) {
		this.metodo = metodo;
		this.instancia = instancia;
	}

	public Object invoca() {
		try {
			return this.metodo.invoke(instancia);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}catch(InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro dentro do método", e);
		}
	}

}
