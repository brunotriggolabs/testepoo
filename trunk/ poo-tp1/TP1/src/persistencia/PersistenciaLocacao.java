package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Console;
import modelo.Data;
import modelo.Locacao;

public class PersistenciaLocacao  {

	public PersistenciaLocacao() throws IOException {
	}	

	public File arquivo = new File ("arquivos/Locacao.txt");
	public FileWriter fw = new FileWriter(arquivo,true);
	public BufferedWriter out = new BufferedWriter(fw);

	public void salvar(Locacao locacao)throws IOException {
		Locacao.numLocacoes++;
		// Lê o numero de locações e atualiza o arquivo
		File numLocacoes = new File("arquivos/numLocacoes.txt");
		FileWriter fw = new FileWriter(numLocacoes);
		BufferedWriter escreve = new BufferedWriter(fw);
		String x = String.valueOf(Locacao.numLocacoes);
		escreve.write(x);
		escreve.flush();
		escreve.close();

		out.write(x);
		out.write(";");
		out.write(String.valueOf(locacao.getValor()));
		out.write(";");
		out.write(String.valueOf(locacao.getDiaEntrada()));
		out.write(";");
		out.write(String.valueOf(locacao.getMesEntrada()));
		out.write(";");
		out.write(String.valueOf(locacao.getAnoEntrada()));
		out.write(";");
		out.write(String.valueOf(locacao.getDiaSaida()));
		out.write(";");
		out.write(String.valueOf(locacao.getMesSaida()));
		out.write(";");
		out.write(String.valueOf(locacao.getAnoSaida()));
		out.write(";");
		out.write(String.valueOf(locacao.getKmSaida()));
		out.write(";");
		out.write(String.valueOf(locacao.getKmEntrada()));
		out.write(";");
		out.write(String.valueOf(locacao.getPrevisaoDias()));
		out.write(";");
		out.write(String.valueOf(locacao.getTipoLocacao()));
		out.write(";");
		out.write(String.valueOf(locacao.getPreco()));
		out.write(";");
		out.write(new Boolean(locacao.isAlugado()).toString());
		out.write(";");
		out.write(String.valueOf(locacao.isFinalizado()));
		out.write(";");
		out.write(locacao.getPlaca());
		out.write("\n");
		out.flush();
		out.close();
	}

	public Locacao pesquisar(int id) throws IOException{
		String conteudoLinha = null;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		while(true){
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conteudoLinha == null) {
				System.out.println("Locação não encontrada!");
				return null;
			}
			s = conteudoLinha.split("\\;");
			loc = converteOriginal(s);
			if (loc.getId() == id) {
				System.out.println("Encontrado!");
				return loc;
			}
		}
		return null;
	}

	public void deletaLocacao(int id) throws IOException {
		String conateudoLinha = null;
		String s[];
		Locacao loc = new Locacao(5, 2, 3);
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/locacaoTemp.txt");
		FileWriter fwTemp = new FileWriter(novo,true);
		BufferedWriter bwTemp = new BufferedWriter(fwTemp);
		while(true) {
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				break;
			}
			s = conateudoLinha.split("\\;");
			loc = converteOriginal(s);
			if (String.valueOf(loc.getId()).equals(String.valueOf(id))) {
				System.out.println("Locacao deletada do registro");
			} else {
				bwTemp.write(String.valueOf(loc.getId()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getValor()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getDiaEntrada()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getMesEntrada()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getAnoEntrada()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getDiaSaida()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getMesSaida()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getAnoSaida()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getKmSaida()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getKmEntrada()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getPrevisaoDias()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getTipoLocacao()));
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.getPreco()));
				bwTemp.write(";");
				bwTemp.write(new Boolean(loc.isAlugado()).toString());
				bwTemp.write(";");
				bwTemp.write(String.valueOf(loc.isFinalizado()));
				bwTemp.write(";");
				bwTemp.write(loc.getPlaca());
				bwTemp.write("\n");								//Carrega o buff
			}
		}
		bwTemp.flush();			//escrever o buff no arquivo
		bwTemp.close();		//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/Locacao.txt"));  
	}

	private Locacao converteOriginal (String s[]) throws IOException {
		int dias = Integer.parseInt(s[10]);
		int kmSaida = Integer.parseInt(s[8]);
		int km = (int)kmSaida;
		double tipo = Integer.parseInt(s[11]);
		int tp = (int)tipo;
		Locacao loc = new Locacao(km, tp);
		loc.setPrevisaoDias(dias);
		loc.setId(Integer.valueOf(s[0]));
		loc.setDiaEntrada(Integer.valueOf(s[2]));
		loc.setMesEntrada(Integer.valueOf(s[3]));
		loc.setAnoEntrada(Integer.valueOf(s[4]));
		loc.setDiaSaida(Integer.valueOf(s[5]));
		loc.setMesSaida(Integer.valueOf(s[6]));
		loc.setAnoSaida(Integer.valueOf(s[7]));
		loc.setPreco(Double.parseDouble(s[12]));
		loc.setAlugado(Boolean.parseBoolean(s[13]));
		loc.setFinalizado(Boolean.parseBoolean(s[14]));
		loc.setPlaca(s[15]);
		return loc;
	}

	public double pesquisaPrecoFinalizado () throws IOException{
		String conteudoLinha = null;
		String s[];
		File arquivo = new File ("arquivos/Locacao.txt");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		double resultado = 1;
		System.out.println("Deseja informar o periodo? S/N");
		char resposta = Console.readChar();
		while (resposta != 's' || resposta != 'S' || resposta != 'n' || resposta != 'N') {
			System.out.println("Digite S para sim ou N para não");
			resposta = Console.readChar();
		}
		Data dataInicio = new Data();
		Data dataFim = new Data();
		if (resposta == 'S' || resposta == 's') {
			System.out.println("Digite o período que deseja testar");
			System.out.println("Início do período:");
			System.out.println("Digite o dia: ");
			dataInicio.setDia(Console.readInteger());
			System.out.println("Digite o mês: ");
			dataInicio.setMes(Console.readInteger());
			System.out.println("Digite o ano: ");
			dataInicio.setAno(Console.readInteger());
			System.out.println("Fim do período:");
			System.out.println("Digite o dia: ");
			dataFim.setDia(Console.readInteger());
			System.out.println("Digite o mês: ");
			dataFim.setMes(Console.readInteger());
			System.out.println("Digite o ano: ");
			dataFim.setAno(Console.readInteger());
		}
		while(true){
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conteudoLinha == null) {
				break;
			}
			s = conteudoLinha.split("\\;");
			loc = converteOriginal(s);
			// Se o usuário informou o periodo, então pesquisa entre as locações daquele período
			if (resposta == 'S' || resposta == 's') {
				if (verificaDiasLocacaoFechada(loc, dataInicio, dataFim)){
					resultado = resultado + loc.getPreco();
				}
			} else {
				// Senão, pesquisa todas as locações em aberto
				if (loc.isFinalizado()){
					resultado = resultado + loc.getPreco();
				}
			}
		}
		return resultado;
	}

	public double pesquisaLocacoesEmAberto () throws IOException {
		String conteudoLinha = null;
		String s[];
		File arquivo = new File ("arquivos/Locacao.txt");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		double resultado = 1;
		System.out.println("Deseja informar o periodo? S/N");
		char resposta = Console.readChar();
		while (resposta != 's' || resposta != 'S' || resposta != 'n' || resposta != 'N') {
			System.out.println("Digite S para sim ou N para não");
			resposta = Console.readChar();
		}
		Data dataInicio = new Data();
		Data dataFim = new Data();
		if (resposta == 'S' || resposta == 's') {
			System.out.println("Digite o período que deseja testar");
			System.out.println("Início do período:");
			System.out.println("Digite o dia: ");
			dataInicio.setDia(Console.readInteger());
			System.out.println("Digite o mês: ");
			dataInicio.setMes(Console.readInteger());
			System.out.println("Digite o ano: ");
			dataInicio.setAno(Console.readInteger());
			System.out.println("Fim do período:");
			System.out.println("Digite o dia: ");
			dataFim.setDia(Console.readInteger());
			System.out.println("Digite o mês: ");
			dataFim.setMes(Console.readInteger());
			System.out.println("Digite o ano: ");
			dataFim.setAno(Console.readInteger());
		}
		while(true){
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conteudoLinha == null) {
				break;
			}
			s = conteudoLinha.split("\\;");
			loc = converteOriginal(s);
			// Se o usuário informou o periodo, então pesquisa entre as locações daquele período
			if (resposta == 'S' || resposta == 's') {
				if (verificaDiasLocacaoAberta(loc, dataInicio, dataFim)){
					resultado = resultado + loc.getPreco();
				}
			} else {
				// Senão, pesquisa todas as locações em aberto
				if (loc.isAlugado()){
					resultado = resultado + loc.getPreco();
				}
			}
		}
		return resultado;
	}
	
	public double retornaPreco (String placa) throws IOException {
		double preco = 0;
		String conteudoLinha = null;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		while(true){
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conteudoLinha == null) {
				break;
			}
			s = conteudoLinha.split("\\;");
			loc = converteOriginal(s);
			if (placa == loc.getPlaca()) {
				preco = preco + loc.getPreco();
			}
		}
		return preco;
	}

	private boolean verificaDiasLocacaoAberta(Locacao loc, Data inicio, Data fim) {
		// Verificando se a data de saida do veiculo é menor do que a data de início do período
		if (loc.getAnoEntrada() < inicio.getAno() || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() < inicio.getMes()) ||
				(loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() == inicio.getMes() && loc.getDiaEntrada() < inicio.getMes())) {
			if (loc.getAnoSaida() > fim.getAno() || (loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() > fim.getMes()) ||
					(loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() == fim.getMes() && loc.getDiaSaida() > fim.getDia())) {
				return true;
			}
		}
		
		// Verifica se a data de saida do veículo está no meio do período informado
		if (loc.getAnoSaida() > inicio.getAno() || (loc.getAnoSaida() == inicio.getAno() && loc.getMesSaida() > inicio.getMes()) ||
				(loc.getAnoSaida() == inicio.getAno() && loc.getMesSaida() == inicio.getMes() && loc.getDiaSaida() > inicio.getDia())) {
			if (loc.getAnoSaida() < fim.getAno() || (loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() < fim.getMes()) ||
					(loc.getAnoSaida() == fim.getAno() && loc.getMesSaida() == fim.getMes() && loc.getDiaSaida() < fim.getMes())) {
				return true;
			}
		}
		
		// Verifica se a data de entrada do veículo está no meio do período informado
		if (loc.getAnoEntrada() > inicio.getAno() || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() > inicio.getMes()) ||
				(loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() == inicio.getMes() && loc.getDiaEntrada() > inicio.getDia())) {
			if (loc.getAnoEntrada() < fim.getAno() || (loc.getAnoEntrada() == fim.getAno() && loc.getMesEntrada() < fim.getMes()) ||
					(loc.getAnoEntrada() == fim.getAno() && loc.getMesEntrada() == fim.getMes() && loc.getDiaEntrada() < fim.getMes())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificaDiasLocacaoFechada(Locacao loc, Data inicio, Data fim) {
		// Verifica se a data de entrada do veículo está no meio do período informado
		if (loc.getAnoEntrada() > inicio.getAno() || (loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() > inicio.getMes()) ||
				(loc.getAnoEntrada() == inicio.getAno() && loc.getMesEntrada() == inicio.getMes() && loc.getDiaEntrada() > inicio.getDia())) {
			if (loc.getAnoEntrada() < fim.getAno() || (loc.getAnoEntrada() == fim.getAno() && loc.getMesEntrada() < fim.getMes()) ||
					(loc.getAnoEntrada() == fim.getAno() && loc.getMesEntrada() == fim.getMes() && loc.getDiaEntrada() < fim.getMes())) {
				return true;
			}
		}
		return false;
	}
}