package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Funcionario;
import persistencia.PersistenciaFuncionario;

public class VisaoFuncionario {
	public int cadastraFuncionario() throws IOException{
		System.out.println("Digite: nome, cpf, cargo");
		Funcionario funcionario = new Funcionario(Console.readString(), Console.readString(), Console.readString());
		PersistenciaFuncionario arquivoFuncionario = new PersistenciaFuncionario();
		arquivoFuncionario.salvaFuncionario(funcionario);
		return 1;
	}
	
	public int removeFuncionario() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do funcionário que será demitido");
		cpf = Console.readString();
		PersistenciaFuncionario pers = new PersistenciaFuncionario();
		pers.deletaFuncionario(cpf);
		return 1;
	}
	
	public int atualizaFuncionario() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do funcionario que terá seus dados atualizados");
		cpf = Console.readString();
		PersistenciaFuncionario pers = new PersistenciaFuncionario();
		Funcionario funcionario = pers.pesquisarFuncionario(cpf);
		if (funcionario != null) {
			pers.deletaFuncionario(cpf);
			cadastraFuncionario(funcionario.getNome(), funcionario.getCpf(), funcionario.getCargo());
		}
		return 1;
	}
	
	private void cadastraFuncionario(String nome, String cpf, String cargo) throws IOException{
		Funcionario funcionario = new Funcionario(nome, cpf, cargo);
		PersistenciaFuncionario arquivoFuncionario = new PersistenciaFuncionario();
		System.out.println("Digite os novos dados do funcionário:");
		System.out.print("Endereço: ");
		funcionario.setEndereco(Console.readString());
		System.out.print("Telefone: ");
		funcionario.setTelefone(Console.readString());
		arquivoFuncionario.salvaFuncionario(funcionario);
	}
}
