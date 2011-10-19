package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Funcionario;
import modelo.Veiculo;

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
	
	public Funcionario pesquisarFuncionario(Funcionario funcionario) {
		String conateudoLinha = null;
		int linhaAtual = 0;
	 	String s[];
		Funcionario fun = new Funcionario("x", "y", "z");
		while(true){
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
			fun = converteOriginal(s);
			if (fun.equals(funcionario)){
				System.out.println("Encontrado!");
				return fun;
			}else {
				System.out.println("Não encontrado!");
				return null;
			}
		}
		return null;
	}
	
	private Funcionario converteOriginal (String s[]) {		
		Funcionario fun = new Funcionario(s[0], s[1], s[2]);
		return fun;
	}
	
	
	public boolean deletaFuncionario(Funcionario funcionario) {
		//TODO implementar a deleção do Funcionario
		return false;
	}
}
