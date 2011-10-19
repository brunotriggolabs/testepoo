package modelo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import persistencia.PersistenciaLocacao;
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		TipoLocacao tipo = new TipoLocacao();
		TipoVeiculo tipoVeiculo = new TipoVeiculo();
		Locacao locacao = new Locacao(12, 13, 2);

		arquivo.salvar(locacao);
		arquivo.pesquisar(2);
//=======
	//	arquivo.salvar(locacao);
		
	//	arquivo.pesquisar("locacao");
//>>>>>>> .r21
		
		//String nomeCliente;
				
		//System.out.println("***** Locarrão Rent a car *****");
		//System.out.println("");
		//System.out.println("");
		//System.out.println("Qual é o seu nome?");
		//final Console ler = null;
		//nomeCliente = ler.readString();
		
	//	if (!(arquivo.pesquisar(nomeCliente))) {
		//	System.out.println("Você ainda não está cadastrado em nosso sistema. Faremos seu cadastro agora.");
			//TODO cadastrar cliente
			
	
	}

}
