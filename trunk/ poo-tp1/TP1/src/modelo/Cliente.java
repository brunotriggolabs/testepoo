package modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa {
	
	private ArrayList<Integer> locacao;
	
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		this.locacao = new ArrayList<Integer>();
	}
	
	//TODO adicionar métodos do cliente
	
}
