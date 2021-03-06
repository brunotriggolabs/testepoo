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

	//Construtor Default
	public PersistenciaFuncionario() throws IOException {
	}
	
	
	public void salvaFuncionario(Funcionario funcionario) throws IOException {
		bw.append(funcionario.getNome() + ";" + funcionario.getCpf() + ";" +  funcionario.getCargo() + ";" + 
				funcionario.getEndereco() + ";" + funcionario.getTelefone()+ "\n");	//Carrega o buff
		bw.flush();																	//escrever o buff no arquivo
		bw.close();																	//fecha o arquivo
	}
	
	public Funcionario pesquisarFuncionario(String cpf) throws IOException {
		String conateudoLinha = null;
		String s[];
	 	
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
	 	Funcionario fun = new Funcionario("x", "y", "z");
		while(true) {
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Registro não encontrado.");
				br.close();
				return null;
			}
			s = conateudoLinha.split("\\;");
			fun = converteOriginal(s);
			if (fun.getCpf().equals(cpf)){
				System.out.println("Encontrado!");
				br.close();
				return fun;
			}
		}
		return null;
	}
	
	private Funcionario converteOriginal (String s[]) {		
		String s1 = s[0];
		String s2 = s[1];
		String s3 = s[2];
		String s4 = s[3];
		String s5 = s[4];
		Funcionario fun = new Funcionario(s1, s2, s3);
		fun.setEndereco(s4);
		fun.setTelefone(s5);
		return fun;
	}
	
	
	public void deletaFuncionario(String cpf) throws IOException {
		String conateudoLinha = null;
		String s[];
		Funcionario fun = new Funcionario("x", "y", "z");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/funcionarioTemp.txt");
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
			fun = converteOriginal(s);
			if (fun.getCpf().equals(cpf)){
				System.out.println("Funcionário deletado do registro");
			} else {
				bwTemp.write(fun.getNome() + ";" + fun.getCpf() + ";" +  fun.getCargo() + ";" + 
						fun.getEndereco() + ";" + fun.getTelefone()+ "\n");			//Carrega o buff
			}
		}
		bwTemp.flush();														//escrever o buff no arquivo
		bwTemp.close();														//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/funcionario.txt"));  
	}
}
