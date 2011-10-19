package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Motorista;
import persistencia.PersistenciaMotorista;

public class VisaoMotorista {
	public int cadastraMotorista() throws IOException{
		int menu;
		System.out.println("Digite o nome,CPF e CNH do motorista");
		Motorista motorista = new Motorista(Console.readString(), Console.readString(), Console.readString());
		PersistenciaMotorista arquivoMotorista = new PersistenciaMotorista();
		arquivoMotorista.salvaMotorista(motorista);
		return menu = Locarrao.escolhaMenu();
	}
}
