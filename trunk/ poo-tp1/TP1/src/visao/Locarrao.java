package visao;
import java.io.IOException;

import modelo.*;
import persistencia.*;

public class Locarrao {

	protected static String lerCpf;
	protected static String lerMotorista;

	public static int escolhaMenu(){
		System.out.println("Deseja voltar ao menu? [1==sim]");
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
			System.out.println("6-Listagens");
			System.out.println("7-Encerrar Locacao");
			System.out.println("0-Sair");
			System.out.println("********************************************************");
			opcaoMenu = Console.readInteger();


			switch (opcaoMenu) {
			case 1:
				//Cadastra cliente
				VisaoCliente cadastroCliente = new VisaoCliente();
				menu = cadastroCliente.cadastraCliente();
				break;
			case 2:
				//Cadastra Motorista
				VisaoMotorista cadastroMotorista = new VisaoMotorista();
				menu = cadastroMotorista.cadastraMotorista();
				break;
			case 3:
				//Cadastra veículo
				VisaoVeiculo cadastroVeiculo = new VisaoVeiculo();
				menu = cadastroVeiculo.cadastraVeiculo();
				break;
			case 4:
				//Cadastra Funcionario
				VisaoFuncionario cadastroFuncionario = new VisaoFuncionario();
				menu = cadastroFuncionario.cadastraFuncionario();
				break;
			case 5:
				//Cadastra Locacao
				VisaoLocacao cadastroLocacao = new VisaoLocacao();
				menu = cadastroLocacao.cadastraLocacao();
				break;
			case 6:
				System.out.println("********--------------LOCARRÃO RENT-A-CAR---------------********");
				System.out.println("****************************************************************");
				System.out.println("********--------------Opções para Listagem-------------*********");
				System.out.println("1-Locacoes em aberto");
				System.out.println("2-Locacoes finalizadas");
				System.out.println("3-Veiculos disponiveis");
				System.out.println("4-Veículos mais procurados");
				System.out.println("5-Veículos mais rentáveis");
				System.out.println("6-Pesquisar clientes");
				System.out.println("7-Pesquisar disponibilidade de determinada categoria de veículos");
				System.out.println("*****************************************************************");
				int opMenu2 = 0;
				opMenu2 = Console.readInteger();
				switch (opMenu2) {
				case 1:
					VisaoLocacao.locacoesEmAberto(VisaoLocacao.leDia());
					break;
				case 2:
					VisaoLocacao.locacoesFinalizadas();
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				default:
					System.out.println("Deseja Sair?");
					menu = escolhaMenu();
					break;
				}
			case 7:
				
				break;
			default:
				System.out.println("Deseja Sair?");
				menu = escolhaMenu();
				break;
			}
		}
	}
}