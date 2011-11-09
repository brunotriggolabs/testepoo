package modelo;

public class Motorista extends Pessoa {
	private String cnh;
	private int locacao;
	
	public Motorista(String nome, String cpf, String cnh) {
		super(nome, cpf);
		this.cnh = cnh;
	}

	public String getCnh() {
		return cnh;
	}
	
	public int getLocacao() {
		return locacao;
	}
	
	public void setLocacao(int locacao) {
		this.locacao = locacao;
	}
	
}
