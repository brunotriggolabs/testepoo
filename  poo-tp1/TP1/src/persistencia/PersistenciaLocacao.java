package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import modelo.Locacao;

public class PersistenciaLocacao  {

	public PersistenciaLocacao() throws IOException {
	}	

	public File arquivo = new File ("arquivos/Locacao.txt");
	public FileWriter fw = new FileWriter(arquivo,true);
	public BufferedWriter out = new BufferedWriter(fw);

	public void salvar(Locacao locacao)throws IOException {
		out.write(String.valueOf(Locacao.numLocacoes));
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
		out.write("\n");
		out.flush();
		out.close();

	}

	public Locacao pesquisar(int id) throws IOException{
		String conteudoLinha = null;
		int linhaAtual = 0;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		while(true){
			linhaAtual++;
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
		int linhaAtual = 0;
	 	String s[];
		Locacao loc = new Locacao(5, 2, 3);
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/locacaoTemp.txt");
		FileWriter fwTemp = new FileWriter(novo,true);
		BufferedWriter bwTemp = new BufferedWriter(fwTemp);
		while(true) {
			linhaAtual++;
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
				System.out.println("Funcionário deletado do registro");
			} else {
				bwTemp.write(String.valueOf(Locacao.numLocacoes));
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
				bwTemp.write("\n");								//Carrega o buff
			}
		}
		bwTemp.flush();			//escrever o buff no arquivo
		bwTemp.close();		//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/Locacao.txt"));  
	}
	
	private Locacao converteOriginal (String s[]) {
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
		loc.setAlugado(Boolean.parseBoolean(s[13]));
		loc.setFinalizado(Boolean.parseBoolean(s[14]));
		return loc;
	}

	public double pesquisaPrecoFinalizado () throws FileNotFoundException{
		String conteudoLinha = null;
		int linhaAtual = 0;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		double resultado = 0;
		while(true){
			linhaAtual++;
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conteudoLinha == null) {
				System.out.println("Linha vazia!");
				break;
			}
			s = conteudoLinha.split("\\;");
			if (s[14] == "true"){
				resultado = resultado + loc.getPreco();
			}
			return resultado;
		}
		return 0;
	}

	public double pesquisaLocacoesEmAberto () throws FileNotFoundException {
		String conteudoLinha = null;
		int linhaAtual = 0;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Locacao loc = new Locacao(1, 1);
		double resultado = 0;
		while(true){
			linhaAtual++;
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			s = conteudoLinha.split("\\;");
			if (s[13] == "true" && verificaDias(loc,s)){
				resultado = resultado + loc.getPreco();
			}
		}
		return resultado;
	}

	@SuppressWarnings("deprecation")
	private boolean verificaDias(Locacao loc,String s[]) {
		int diaAtual = new Date().getDate();
		int mesAtual = new Date().getMonth();
		int anoAtual = new Date().getYear();
		loc.setDiaEntrada(Integer.valueOf(s[2]));
		loc.setMesEntrada(Integer.valueOf(s[3]));
		loc.setAnoEntrada(Integer.valueOf(s[4]));

		if (anoAtual < loc.getAnoEntrada()) {
			return false;
		}else if (loc.getMesEntrada() < mesAtual) {
			return false;
		} else if (loc.getDiaEntrada() < diaAtual){
			return false;
		}
		return true;
	}
}