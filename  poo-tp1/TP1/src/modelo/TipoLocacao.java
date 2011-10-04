package modelo;

public class TipoLocacao {
	private String tipo = ""; //porKm ou Km livre
	private double taxaBase;
	private double precoKm;
	
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