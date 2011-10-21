package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Motorista;
import persistencia.PersistenciaMotorista;

public class VisaoMotorista {
	public int cadastraMotorista() throws IOException{
		System.out.println("Digite o nome,CPF e CNH do motorista");
		Motorista motorista = new Motorista(Console.readString(), Console.readString(), Console.readString());
		PersistenciaMotorista arquivoMotorista = new PersistenciaMotorista();
		arquivoMotorista.salvaMotorista(motorista);
		return 1;
	}
	
	public int removeMotorista() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do motorista que deseja apagar");
		cpf = Console.readString();
		PersistenciaMotorista pers = new PersistenciaMotorista();
		pers.deletaMotorista(cpf);
		return 1;
	}
	
	public int atualizaMotorista() throws IOException {
		String cpf;
		System.out.println("Digite o CPF do motorista que terá seus dados atualizados");
		cpf = Console.readString();
		PersistenciaMotorista pers = new PersistenciaMotorista();
		Motorista motorista = pers.pesquisarMotorista(cpf);
		if (motorista != null) {
			pers.deletaMotorista(cpf);
			cadastraMotorista(motorista.getNome(), motorista.getCpf(), motorista.getCnh());
		}
		return 1;
	}
	
	public int cadastraMotorista(String nome, String cpf, String cnh) throws IOException{
		Motorista motorista = new Motorista(nome, cpf, cnh);
		PersistenciaMotorista arquivoMotorista = new PersistenciaMotorista();
		System.out.println("Digite os novos dados do motorista:");
		System.out.print("Endereço: ");
		motorista.setEndereco(Console.readString());
		System.out.print("Telefone: ");
		motorista.setTelefone(Console.readString());
		arquivoMotorista.salvaMotorista(motorista);
		return 1;
	}
}
