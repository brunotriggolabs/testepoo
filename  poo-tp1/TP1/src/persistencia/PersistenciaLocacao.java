package persistencia;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import modelo.Data;
import modelo.Locacao;
import modelo.TipoLocacao;


public class PersistenciaLocacao { 

	public PersistenciaLocacao() throws IOException{
			
	}
	
	File arquivo = new File ("arquivos/Locacao.txt");
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter out = new BufferedWriter(fw);
	
	public void salvar(Locacao locacao) throws IOException {
		out.write(String.valueOf(locacao.numLocacoes));
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
		out.write("\n");
		out.flush();
		out.close();
	}

	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);

	public Locacao pesquisar(int id) throws IOException{
		TipoLocacao tipo = new TipoLocacao();
		String conteudoLinha = null;
		int linhaAtual = 0;
		String s[];
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
				System.out.println("Linha vazia!");
				break;
			}
			s = conteudoLinha.split("\\;");
			loc = converteOriginal(s);
			if (loc.getId() == id) {
				System.out.println("Encontrado!");
				return loc;
			}else {
				System.out.println("Não encontrado!");
				return null;
			}
		}
		return null;
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
		return loc;
	}

/*	public void deletar(Locacao locacao) throws IOException {
		String conteudoLinha = null;
		int linhaAtual = 0;
		while(true){
			linhaAtual++;
			try {
				conteudoLinha = br.readLine();
			} catch (IOException e) {
				break;
			}
			if (conteudoLinha == null) {
				break;
			}
			if (conteudoLinha.equals(locacao)) {
				System.out.println("Encontrado na linha: " + linhaAtual + " String = " + conteudoLinha);
			} else {
				System.out.println("NÃO ENCONTRADO!");
				break;
			}
		}
	}

	public void obterLista(){
		//TODO Obtem lista de alguma coisa
	}*/

	protected Calendar stringParaCalendar(String data){
		//de STRING para CALENDAR

		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

		Calendar c = Calendar.getInstance();

		try {

			c.setTime(formatoData.parse(data));

		} catch (Exception e) {
			System.out.println("Erro na conversão de String para Calendar!");
		}

		return c;

	}
}