package modelo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

public class Locacao {
	
	protected double kmSaida = 0;
	protected double kmEntrada = 0;
	protected TipoLocacao tipo = new TipoLocacao();
	protected double valor;
	protected Calendar dataSaida;
	protected Calendar dataDevolucao;
	protected int previsaoDias;
		
	
	public Locacao() {
		
	}
	
	public Locacao(double kmSaida, double kmEntrada) {
		this.kmSaida = kmSaida;
		this.kmEntrada = kmEntrada;
	}
	
	TipoVeiculo tipoVeiculo = new TipoVeiculo();
	
	/*Locacao(Ciente p){
		if (buscaArquivo(Cliente p)) {
=======
	/*Locacao(Cliente p){
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		if (arquivo.pesquisar(p.nome)) {
>>>>>>> .r28
			System.out.println("Cliente já cadastrado.");
		} else {
			System.out.println("Cliente não cadastrado.Por favor faça o cadastro");
		}
	}*/
		

	private boolean buscaArquivo() {
		// TODO Fazer a busca no arquivo,falta aprender como faz.
		return false;
	}
	
	

//=======
	public void escolhaCarro(String marcaCarro) throws IOException{
//>>>>>>> .r28
		String carroAlugado = null;
		
		System.out.println("Qual veículo você deseja alugar?");
		final Console lerTipoVeiculo = null;
		carroAlugado = lerTipoVeiculo.readString();
		//TODO verificar se o carro está cadastrado
		
//<<<<<<< .mine
	}
	
	
	TipoLocacao tipoLocacao = new TipoLocacao();
	public void escolhaTipo(){
//=======
		
//>>>>>>> .r28
		String opcao = "0";
		String tipo;
		final Console lerTipo = null;
		while ((opcao != "1") || (opcao!="2")) {
			System.out.println("Digite 1 para locação por km ou 2 para locação com quilometragem livre ");
			tipo = lerTipo.readString();
			if ((opcao != "1") || (opcao!="2")) {
				System.out.println("Opção inválida!");
			}
		}
	}
	
	
	
	public void dataEntrega(){
		
	}

	
}

