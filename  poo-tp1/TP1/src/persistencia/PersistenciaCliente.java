package persistencia;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.nio.CharBuffer;

import modelo.Cliente;
import modelo.Motorista;

public class PersistenciaCliente {
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/cliente.txt");

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
		bw.append(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getEndereco() + ";"
									+ cliente.getTelefone());		//carrega o buff
		cliente.addLocacao(1);
		cliente.addLocacao(5);
		cliente.addLocacao(3);
		Object[] vetor = cliente.tamanhoVetor();
		int tamanho = vetor.length;
		int i = 0;
		while (i < tamanho) {
			bw.write(";" + vetor[i]);
			i++;
		}
		bw.write("\n");
		bw.flush();															//escrever o buff no arquivo
		bw.close();															//fecha o arquivo
	}
	
	public Cliente pesquisarCliente(String cpf) {
		String conateudoLinha = null;
		int linhaAtual = 0;
	 	String s[];
		Cliente cli = new Cliente("x", "y");
		while(true) {
			linhaAtual++;
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				e.printStackTrace();
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Linha vazia!");
				break;
			}
			s = conateudoLinha.split("\\;");
			cli = converteOriginal(s);
			if (cli.getCpf().equals(cpf)){
				System.out.println("Encontrado!");
				return cli;
			}else {
				System.out.println("N�o encontrado!");
				return null;
			}
		}
		return null;
	}
	
	private Cliente converteOriginal (String s[]) {		
		String s0 = s[0]; // NOME
		String s1 = s[1]; // CPF
		String s2 = s[2]; // ENDERECO
		String s3 = s[3]; // TELEFONE
		Cliente cli = new Cliente (s0, s1);
		cli.setEndereco(s2);
		cli.setTelefone(s3);
		int tamanho = s.length - 4;
		int i = 0;
		while (i < tamanho) {
			cli.addLocacao(Integer.parseInt(s[i+4]));
			i++;
		}
		return cli;
	}

}	
	