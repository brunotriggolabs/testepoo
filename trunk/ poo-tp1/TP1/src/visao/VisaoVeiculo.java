package visao;

import java.io.IOException;

import modelo.Cliente;
import modelo.Console;
import modelo.Veiculo;
import persistencia.PersistenciaCliente;
import persistencia.PersistenciaVeiculo;

public class VisaoVeiculo {
	public int cadastraVeiculo() throws IOException{
		System.out.println("Digite placa,marca,modelo");
		Veiculo veiculo = new Veiculo(Console.readString(), Console.readString(), Console.readString());
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		arquivoVeiculo.salvaVeiculo(veiculo);
		return Locarrao.escolhaMenu();
	}
	
	public int removeVeiculo() throws IOException {
		String placa;
		System.out.println("Digite a placa do veículo que deseja remover");
		placa = Console.readString();
		PersistenciaVeiculo pers = new PersistenciaVeiculo();
		pers.deletaVeiculo(placa);
		return Locarrao.escolhaMenu();
	}
	
	public int atualizaVeiculo() throws IOException {
		String placa;
		System.out.println("Digite a placa do veículo que terá seus dados atualizados");
		placa = Console.readString();
		PersistenciaVeiculo pers = new PersistenciaVeiculo();
		Veiculo veiculo = pers.pesquisarVeiculo(placa);
		System.out.println("Digite os novos dados do veículo:");
		System.out.print("Cor: ");
		veiculo.setCor(Console.readString());
		System.out.print("Itens opcionais: ");
		veiculo.setOpicionais(Console.readString());
		System.out.print("Observações: ");
		veiculo.setObservacoes(Console.readString());
		pers.deletaVeiculo(placa);
		pers.salvaVeiculo(veiculo);
		return Locarrao.escolhaMenu();
	}
	
	public static int pesquisaDispo() throws IOException{
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		arquivoVeiculo.pesquisarDisponivel().toString();
		return Locarrao.escolhaMenu();
	}
}
