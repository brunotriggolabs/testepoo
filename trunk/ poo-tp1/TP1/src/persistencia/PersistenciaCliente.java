package persistencia;

import java.io.*;

import modelo.Cliente;


public class PersistenciaCliente {
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/cliente.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	public PersistenciaCliente() throws IOException {

	}

	public void salvaCliente(Cliente cliente) throws IOException{
		bw.append(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getEndereco() + ";"
									+ cliente.getTelefone());		//carrega o buff
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
	
	public Cliente pesquisarCliente(String cpf) throws IOException {
		String conateudoLinha = null;
		int linhaAtual = 0;
	 	String s[];
	 	FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
	 	Cliente cli = new Cliente("a", "b");
		while(true) {
			linhaAtual++;
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Cliente não encontrado!");
				br.close();
				return null;
			}
			s = conateudoLinha.split("\\;");
			cli = converteOriginal(s);
			if (cli.getCpf().equals(cpf)){
				System.out.println("Encontrado!");
				br.close();
				return cli;
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
	
	public void deletaCliente(String cpf) throws IOException {
		String conateudoLinha = null;
		int linhaAtual = 0;
	 	String s[];
		Cliente cli = new Cliente("a", "1");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/clienteTemp.txt");
		FileWriter fwTemp = new FileWriter(novo,true);
		BufferedWriter bwTemp = new BufferedWriter(fwTemp);
		while(true) {
			linhaAtual++;
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				break;
			}
			s = conateudoLinha.split("\\;");
			cli = converteOriginal(s);
			if (cli.getCpf().equals(cpf)){
				System.out.println("Funcionário deletado do registro");
			} else {
				bwTemp.append(cli.getNome() + ";" + cli.getCpf() + ";" + cli.getEndereco() + ";"
						+ cli.getTelefone());		//carrega o buff
				Object[] vetor = cli.tamanhoVetor();
				int tamanho = vetor.length;
				int i = 0;
				while (i < tamanho) {
					bw.write(";" + vetor[i]);
					i++;
				}
				bwTemp.write("\n");
			}
		}
		bwTemp.flush();														//escrever o buff no arquivo
		bwTemp.close();														//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/cliente.txt"));  
	}

}	
	