package modelo;

public class TipoLocacao {
	private String tipo; //porKm ou Km livre
	private double taxaBase;
	private double precoKm;
	
	public TipoLocacao(String tipo, Double taxa, Double precoKm) {
		this.tipo = tipo;
		this.taxaBase = taxa;
		this.precoKm = this.precoKm;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setTaxaBase(double taxaBase) {
		this.taxaBase = taxaBase;
	}
	public void setPrecoKm(double precoKm) {
		this.precoKm = precoKm;
	}
	
	public String getTipo() {
		return tipo;
	}
	public double getTaxaBase() {
		return taxaBase;
	}
	public double getPrecoKm() {
		return precoKm;
	}	
}