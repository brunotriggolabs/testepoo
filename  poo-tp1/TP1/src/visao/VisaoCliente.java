package visao;

import java.io.IOException;

import modelo.Cliente;
import modelo.Console;
import persistencia.*;

public class VisaoCliente {
	public int cadastraCliente() throws IOException{
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		System.out.println("Digite Nome e em seguida o CPF:");
		Cliente cliente2 = new Cliente(Console.readString(),Console.readString());
		arquivoCliente.salvaCliente(cliente2);
		return Locarrao.escolhaMenu();
	}
	
	public int removeCliente() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do cliente que será removido");
		cpf = Console.readString();
		PersistenciaCliente pers = new PersistenciaCliente();
		pers.deletaCliente(cpf);
		return Locarrao.escolhaMenu();
	}
	
	public int atualizaCliente() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do cliente que terá seus dados atualizados");
		cpf = Console.readString();
		PersistenciaCliente pers = new PersistenciaCliente();
		Cliente cli = pers.pesquisarCliente(cpf);
		System.out.println("Digite os novos dados do cliente:");
		System.out.print("Endereço: ");
		cli.setEndereco(Console.readString());
		System.out.print("Telefone: ");
		cli.setTelefone(Console.readString());
		pers.deletaCliente(cpf);
		pers.salvaCliente(cli);
		return Locarrao.escolhaMenu();
	}
	
	public static int pesquisaCliente() throws IOException {
		String buscaCpf;
		Cliente cliente = new Cliente("", "");
		System.out.println("Digite o CPF do cliente à ser buscado:");
		buscaCpf = Console.readString();
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		cliente = arquivoCliente.pesquisarCliente(buscaCpf);
		if (cliente != null){
			System.out.println("Cliente localizado!");
			return Locarrao.escolhaMenu();
		}else {
			System.out.println("Cliente não encontrado!");
			return Locarrao.escolhaMenu();
		}
	}
}
