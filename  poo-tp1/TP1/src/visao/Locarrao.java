package visao;
import java.io.IOException;

import modelo.*;
import persistencia.*;

public class Locarrao {

	private static String lerCpf;
	private static String lerMotorista;

	private static void lerValores (){
		System.out.println("Escolha o tipo do carro");
		Console.readInteger();
		System.out.println("Escolhe o tipo da locação [1 - por KM , 2 - KM livre]");
		Console.readInteger();
		System.out.println("Você será o motorista do carro?");
		lerMotorista = Console.readString();
		if (lerMotorista == "Sim" || lerMotorista == "sim" || lerMotorista == "S" || lerMotorista == "s"){
			//TODO realizar cadastro do cliente-motorista
		} else {
			//TODO Realiza cadastro motorista
		}
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

	private static boolean checaCpf(String cpf)throws IOException {
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		System.out.println("Verificando se já está cadastrado:");
		if (arquivoCliente.pesquisarCliente(lerCpf) == null){
			System.out.println("Realizando Cadastro:");
			System.out.println("Digite o seu nome:");
			Cliente cliente = new Cliente(Console.readString(), lerCpf);
			arquivoCliente.salvaCliente(cliente);
			return false;
		} else {
			System.out.println("Cliente já cadastrado!");
			return true;
		}
	}

	private static int escolhaMenu(){
		System.out.println("Deseja voltar ao menu?");
		if (Console.readInteger() == 1){
			return 1;
			//NÃO É POSSÍVEL LIMPAR A TELA EM JAVA SEM FAZER GAMBIARRA.
		} else return 0;
	}

	public static void main(String[] args) throws IOException {
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		int menu = 1;
		while (menu==1){
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
			opcaoMenu = Console.readInteger();


			switch (opcaoMenu) {
			case 1:
				//Cadastra cliente
				System.out.println("Digite Nome e em seguida o CPF:");
				Cliente cliente2 = new Cliente(Console.readString(),Console.readString());
				arquivoCliente.salvaCliente(cliente2);
				menu = escolhaMenu();
				break;
			case 2:
				//Cadastra Motorista
				System.out.println("Digite o nome,CPF e CNH do motorista");
				Motorista motorista = new Motorista(Console.readString(), Console.readString(), Console.readString());
				PersistenciaMotorista arquivoMotorista = new PersistenciaMotorista();
				arquivoMotorista.salvaMotorista(motorista);
				menu = escolhaMenu();
				break;
			case 3:
				//Cadastra veículo
				System.out.println("Digite placa,marca,modelo");
				Veiculo veiculo = new Veiculo(Console.readString(), Console.readString(), Console.readString());
				PersistenciaVeiculo arquivoVeiculo = new PersistenciaVeiculo();
				arquivoVeiculo.salvaVeiculo(veiculo);
				menu = escolhaMenu();
				break;
			case 4:
				//Cadastra Funcionario
				System.out.println("Digite: nome, cpf, cargo");
				Funcionario funcionario = new Funcionario(Console.readString(), Console.readString(), Console.readString());
				PersistenciaFuncionario arquivoFuncionario = new PersistenciaFuncionario();
				arquivoFuncionario.salvaFuncionario(funcionario);
				menu = escolhaMenu();
				break;
			case 5:
				//Cadastra Locacao
				String lerCpf;
				System.out.println("Digite seu CPF:");
				lerCpf = Console.readString();
				if(!checaCpf(lerCpf)){
					System.out.println("Digite a Km de Saida,Tipo da Locacao(por Km ou Km livre) e a previsão de dias da locacao.");
					Locacao locacao = new Locacao(Console.readInteger(), Console.readInteger(), Console.readInteger());
					PersistenciaLocacao arquivoLocacao = new PersistenciaLocacao();
					arquivoLocacao.salvar(locacao);
					menu = escolhaMenu();
					break;
				}
			default:
				System.out.println("OPÇÃO INVÀLIDA");
				menu = escolhaMenu();
				break;
			}
		}
	}
}