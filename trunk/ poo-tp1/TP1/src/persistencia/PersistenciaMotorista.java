package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Funcionario;
import modelo.Motorista;
import modelo.Veiculo;

public class PersistenciaMotorista {
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/motorista.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	//Lê no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);
	
	//Construtor Default
	public PersistenciaMotorista() throws IOException {
	}
	
	
	public void salvaMotorista(Motorista motorista) throws IOException {
		bw.append(motorista.getNome() + ";" + motorista.getCpf() + ";" +  motorista.getCnh() + ";" 
				+ motorista.getEndereco() + ";" + motorista.getTelefone()+ "\n");			//Carrega o buff
		bw.flush();																			//escrever o buff no arquivo
		bw.close();																			//fecha o arquivo
	}
	
	public Motorista pesquisarMotorista(String cpf) {
		String conateudoLinha = null;
		int linhaAtual = 0;
	 	String s[];
		Motorista mot = new Motorista("x", "y", "z");
		while(true) {
			linhaAtual++;
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Linha vazia!");
				break;
			}
			s = conateudoLinha.split("\\;");
			mot = converteOriginal(s);
			if (mot.getCpf().equals(cpf)){
				System.out.println("Encontrado!");
				return mot;
			}else {
				System.out.println("N�o encontrado!");
				return null;
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
	
	
	public boolean deletaMotorista(Motorista motorista) {
		//TODO implementar a deleção do motorista
		return false;
	}
}
