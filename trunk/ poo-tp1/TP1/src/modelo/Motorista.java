package modelo;

public class Motorista extends Pessoa {
	private String cnh;
	
	public Motorista(String nome, String cpf, String cnh) {
		super(nome, cpf);
		Locacao locacao = new Locacao();
	}

	public String getCnh() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//TODO adicionar métodos do motorista
}
