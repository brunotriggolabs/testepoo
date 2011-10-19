package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Funcionario;
import persistencia.PersistenciaFuncionario;

public class VisaoFuncionario {
	public int cadastraFuncionario() throws IOException{
		int menu;
		System.out.println("Digite: nome, cpf, cargo");
		Funcionario funcionario = new Funcionario(Console.readString(), Console.readString(), Console.readString());
		PersistenciaFuncionario arquivoFuncionario = new PersistenciaFuncionario();
		arquivoFuncionario.salvaFuncionario(funcionario);
		return menu = Locarrao.escolhaMenu();
	}
}
