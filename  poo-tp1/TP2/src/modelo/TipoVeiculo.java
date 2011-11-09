package modelo;

public class TipoVeiculo {

	protected double precokm;
	protected double taxaBase;
	protected String tipo;
	
	public TipoVeiculo(String tipo, double precoKm, double taxaBase) {
		this.tipo = tipo;
		this.precokm = precoKm;
		this.taxaBase = taxaBase;
	}
	
	public double getTaxaBase() {
		return taxaBase;
	}

	public double getPrecokm() {
		return precokm;
	}

	public String getTipo() {
		return tipo;
	}

}
