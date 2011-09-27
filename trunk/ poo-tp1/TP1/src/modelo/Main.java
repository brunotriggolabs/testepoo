package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
				
		System.out.println("Teste");
		
		arquivo.pesquisar("PORRAinha");
	}

}
