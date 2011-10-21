package modelo;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String endereco;
	protected String telefone;
	
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
