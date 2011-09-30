package modelo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

public class Locacao {
	
	protected int kmSaida = 0;
	protected int kmEntrada = 0;
	protected TipoLocacao tipo = new TipoLocacao();
	protected double valor;
	protected Calendar dataSaida;
	protected Calendar dataDevolucao;
	protected int previsaoDias;
		
	Locacao(){
		
	}
	
	/*Locacao(Cliente p){
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		if (arquivo.pesquisar(p.nome)) {
			System.out.println("Cliente já cadastrado.");
		} else {
			System.out.println("Cliente não cadastrado.Por favor faça o cadastro");
		}
	}*/
		
	public void escolhaCarro(String marcaCarro) throws IOException{
		//TODO Fazer a busca no arquivo dos carros disponíveis.
		
		
	}
}