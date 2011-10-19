package visao;
import java.io.IOException;

import modelo.*;
import persistencia.*;

public class Locarrao {

	private static String lerCpf;
	private static int lerModelo;
	private static int lerTipoLocacao;
	private static String lerMotorista;
	private static final Console con = null;
	
	private static void lerValores (){
		System.out.println("Escolha o tipo do carro");
		lerModelo = con.readInteger();
		System.out.println("Escolhe o tipo da locação [1 - por KM , 2 - KM livre]");
		lerTipoLocacao = con.readInteger();
		System.out.println("Você será o motorista do carro?");
		lerMotorista = con.readString();
		if (lerMotorista == "Sim" || lerMotorista == "sim" || lerMotorista == "S" || lerMotorista == "s"){
			//TODO realizar cadastro do cliente-motorista
		} else {
			//TODO Realiza cadastro motorista
		}	
	}
	
	static PersistenciaLocacao arquivo = new PersistenciaLocacao();
	
	private static boolean verificaCpf (String cpf){
		//Verifica CPF no arquivo

		return true;
	}
	
	private static int calculaDias (Locacao loc) {		//MÊS COM 30 DIAS
		int dias = 0;
		if (loc.getAnoSaida() == loc.getAnoEntrada()) {
			if (loc.getMesEntrada() == loc.getMesSaida()) {
				dias = (loc.getDiaEntrada() - loc.getDiaSaida());
			}
			else if (loc.getMesEntrada() > loc.getMesSaida()) {
				if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
					dias = ((loc.getMesEntrada() - loc.getMesSaida())*30) + (loc.getDiaEntrada() - loc.getDiaSaida());  
				}
				else dias = ((loc.getMesEntrada() - loc.getMesSaida())*30) - (loc.getDiaEntrada() - loc.getDiaSaida());
			}
		}
		else if (loc.getAnoSaida() < loc.getAnoEntrada()) {
			if (loc.getMesEntrada() >= loc.getMesSaida()) {
				if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
					dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) + ((loc.getMesEntrada() - loc.getMesSaida())*30) + (loc.getDiaEntrada() - loc.getDiaSaida());
				}
				else dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) + ((loc.getMesEntrada() - loc.getMesSaida())*30) - (loc.getDiaEntrada() - loc.getDiaSaida());
			}
			else if (loc.getDiaEntrada() >= loc.getDiaSaida()) {
				dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) - ((loc.getMesEntrada() - loc.getMesSaida())*30) + (loc.getDiaEntrada() - loc.getDiaSaida());
			}	
			else dias = ((loc.getDiaEntrada() - loc.getAnoSaida())*365) - ((loc.getMesEntrada() - loc.getMesSaida())*30) - (loc.getDiaEntrada() - loc.getDiaSaida());	
		}
		else System.out.println("Dados inválidos!");
		return dias;
	}

	
	
	private static double calculoPreco (TipoVeiculo tipov,Locacao loc,TipoLocacao tipo) {
		final double p;
		loc.setAlugado(false);
		if (tipo.getTipo().equals("porKm")){
			p = (loc.getKmSaida() - loc.getKmEntrada()) + ( tipov.getTaxaBase() * calculaDias(loc) ) ;
			loc.setPreco(p);
			return loc.getPreco();
		}else{
			loc.setPreco(tipov.getTaxaBase() * calculaDias(loc) );
			return loc.getPreco();
		}
	}

	private static double locacoesEmAberto(Data dia,Locacao locacao) {
		//TODO pegar período desejado
		double precoTotal = 0.0;
		precoTotal = precoTotal + arquivo.pesquisaLocacoesEmAberto();
		
	return precoTotal;
}
	
	private static double locacoesFinalizadas(){
		double resultado = 0;
		try {
			resultado += arquivo.pesquisaPrecoFinalizado();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	
	public static void main(String[] args) throws IOException {
		

		System.out.println("********----------LOCARRÃO RENT-A-CAR----------********");
		System.out.println("Verificando se já está cadastrado:");
		System.out.println("Digite seu CPF");
		lerCpf = con.readString();
		//TODO criar método para verificar o CPF
		/*if (verificaCpf == false){
			//TODO realiza cadastro
		}*/
		System.out.println("Devolução:");
		
	}
}