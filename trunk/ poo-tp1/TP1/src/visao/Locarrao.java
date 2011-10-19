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

	private static double locacoesEmAberto(Data dia,Locacao locacao) throws IOException {
		//TODO pegar período desejado
		double precoTotal = 0.0;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		precoTotal = precoTotal + arquivo.pesquisaLocacoesEmAberto();
		
	return precoTotal;
}
	
	private static double locacoesFinalizadas() throws IOException{
		double resultado = 0;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		resultado = resultado + arquivo.pesquisaPrecoFinalizado();
		return resultado;
	}

	private boolean checaCpf(String cpf) {
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		System.out.println("Verificando se já está cadastrado:");
		System.out.println("Digite seu CPF");
		lerCpf = con.readString();
		if (arquivoCliente.pesquisarCliente(lerCpf) == null){
			Cliente cliente = new Cliente(con.readString(), lerCpf);
			arquivoCliente.salvaCliente(cliente);
			return false;
		} else {
			System.out.println("Cliente já cadastrado!");
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		Locacao loc = new Locacao(2, 1, 3);
		TipoVeiculo tipov =  new TipoVeiculo();
		TipoLocacao tipo = new TipoLocacao();
		Data dia = new Data();
		int opcaoMenu = 0;
		System.out.println("********----------LOCARRÃO RENT-A-CAR----------********");
		System.out.println("*******************************************************");
		System.out.println("********----------Opções para cadastro---------*********");
		System.out.println("1-Cadastro Cliente");
		System.out.println("2-Cadastro Motorista");
		System.out.println("3-Cadastro Veiculo");
		System.out.println("4-Cadastro Funcionario");
		System.out.println("5-Cadastro Locacao");
		System.out.println("********************************************************");
		opcaoMenu = con.readInteger();
		/**/
		switch (opcaoMenu) {
		case 1:
			//Cadastra cliente
			System.out.println("Digite Nome e em seguida o CPF:");
			Cliente cliente2 = new Cliente(con.readString(),con.readString());
			arquivoCliente.salvaCliente(cliente2);
			break;
		case 2:
			//Cadastra Motorista
			System.out.println("Digite o nome,CPF e CNH do motorista");
			Motorista motorista = new Motorista(con.readString(), con.readString(), con.readString());
			PersistenciaMotorista arquivoMotorista = new PersistenciaMotorista();
			arquivoMotorista.salvaMotorista(motorista);
			break;
		case 3:
			//Cadastra veículo
			System.out.println("Digite placa,marca,modelo");
			Veiculo veiculo = new Veiculo(con.readString(), con.readString(), con.readString());
			PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
			arquivoVeiculo.salvaVeiculo(veiculo);
			break;
		case 4:
			//Cadastra Funcionario
			System.out.println("Digite: nome, cpf, cargo");
			Funcionario funcionario = new Funcionario(con.readString(), con.readString(), con.readString());
			PersistenciaFuncionario arquivoFuncionario = new PersistenciaFuncionario();
			arquivoFuncionario.salvaFuncionario(funcionario);
			break;
		case 5:
			//Cadastra Locacao
			System.out.println("Digite a Km de Saida,Tipo da Locacao(por Km ou Km livre) e a previsão de dias da locacao.");
			Locacao locacao = new Locacao(con.readInteger(), con.readInteger(), con.readInteger());
			PersistenciaLocacao arquivoLocacao = new PersistenciaLocacao();
			arquivoLocacao.salvar(locacao);
			break;
		default:
			System.out.println("OPÇÃO INVÀLIDA");
			break;
		}
	}
}