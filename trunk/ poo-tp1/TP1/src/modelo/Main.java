package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.CharBuffer;
import java.util.Calendar;
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
