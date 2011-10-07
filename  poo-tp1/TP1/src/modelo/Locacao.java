package modelo;

import java.util.Calendar;

public class Locacao {

	private double kmSaida = 0;
	private double kmEntrada = 0;
	private TipoLocacao tipo = new TipoLocacao();
	private double valor;
	private Calendar dataSaida;
	private Calendar dataDevolucao;
	private int previsaoDias = 255;		

	public Locacao() {

	}
	
	public Locacao(double kmSaida, double kmEntrada,TipoLocacao tipo,double valor,Calendar dataSaida,Calendar dataDevolucao,int previsaoDias) {
		this.kmSaida = kmSaida;
		this.kmEntrada = kmEntrada;
		this.tipo = tipo;
		this.valor =  valor;
		this.dataSaida = dataSaida;
		this.dataDevolucao = dataDevolucao;
		this.previsaoDias = previsaoDias;
	}

	public double getKmSaida() {
		return kmSaida;
	}

	public double getKmEntrada() {
		return kmEntrada;
	}

	public TipoLocacao getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public int getPrevisaoDias() {
		return previsaoDias;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public TipoLocacao getTipoLocacao() {
		return tipo;
	}

	TipoVeiculo tipoVeiculo = new TipoVeiculo();

	/*Locacao(Ciente p){
		if (buscaArquivo(Cliente p)) {

	/*Locacao(Cliente p){
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		if (arquivo.pesquisar(p.nome)) {

			System.out.println("Cliente já cadastrado.");
		} else {
			System.out.println("Cliente não cadastrado.Por favor faça o cadastro");
		}
	}


	private boolean buscaArquivo() {
		// TODO Fazer a busca no arquivo,falta aprender como faz.
		return false;
	}

	public void escolhaCarro(String marcaCarro) throws IOException{
		String carroAlugado = null;

		System.out.println("Qual veículo você deseja alugar?");
		final Console lerTipoVeiculo = null;
		carroAlugado = lerTipoVeiculo.readString();
		//TODO verificar se o carro está cadastrado
	}


	TipoLocacao tipoLocacao = new TipoLocacao();
	public void escolhaTipo(){

		String opcao = "0";
		String tipo = "";
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

	}*/	
}