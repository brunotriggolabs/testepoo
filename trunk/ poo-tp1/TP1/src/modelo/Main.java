package modelo;

import java.io.IOException;

import persistencia.PersistenciaLocacao;
import persistencia.PersistenciaCliente;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		Locacao locacao = new Locacao();
		System.out.println("Teste");
		
		//arquivo.salvar(locacao);
		
		//arquivo.pesquisar(locacao);
		
		Cliente cli = new Cliente("iago", "10970173628");
		
		PersistenciaCliente per = new PersistenciaCliente();
		per.salvaCliente(cli);
		
		System.out.println("Fim do programa");
	}

}
