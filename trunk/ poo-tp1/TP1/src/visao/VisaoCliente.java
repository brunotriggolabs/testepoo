package visao;

import java.io.IOException;

import modelo.Cliente;
import modelo.Console;
import persistencia.*;

public class VisaoCliente {
	public int cadastraCliente() throws IOException{
		int menu;
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		System.out.println("Digite Nome e em seguida o CPF:");
		Cliente cliente2 = new Cliente(Console.readString(),Console.readString());
		arquivoCliente.salvaCliente(cliente2);
		return menu = Locarrao.escolhaMenu();
	}
}
