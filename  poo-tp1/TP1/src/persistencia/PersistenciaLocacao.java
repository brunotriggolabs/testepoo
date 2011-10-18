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

	public void salvar(Locacao locacao) throws IOException{
		out.write(String.valueOf(locacao.getValor()));
		out.write(";");
		out.write(locacao.getDataSaida().getDia());
		out.write(";");
		out.write(locacao.getDataSaida().getMes());
		out.write(";");
		out.write(locacao.getDataSaida().getAno());
		out.write(";");
		out.write(locacao.getDataDevolucao().getDia());
		out.write(";");
		out.write(locacao.getDataDevolucao().getMes());
		out.write(";");
		out.write(locacao.getDataDevolucao().getAno());
		out.write(";");
		out.write(String.valueOf(locacao.getKmSaida()));
		out.write(";");
		out.write(String.valueOf(locacao.getKmEntrada()));
		out.write(";");
		out.write(String.valueOf(locacao.getPrevisaoDias()));
		out.write(";");
		out.write(String.valueOf(locacao.getTipo().getPrecoKm()));
		out.write(";");
		out.write(locacao.getTipo().getTipo());
		out.write(";");
		out.write(String.valueOf(locacao.getTipo().getTaxaBase()));
		out.write(";");
		out.write(String.valueOf(locacao.getPreco()));
		out.write("\n");
		out.flush();
		out.close();
	}

	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);

	public boolean pesquisar(Locacao locacao) throws IOException{
		//TODO Criar método para pesquisa em arquivo
		String conteudoLinha = null;
		int linhaAtual = 0;
		String s[];
		Locacao loc = new Locacao();
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
			if (converteOriginal(s, loc).equals(locacao)){
				System.out.println("Encontrado!");
				return true;
			}else {
				System.out.println("Não encontrado!");
				return false;
			}
		}
		return false;
	}
	
	private Locacao converteOriginal (String s[],Locacao loc) {
		TipoLocacao tipo = loc.getTipoLocacao();		
		loc.setValor(Double.parseDouble(s[0]));
		Data data = new Data();
		data.setDia(Integer.valueOf(s[1]));
		data.setMes(Integer.valueOf(s[2]));
		data.setAno(Integer.valueOf(s[3]));
		loc.setDataSaida(data);  //setDataSaida.(formatador.parse(s[1]));//Dia
		data.setDia(Integer.valueOf(s[4]));
		data.setMes(Integer.valueOf(s[5]));
		data.setAno(Integer.valueOf(s[6]));
		loc.setDataDevolucao(data);//Mes
		loc.setKmSaida(Double.parseDouble(s[7]));
		loc.setKmEntrada(Double.parseDouble(s[8]));
		loc.setPrevisaoDias(Integer.parseInt(s[9]));
		tipo.setPrecoKm(Double.parseDouble(s[10]));
		tipo.setTipo(s[11]);
		tipo.setTaxaBase(Double.parseDouble(s[12]));
		loc.setTipo(tipo);
		loc.setPreco(Double.parseDouble(s[13]));
		
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