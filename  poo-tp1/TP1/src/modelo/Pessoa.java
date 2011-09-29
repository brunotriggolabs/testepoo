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

	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
}
