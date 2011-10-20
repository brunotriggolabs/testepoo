package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Funcionario;
import modelo.Motorista;
import persistencia.PersistenciaFuncionario;
import persistencia.PersistenciaMotorista;
import persistencia.PersistenciaVeiculo;

public class VisaoFuncionario {
	public int cadastraFuncionario() throws IOException{
		int menu;
		System.out.println("Digite: nome, cpf, cargo");
		Funcionario funcionario = new Funcionario(Console.readString(), Console.readString(), Console.readString());
		PersistenciaFuncionario arquivoFuncionario = new PersistenciaFuncionario();
		arquivoFuncionario.salvaFuncionario(funcionario);
		return menu = Locarrao.escolhaMenu();
	}
	
	public int removeFuncionario() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do funcionário que será demitido");
		cpf = Console.readString();
		PersistenciaFuncionario pers = new PersistenciaFuncionario();
		pers.deletaFuncionario(cpf);
		return Locarrao.escolhaMenu();
	}
	
	public int atualizaFuncionario() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do funcionario que terá seus dados atualizados");
		cpf = Console.readString();
		PersistenciaFuncionario pers = new PersistenciaFuncionario();
		Funcionario funcionario = pers.pesquisarFuncionario(cpf);
		System.out.println("Digite os novos dados do cliente:");
		System.out.print("Endereço: ");
		funcionario.setEndereco(Console.readString());
		System.out.print("Telefone: ");
		funcionario.setTelefone(Console.readString());
		pers.deletaFuncionario(cpf);
		pers.salvaFuncionario(funcionario);
		return Locarrao.escolhaMenu();
	}
}
