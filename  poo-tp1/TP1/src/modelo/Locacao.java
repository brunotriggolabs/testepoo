package modelo;

import java.io.IOException;
import java.util.Date;

import persistencia.PersistenciaLocacao;

public class Locacao {
	
	private int kmSaida;
	private int kmEntrada;
	private int tipoLocacao;
	private int tipoVeiculo;
	private double valor;
	private int diaEntrada;
	private int diaSaida;
	private int mesEntrada;
	private int mesSaida;
	private int anoEntrada;
	private int anoSaida;
	private int previsaoDias;
	private boolean alugado;
	private boolean finalizado;
	private double preco;
	private int id;
	public static int numLocacoes = 0;
		
	@SuppressWarnings("deprecation")
	public Locacao(int kmSaida, int tipoLocacao,int previsaoDias) {
		this.kmSaida = kmSaida;
		this.kmEntrada = kmSaida;
		this.tipoLocacao = tipoLocacao;
		this.valor = 5;
		this.diaEntrada = new Date().getDate();
		this.mesEntrada = new Date().getMonth();
		this.anoEntrada = new Date().getYear();
		this.previsaoDias = previsaoDias;
		System.out.println(numLocacoes);
		this.id = numLocacoes;
		numLocacoes++;
	}
	
	public Locacao(int kmSaida, int tipoLocacao) {
		this.kmSaida = kmSaida;
		this.kmEntrada = kmSaida;
		this.tipoLocacao = tipoLocacao;
		this.valor =  4;
		this.diaEntrada = new Date().getDate();
		this.mesEntrada = new Date().getMonth();
		this.anoEntrada = new Date().getYear();
		this.previsaoDias = 2;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public static int getNumLocacoes() {
		return numLocacoes;
	}

	public static void setNumLocacoes(int numLocacoes) {
		Locacao.numLocacoes = numLocacoes;
	}
	
	public int getDiaEntrada() {
		return diaEntrada;
	}

	public void setDiaEntrada(int diaEntrada) {
		this.diaEntrada = diaEntrada;
	}

	public int getDiaSaida() {
		return diaSaida;
	}

	public void setDiaSaida(int diaSaida) {
		this.diaSaida = diaSaida;
	}

	public int getMesEntrada() {
		return mesEntrada;
	}

	public void setMesEntrada(int mesEntrada) {
		this.mesEntrada = mesEntrada;
	}

	public int getMesSaida() {
		return mesSaida;
	}

	public void setMesSaida(int mesSaida) {
		this.mesSaida = mesSaida;
	}

	public int getAnoEntrada() {
		return anoEntrada;
	}

	public void setAnoEntrada(int anoEntrada) {
		this.anoEntrada = anoEntrada;
	}

	public int getAnoSaida() {
		return anoSaida;
	}

	public void setAnoSaida(int anoSaida) {
		this.anoSaida = anoSaida;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}	
	
	public void setKmSaida(int kmSaida) {
		this.kmSaida = kmSaida;
	}

	public void setKmEntrada(int kmEntrada) {
		this.kmEntrada = kmEntrada;
	}

	public void setTipoLocacao(int tipoLocacao) {
		this.tipoLocacao = tipoLocacao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setPrevisaoDias(int previsaoDias) {
		this.previsaoDias = previsaoDias;
	}

	public int getKmSaida() {
		return kmSaida;
	}

	public int getKmEntrada() {
		return kmEntrada;
	}

	public double getValor() {
		return valor;
	}

	public int getPrevisaoDias() {
		return previsaoDias;
	}

	public int getTipoVeiculo() {
		return tipoVeiculo;
	}
	
	public void setTipoVeiculo(int tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public int getTipoLocacao() {
		return tipoLocacao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	private static int calculaDias (Locacao loc) {		//MÊS COM 30 DIAS
		int dias = 0;
		if (loc.getAnoSaida() == loc.getAnoEntrada()) {
			if (loc.getMesEntrada() == loc.getMesSaida()) {
				dias = (loc.getDiaEntrada() - loc.getDiaSaida());
			}
			else if (loc.getMesEntrada() > loc.getMesSaida()) {
				if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
					dias = ((loc.getMesEntrada() - loc.getMesSaida())*30) + (loc.getDiaEntrada() - loc.getDiaSaida());  
				}
				else dias = ((loc.getMesEntrada() - loc.getMesSaida())*30) - (loc.getDiaEntrada() - loc.getDiaSaida());
			}
		}
		else if (loc.getAnoSaida() < loc.getAnoEntrada()) {
			if (loc.getMesEntrada() >= loc.getMesSaida()) {
				if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
					dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) + ((loc.getMesEntrada() - loc.getMesSaida())*30) + (loc.getDiaEntrada() - loc.getDiaSaida());
				}
				else dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) + ((loc.getMesEntrada() - loc.getMesSaida())*30) - (loc.getDiaEntrada() - loc.getDiaSaida());
			}
			else if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
				dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) - ((loc.getMesEntrada() - loc.getMesSaida())*30) + (loc.getDiaEntrada() - loc.getDiaSaida());
			}	
			else dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) - ((loc.getMesEntrada() - loc.getMesSaida())*30) - (loc.getDiaEntrada() - loc.getDiaSaida());	
		}
		else System.out.println("Dados inválidos!");
		return dias;
	}



	private static double calculoPreco (TipoVeiculo tipov,Locacao loc,TipoLocacao tipo) {
		final double p;
		loc.setAlugado(false);
		if (tipo.getTipo().equals("porKm")){
			p = (loc.getKmSaida() - loc.getKmEntrada()) + ( tipov.getTaxaBase() * calculaDias(loc) ) ;
			loc.setPreco(p);
			return loc.getPreco();
		}else{
			loc.setPreco(tipov.getTaxaBase() * calculaDias(loc) );
			return loc.getPreco();
		}
	}

	private static double locacoesEmAberto(Data dia,Locacao locacao) throws IOException {
		//TODO pegar período desejado
		double precoTotal = 0.0;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		precoTotal = precoTotal + arquivo.pesquisaLocacoesEmAberto();

		return precoTotal;
	}

	private static double locacoesFinalizadas() throws IOException{
		double resultado = 0;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		resultado = resultado + arquivo.pesquisaPrecoFinalizado();
		return resultado;
	}
	
}