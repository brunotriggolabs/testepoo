package modelo;

import java.awt.List;
import java.util.ArrayList;

public class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private String tipo;
	private String opicionais;
	private String observacoes;
	private int disponivel;
	
	
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.disponivel = 1;
		Locacao locacao = new Locacao();
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
	
	public int getModelo() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getPlaca() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getMarca() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCor() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getObservacoes() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getOpcionais() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getDisponivel() {
		return disponivel;
	}
	
	//TODO implementar os métodos do veículo
	
}
