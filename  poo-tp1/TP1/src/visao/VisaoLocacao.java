package visao;

import java.io.IOException;
import modelo.Cliente;
import modelo.Console;
import modelo.Data;
import modelo.Locacao;
import modelo.TipoLocacao;
import modelo.TipoVeiculo;
import persistencia.PersistenciaCliente;
import persistencia.PersistenciaLocacao;

public class VisaoLocacao {
	
	private boolean verificacaoMotorista () {
		
		
		return false;
	}
	
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
		String lerCpf;
		int menu;
		System.out.println("Digite seu CPF:");
		lerCpf = Console.readString();
		if(!checaCpf(lerCpf)){
			System.out.println("Digite a Km de Saida,Tipo da Locacao[porKm - 1 / Kmlivre - 2] e a previsão de dias da locacao.");
			Locacao locacao = new Locacao(Console.readInteger(), Console.readInteger(), Console.readInteger());
			locacao.setAlugado(true);
			PersistenciaLocacao arquivoLocacao = new PersistenciaLocacao();
			arquivoLocacao.salvar(locacao);
			return menu = Locarrao.escolhaMenu();
		}else return Locarrao.escolhaMenu();		
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
		else System.out.println("Dados inválidos!");
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
			p = (loc.getKmSaida() - loc.getKmEntrada()) + ( tipov.getTaxaBase() * calculaDias(loc) ) ;
			loc.setPreco(p);
			return loc.getPreco();
		}else{
			loc.setPreco(tipov.getTaxaBase() * calculaDias(loc) );
			return loc.getPreco();
		}
	}

	public static double locacoesEmAberto(Data dia) throws IOException {
		//TODO pegar período desejado
		double precoTotal = 0.0;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		precoTotal = precoTotal + arquivo.pesquisaLocacoesEmAberto();

		return precoTotal;
	}

	public static double locacoesFinalizadas() throws IOException{
		double resultado = 0;
		PersistenciaLocacao arquivo = new PersistenciaLocacao();
		resultado = resultado + arquivo.pesquisaPrecoFinalizado();
		return resultado;
	}
	
	public static  Data leDia(){
		Data data = new Data();
		System.out.println("Informe dia,mes e ano para pesquisar:");
		data.setDia(Console.readInteger());
		data.setMes(Console.readInteger());
		data.setAno(Console.readInteger());
		return data;
	}
}