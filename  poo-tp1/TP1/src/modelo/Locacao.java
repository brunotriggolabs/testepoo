package modelo;

import java.math.BigDecimal;
import java.util.Calendar;

public class Locacao {
	
	double kmSaida;
	double kmEntrada;
	TipoLocacao tipo;
	BigDecimal valor;
	Calendario dataSaida;
	Calendario dataDevolucao;
	int previsaoDias;
	
	/*Locacao(Ciente p){
		if (buscaArquivo(Cliente p)) {
			System.out.println("Cliente já cadastrado.");
		} else {
			System.out.println("Cliente não cadastrado.Por favor faça o cadastro");
		}
	}*/
		
	private boolean buscaArquivo() {
		// TODO Fazer a busca no arquivo,falta aprender como faz.
		return false;
	}
	
	public void escolhaCarro(){
		//TODO Fazer a busca no arquivo dos carros disponíveis.
	}
	
	public void escolhaTipo(){
		
	}
}
