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
		return 1;
	}
	
	public int removeCliente() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do cliente que será removido");
		cpf = Console.readString();
		PersistenciaCliente pers = new PersistenciaCliente();
		pers.deletaCliente(cpf);
		return 1;
	}
	
	public int atualizaCliente() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do cliente que terá seus dados atualizados");
		cpf = Console.readString();
		PersistenciaCliente pers = new PersistenciaCliente();
		Cliente cli;
		cli = pers.pesquisarCliente(cpf);
		if (cli == null) {
			return 1;
		}
		pers.deletaCliente(cli.getCpf());
		cadastraCliente(cli.getNome(), cli.getCpf());
		return 1;
	}
	
	public static int pesquisaCliente() throws IOException {
		String buscaCpf;
		Cliente cliente = new Cliente("", "");
		System.out.println("Digite o CPF do cliente à ser buscado:");
		buscaCpf = Console.readString();
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		cliente = arquivoCliente.pesquisarCliente(buscaCpf);
		if (cliente != null){
			cliente.imprime();
		}else {
			System.out.println("Cliente não encontrado!");
		}
		return 1;
	}
	
	private void cadastraCliente(String nome, String cpf) throws IOException {
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		Cliente cliente2 = new Cliente(nome,cpf);
		System.out.println("Digite os novos dados do cliente:");
		System.out.print("Endereço: ");
		cliente2.setEndereco(Console.readString());
		System.out.print("Telefone: ");
		cliente2.setTelefone(Console.readString());
		arquivoCliente.salvaCliente(cliente2);
	}
}
