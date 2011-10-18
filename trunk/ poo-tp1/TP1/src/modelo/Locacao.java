package modelo;

import java.util.Date;
import java.util.Date;

public class Locacao {

	private double kmEntrada = 0;
	private TipoLocacao tipo = new TipoLocacao();
	private double valor;
	private Date dataSaida;
	private Date dataDevolucao;
	private int previsaoDias = 0;

	public Locacao() {

	}
	
	public Locacao(double kmSaida, double kmEntrada,TipoLocacao tipo,double valor,Date dataSaida,Date dataDevolucao,int previsaoDias) {
		this.kmSaida = kmSaida;
		this.kmEntrada = kmEntrada;
		this.tipo = tipo;
		this.valor =  valor;
		this.dataSaida = dataSaida;
		this.dataDevolucao = dataDevolucao;
		this.previsaoDias = previsaoDias;
	}
	
	private double kmSaida = 0;
	public void setKmSaida(double kmSaida) {
		this.kmSaida = kmSaida;
	}

	public void setKmEntrada(double kmEntrada) {
		this.kmEntrada = kmEntrada;
	}

	public void setTipo(TipoLocacao tipo) {
		this.tipo = tipo;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public void setPrevisaoDias(int previsaoDias) {
		this.previsaoDias = previsaoDias;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
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

	public Date getDataSaida() {
		return dataSaida;
	}

	public Date getDataDevolucao() {
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