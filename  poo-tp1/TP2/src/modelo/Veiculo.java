package modelo;


public class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private String tipo;
	private String opicionais;
	private String observacoes;
	private int disponivel;
	private int locacao;
	private int numLocacoes;
	
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.disponivel = 1;
		this.locacao = 0;
		this.numLocacoes = 0;
	}

	public void setNumLocacoes(int numLocacoes) {
		this.numLocacoes = numLocacoes;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setOpicionais(String opicionais) {
		this.opicionais = opicionais;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}
	
	public void setLocacao(int locacao) {
		this.locacao = locacao;
	}
	
	public String getCor() {
		return cor;
	}
	
	public String getTipo() {
		return tipo;
	} 
	
	public int getDisponivel() {
		return disponivel;
	}
	
	public int getLocacao() {
		return locacao;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public String getOpicionais() {
		return opicionais;
	}
	
	public String getPlaca() {
		return placa;
	}
		
	public int getNumLocacoes() {
		return numLocacoes;
	}
	
}
