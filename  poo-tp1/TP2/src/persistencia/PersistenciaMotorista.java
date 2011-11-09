package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Motorista;

public class PersistenciaMotorista {
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/motorista.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	//Construtor Default
	public PersistenciaMotorista() throws IOException {
	}
	
	
	public void salvaMotorista(Motorista motorista) throws IOException {
		bw.append(motorista.getNome() + ";" + motorista.getCpf() + ";" +  motorista.getCnh() + ";" 
				+ motorista.getEndereco() + ";" + motorista.getTelefone()+ "\n");			//Carrega o buff
		bw.flush();																			//escrever o buff no arquivo
		bw.close();																			//fecha o arquivo
	}
	
	public Motorista pesquisarMotorista(String cpf) throws IOException {
		String conateudoLinha = null;
		String s[];	 	
	 	FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
	 	Motorista mot = new Motorista("x", "y", "z");
		while(true) {
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Motorista não encontrado.");
				br.close();
				return null;
			}
			s = conateudoLinha.split("\\;");
			mot = converteOriginal(s);
			if (mot.getCpf().equals(cpf)){
				System.out.println("Encontrado!");
				br.close();
				return mot;
			}
		}
		return null;
	}
	
	
	private Motorista converteOriginal (String s[]) {		
		String s0 = s[0]; // NOME
		String s1 = s[1]; // CPF
		String s2 = s[2]; // CNH
		String s3 = s[3]; // ENDERE�O
		String s4 = s[4]; // TELEFONE
		Motorista mot = new Motorista(s0, s1, s2);
		mot.setEndereco(s3);
		mot.setTelefone(s4);
		return mot;
	}
	
	
	public void deletaMotorista(String cpf) throws IOException {
		String conateudoLinha = null;
		String s[];
		Motorista mot = new Motorista("a", "b", "c");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/motoristaTemp.txt");
		FileWriter fwTemp = new FileWriter(novo,true);
		BufferedWriter bwTemp = new BufferedWriter(fwTemp);
		while(true) {
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
			mot = converteOriginal(s);
			if (mot.getCpf().equals(cpf)){
				System.out.println("Motorista deletado do registro");
			} else {
				bwTemp.append(mot.getNome() + ";" + mot.getCpf() + ";" +  mot.getCnh() + ";" 
						+ mot.getEndereco() + ";" + mot.getTelefone()+ "\n");			
			}
		}
		bwTemp.flush();														//escrever o buff no arquivo
		bwTemp.close();														//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/motorista.txt"));  
	}
}
