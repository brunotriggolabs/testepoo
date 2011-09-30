package modelo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

public class PersistenciaLocacao {

	public PersistenciaLocacao() throws IOException  {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	File arquivo = new File ("arquivos/teste.txt");
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter out = new BufferedWriter(fw);

	public void salvar(Locacao locacao) throws IOException{
		//TODO Criar método para salvar em arquivo
		out.write(String.valueOf(locacao.valor));
		out.write(";");
		out.write(locacao.dataSaida.getTime().toString());
		out.write(";");
		out.write(locacao.dataDevolucao.getTime().toString());
		out.write(";");
		out.write(String.valueOf(locacao.kmSaida));
		out.write(";");
		out.write(String.valueOf(locacao.kmEntrada));
		out.write(";");
		out.write(String.valueOf(locacao.previsaoDias));
		out.write(";");
		out.write(String.valueOf(locacao.tipo.precoKm));
		out.write(";");
		out.write(locacao.tipo.tipo);
		out.write(";");
		out.write(String.valueOf(locacao.tipo.taxaBase));
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
		StringTokenizer separador;
		Locacao loc = new Locacao();
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
			separador = new StringTokenizer(conteudoLinha,";");
			if (String.valueOf(locacao.valor).equals(separador.nextToken())){
				System.out.println("Deu certo!");
				return true;
			}
		}
		System.out.println("ERRO!");
		return false;
	}

	public void deletar(Locacao locacao) throws IOException {
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
	}

	protected Calendar stringParaCalendar(String data){
		//de STRING para CALENDAR

		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

		Calendar c = Calendar.getInstance();

		try {

			c.setTime(formatoData.parse(data));

		} catch (Exception e) {}

		return c;

	}
}	
