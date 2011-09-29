package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Funcionario;

public class PersistenciaFuncionario {
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/funcionario.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	//Lê no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);
	
	//Construtor Default
	public PersistenciaFuncionario() throws IOException {
	}
	
	
	public void salvaFuncionario(Funcionario funcionario) throws IOException {
		bw.append(funcionario.getNome() + ";" 
				+ funcionario.getCpf() + ";" +  funcionario.getCargo() + "\n");	//Carrega o buff
		bw.flush();																//escrever o buff no arquivo
		bw.close();																//fecha o arquivo
	}
	
	public boolean pesquisaFuncionario(Funcionario funcionario) {
		//TODO implementar a pesquisa
		return false;
	}
	
	public boolean deletaFuncionario(Funcionario funcionario) {
		//TODO implementar a deleção do Funcionario
		return false;
	}
}
