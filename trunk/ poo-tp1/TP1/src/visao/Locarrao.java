package visao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import modelo.*;
import persistencia.*;

public class Locarrao {

	private static VisaoCliente cadastroCliente = new VisaoCliente();
	private static VisaoMotorista cadastroMotorista = new VisaoMotorista();
	private static VisaoVeiculo cadastroVeiculo = new VisaoVeiculo();
	private static VisaoFuncionario cadastroFuncionario = new VisaoFuncionario();
	private static VisaoLocacao cadastroLocacao = new VisaoLocacao();
	private static VisaoTipoVeiculo cadastroTipoVeiculo = new VisaoTipoVeiculo();
	protected static String lerCpf;
	protected static String lerMotorista;

	public static final int escolhaMenu(){
		System.out.println("Deseja voltar ao menu? [1==sim]");
		if (Console.readInteger() == 1){
			return 1;
			//NÃO É POSSÍVEL LIMPAR A TELA EM JAVA SEM FAZER GAMBIARRA.
		} else return 0;
	}

	public static void main(String[] args) throws IOException {
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		File arquivo = new File ("arquivos/numLocacoes.txt");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao.numLocacoes = Integer.parseInt(br.readLine());
		System.out.println("Numero de locacoes = " + Locacao.numLocacoes + "\n");
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
			System.out.println("6-Cadastro de Tipo de Locacao");
			System.out.println("7-Listagens");
			System.out.println("8-Encerrar Locacao");
			System.out.println("9-Remoção de registros");
			System.out.println("10-Atualizar registros");
			System.out.println("0-Sair");
			System.out.println("********************************************************");
			opcaoMenu = Console.readInteger();


			switch (opcaoMenu) {
			case 1:
				//Cadastra cliente
				menu = cadastroCliente.cadastraCliente();
				break;
			case 2:
				//Cadastra Motorista
				menu = cadastroMotorista.cadastraMotorista();
				break;
			case 3:
				//Cadastra veículo
				menu = cadastroVeiculo.cadastraVeiculo();
				break;
			case 4:
				//Cadastra Funcionario
				menu = cadastroFuncionario.cadastraFuncionario();
				break;
			case 5:
				//Cadastra Locacao
				menu = cadastroLocacao.cadastraLocacao();
				break;
			case 6:
				// Cadastra tipo de locação
				menu = cadastroTipoVeiculo.cadastraTipoVeiculo();
				break;
			case 7:
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
					System.out.println("Opção inválida");
					break;
				}
			case 8:
				PersistenciaTipoVeiculo arquivoTipo = new PersistenciaTipoVeiculo();
				int tipo;
				System.out.println("Digite o tipo da locação: \n    1 - PorKm \n    2 - KmLivre");
				tipo = Console.readInteger();
				VisaoLocacao.finalizaLocacao(tipov,arquivoTipo.pesquisarTipoLocacao(tipo)); //FALTA CRIAR MÉTODO PRA 
				//PESQUISAR O TIPO VEÍCULO
				break;
			case 9:
				System.out.println("********--------------LOCARRÃO RENT-A-CAR---------------********");
				System.out.println("****************************************************************");
				System.out.println("1-Remover cliente da base de dados");
				System.out.println("2-Remover veículo da base de dados");
				System.out.println("3-Remover motorista da base de dados");
				System.out.println("4-Remover funcionário da base de dados");
				System.out.println("*****************************************************************");
				int opMenu3 = 0;
				opMenu3 = Console.readInteger();
				switch (opMenu3) {
				case 1:
					cadastroCliente.removeCliente();
					break;
				case 2:
					cadastroVeiculo.removeVeiculo();
					break;
				case 3:
					cadastroMotorista.removeMotorista();
					break;
				case 4:
					cadastroFuncionario.removeFuncionario();
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}
				break;
			case 10:
				System.out.println("********--------------LOCARRÃO RENT-A-CAR---------------********");
				System.out.println("****************************************************************");
				System.out.println("1-Atualizar cliente da base de dados");
				System.out.println("2-Atualizar veículo da base de dados");
				System.out.println("3-Atualizar motorista da base de dados");
				System.out.println("4-Atualizar funcionário da base de dados");
				System.out.println("*****************************************************************");
				int opMenu4 = 0;
				opMenu4 = Console.readInteger();
				switch (opMenu4) {
				case 1:
					cadastroCliente.atualizaCliente();
					break;
				case 2:
					cadastroVeiculo.atualizaVeiculo();
					break;
				case 3:
					cadastroMotorista.atualizaMotorista();
					break;
				case 4:
					cadastroFuncionario.atualizaFuncionario();
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}
				break;
			default:
				System.out.println("Deseja Sair?");
				menu = escolhaMenu();
				break;
			}
		}
	}
}