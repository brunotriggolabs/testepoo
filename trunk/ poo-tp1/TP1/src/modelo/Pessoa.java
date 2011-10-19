package modelo;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	public Pessoa(String nome, String cpf) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
}
