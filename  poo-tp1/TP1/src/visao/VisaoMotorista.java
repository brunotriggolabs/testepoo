package visao;

import java.io.IOException;

import modelo.Cliente;
import modelo.Console;
import modelo.Motorista;
import persistencia.PersistenciaCliente;
import persistencia.PersistenciaFuncionario;
import persistencia.PersistenciaMotorista;

public class VisaoMotorista {
	public int cadastraMotorista() throws IOException{
		System.out.println("Digite o nome,CPF e CNH do motorista");
		Motorista motorista = new Motorista(Console.readString(), Console.readString(), Console.readString());
		PersistenciaMotorista arquivoMotorista = new PersistenciaMotorista();
		arquivoMotorista.salvaMotorista(motorista);
		return Locarrao.escolhaMenu();
	}
	
	public int removeMotorista() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do motorista que deseja apagar");
		cpf = Console.readString();
		PersistenciaMotorista pers = new PersistenciaMotorista();
		pers.deletaMotorista(cpf);
		return Locarrao.escolhaMenu();
	}
	
	public int atualizaMotorista() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do motorista que terá seus dados atualizados");
		cpf = Console.readString();
		PersistenciaMotorista pers = new PersistenciaMotorista();
		Motorista motorista = pers.pesquisarMotorista(cpf);
		System.out.println("Digite os novos dados do cliente:");
		System.out.print("Endereço: ");
		motorista.setEndereco(Console.readString());
		System.out.print("Telefone: ");
		motorista.setTelefone(Console.readString());
		pers.deletaMotorista(cpf);
		pers.salvaMotorista(motorista);
		return Locarrao.escolhaMenu();
	}
}
