package visao;

import java.io.IOException;
import modelo.Cliente;
import modelo.Console;
import modelo.Data;
import modelo.Locacao;
import modelo.TipoLocacao;
import modelo.TipoVeiculo;
import modelo.Veiculo;
import persistencia.PersistenciaCliente;
import persistencia.PersistenciaLocacao;
import persistencia.PersistenciaVeiculo;

public class VisaoLocacao {

	private static boolean checaCpf(String cpf)throws IOException {
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		System.out.println("Verificando se já está cadastrado:");
		if (arquivoCliente.pesquisarCliente(cpf) == null){
			System.out.println("Realizando Cadastro:");
			System.out.println("Digite o seu nome:");
			Cliente cliente = new Cliente(Console.readString(), cpf);
			arquivoCliente.salvaCliente(cliente);
			return false;
		} else {
			System.out.println("Cliente já cadastrado!");
			return true;
		}
	}

	public int cadastraLocacao() throws IOException{
		PersistenciaVeiculo pers = new PersistenciaVeiculo();
		VisaoVeiculo visaoVeiculo = new VisaoVeiculo();
		String lerCpf;
		System.out.println("Digite seu CPF:");
		lerCpf = Console.readString();

		// Se o cliente não estiver cadastrado, então realiza seu cadastro
		checaCpf(lerCpf);

		// Realiza a locação
		System.out.println("Qual a placa do veículo que deseja alugar?");
		String placa = Console.readString();
		boolean disponivel = pers.veiculoDisponivel(placa);
		// Se o veículo estiver disponível, então realiza a locação
		if (disponivel) {
			Veiculo veiculo = new Veiculo("a", "marca", "modelo");
			veiculo = pers.pesquisarVeiculo(placa);
			// Marca o veiculo como alugado
			veiculo.setDisponivel(0);
			// Atualiza o cadastro do veículo
			visaoVeiculo.atualizaVeiculo(veiculo);
			// Finalmente, realiza a locação e a registra no arquivo
			System.out.println("Digite a Km de Saida,Tipo da Locacao[porKm - 1 / Kmlivre - 2] e a previsão de dias da locacao.");
			Locacao locacao = new Locacao(Console.readInteger(), Console.readInteger(), Console.readInteger());
			locacao.setPlaca(placa);
			locacao.setAlugado(true);
			PersistenciaLocacao arquivoLocacao = new PersistenciaLocacao();
			arquivoLocacao.salvar(locacao);
		} else {
			System.out.println("Este veículo já está alugado. Realize outra locação.");
		}
		return Locarrao.escolhaMenu();		
	}

	public static int calculaDias (Locacao loc) {		//MÊS COM 30 DIAS
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
		else { System.out.println("Dados inválidos!"); }
		return dias;
	}

	public static double finalizaLocacao (TipoVeiculo tipov,TipoLocacao tipo) throws IOException {
		final double p;
		int id;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		System.out.println("Digite a ID da sua locacao:");
		id = Console.readInteger();
		System.out.println("Buscando a sua locacao:");
		Locacao loc = arquivo.pesquisar(id);
		loc.setAlugado(false);
		loc.setFinalizado(true);
		if (tipo.getTipo().equals("porKm")){
			p = (loc.getKmEntrada() - loc.getKmSaida()) + ( tipov.getTaxaBase() * calculaDias(loc) ) ;
			loc.setPreco(p);
			return loc.getPreco();
		} else {
			loc.setPreco(tipov.getTaxaBase() * calculaDias(loc) );
			return loc.getPreco();
		}
	}

	public static double locacoesEmAberto() throws IOException {
		double precoTotal;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		precoTotal = arquivo.pesquisaLocacoesEmAberto();
		return precoTotal;
	}

	public static double locacoesFinalizadas() throws IOException{
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		return arquivo.pesquisaPrecoFinalizado();
	}

	public static Data leDia(){
		Data data = new Data();
		System.out.println("Informe dia,mes e ano para pesquisar:");
		data.setDia(Console.readInteger());
		data.setMes(Console.readInteger());
		data.setAno(Console.readInteger());
		return data;
	}
	
}

	
	//public static boolean finalizaLocacao(Locacao loc){
		
	//}