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

	//Lê no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);
	
	//Construtor Default
	public PersistenciaMotorista() throws IOException {
	}
	
	
	
	
	public void salvaMotorista(Motorista motorista) throws IOException {
		bw.append(motorista.getNome() + ";" 
				+ motorista.getCpf() + ";" +  motorista.getCnh() + "\n");		//Carrega o buff
		bw.flush();																//escrever o buff no arquivo
		bw.close();																//fecha o arquivo
	}
	
	public boolean pesquisaMotorista(Motorista motorista) {
		//TODO implementar a pesquisa
		return false;
	}
	
	public boolean deletaMotorista(Motorista motorista) {
		//TODO implementar a deleção do motorista
		return false;
	}
}
