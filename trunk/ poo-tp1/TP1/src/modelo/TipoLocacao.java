package modelo;

public class TipoLocacao {
	private String tipo = ""; //porKm ou Km livre
	private double taxaBase = 0.0;
	private double precoKm = 0.0;
	
	public TipoLocacao(){
		
	}
	
	public TipoLocacao(String tipo,double taxaBase,double precoKm){
		this.tipo = tipo;
		this.precoKm = precoKm;
		this.taxaBase = taxaBase;
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