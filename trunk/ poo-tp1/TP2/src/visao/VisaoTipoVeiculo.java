package visao;

import java.io.IOException;

import modelo.TipoVeiculo;
import modelo.Console;
import persistencia.PersistenciaTipoVeiculo;

public class VisaoTipoVeiculo {
	public int cadastraTipoVeiculo() throws IOException{
		PersistenciaTipoVeiculo arquivoVeiculo = new PersistenciaTipoVeiculo();
		System.out.println("Digite o tipo, o preço por KM rodado e a taxa base da locação:");
		TipoVeiculo tipo = new TipoVeiculo(Console.readString(), Console.readDouble(), Console.readDouble());
		arquivoVeiculo.salvaTipoVeiculo(tipo);
		return Locarrao.escolhaMenu();
	}
	
	public int removeTipoVeiculo() throws IOException {
		String tipo;
		System.out.println("Qual o tipo de locação que deseja remover?");
		tipo = Console.readString();
		PersistenciaTipoVeiculo pers = new PersistenciaTipoVeiculo();
		pers.deletaTipoVeiculo(tipo);
		return Locarrao.escolhaMenu();
	}
}
