package modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa {
	
	private ArrayList<Integer> locacao;
	
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		this.locacao = new ArrayList<Integer>();
	}
	
	public Object[] tamanhoVetor() {
		return locacao.toArray();
	}
	
	public void addLocacao(int locacao) {
		this.locacao.add(locacao);
	}
	//TODO adicionar métodos do cliente
	
}
