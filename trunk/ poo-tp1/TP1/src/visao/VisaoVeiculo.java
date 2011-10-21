package visao;

import java.io.IOException;

import modelo.Console;
import modelo.Veiculo;
import modelo.Vetor;
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
		if (veiculo != null) {
			pers.deletaVeiculo(placa);
			cadastraVeiculo(veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo());
		}
		return 1;
	}
	
	private void cadastraVeiculo(String placa, String marca, String modelo) throws IOException{
		Veiculo veiculo = new Veiculo(placa, marca, modelo);
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		System.out.println("Digite os novos dados do veículo:");
		System.out.print("Cor: ");
		veiculo.setCor(Console.readString());
		System.out.print("Itens opcionais: ");
		veiculo.setOpicionais(Console.readString());
		System.out.print("Observações: ");
		veiculo.setObservacoes(Console.readString());
		System.out.print("Tipo do veículo: ");
		veiculo.setTipo(Console.readString());
		arquivoVeiculo.salvaVeiculo(veiculo);
	}
	
	public int atualizaVeiculo(Veiculo vec) throws IOException {
		String placa = vec.getPlaca();
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
		return 1;
	}
	
	public static int pesquisaDispo() throws IOException{
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		arquivoVeiculo.pesquisarDisponivel();
		return 1;
	}
	
	public static int maisProcurados() throws IOException {
		Veiculo veiculo[];
		PersistenciaVeiculo pers = new PersistenciaVeiculo();
		int quantidade = pers.contaVeiculos();
		veiculo = pers.montaVetorVeiculos(quantidade);
		System.out.println("Veículos mais procurados:" );
		for (int i = 0; (i < veiculo.length) || (i < 5); i++) {
			System.out.println(i + "- " + veiculo[i].getPlaca());
		}
		return 1;
	}
	
	public static int pesquisaCategoriaVeiculo () throws IOException {
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		String categoria = "";
		categoria = Console.readString();
		if(arquivoVeiculo.pesquisaDisponivel(categoria)){
			System.out.println("Veículo da categoria disponível.");
			return 1;
		} else {
			System.out.println("Veiculo da cetegoria não disponível.");
			return 1;
		}
	}

	public static int maisRentaveis() throws IOException {
		PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
		int quantidade = arquivoVeiculo.contaVeiculos();
		Vetor vetor[] = new Vetor[quantidade];
		vetor = arquivoVeiculo.somaPrecos(quantidade);
		System.out.println("Veículos mais rentáveis:" );
		for (int i = 0; i < vetor.length || i < 5; i++) {
			System.out.println(i + "- " + vetor[i].getPlaca());
		} 
		return 1;
	}
}