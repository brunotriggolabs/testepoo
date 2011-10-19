	package modelo;

public class TipoVeiculo {
	
	protected double precokm;
	public void setPrecokm(double precokm) {
		this.precokm = precokm;
	}

	public void setTaxaBase(double taxaBase) {
		this.taxaBase = taxaBase;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected double taxaBase;
	protected String tipo;
	
	public TipoVeiculo() {
		// TODO Auto-generated constructor stub
	}

	public int getTaxaBase() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPrecokm() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
