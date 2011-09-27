package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.CharBuffer;
import java.util.Calendar;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		Locacao locacao = new Locacao();
		System.out.println("Teste");
		
		arquivo.salvar(locacao);
		
		arquivo.pesquisar(locacao);
	}

}
