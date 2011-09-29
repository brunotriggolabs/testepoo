package persistencia;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.nio.CharBuffer;

import modelo.Cliente;

public class PersistenciaCliente {
	
	//Declaração do aquivo 	
	File arquivo = new File ("/home/brunomrkta/Dropbox/UFSJ/Estudo_Java/workspace/TrabalhoPratico1/arquivos/cliente.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	//Lê no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);

	//construtor
	public PersistenciaCliente() throws IOException {

	}

	public void salvaCliente(Cliente cliente) throws IOException{
		bw.append(cliente.getNome() + " ; " + cliente.getCpf() + "\n");		//carrega o buff
		bw.flush();															//escrever o buff no arquivo
		bw.close();															//fecha o arquivo
	}

}	
	