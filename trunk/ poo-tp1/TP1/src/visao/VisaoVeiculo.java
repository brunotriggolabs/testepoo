package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Veiculo;
import persistencia.PersistenciaVeiculo;

public class VisaoVeiculo {
	public int cadastraVeiculo() throws IOException{
		int menu;
		System.out.println("Digite placa,marca,modelo");
		Veiculo veiculo = new Veiculo(Console.readString(), Console.readString(), Console.readString());
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		arquivoVeiculo.salvaVeiculo(veiculo);
		return menu = Locarrao.escolhaMenu();
	}
}
