package br.com.alura.alurator;

public class Alurator {
	
	private String pacoteBase;
	
	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		
		String[] partesUrl = url.replaceFirst("/", "")//remove a primeria /
			.split("/"); //quebra a url em partes baseada pela /
		
		String nomeControle = 
				Character.toUpperCase(partesUrl[0].charAt(0)) + 
				partesUrl[0].substring(1) +
				"Controller";
		try {
			Class<?> classeControle = Class.forName(pacoteBase + nomeControle);
			Object instanciaControle = classeControle.newInstance();
			System.out.println(instanciaControle);
			
			return null;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
