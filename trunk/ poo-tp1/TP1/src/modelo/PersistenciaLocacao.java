package modelo;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.nio.CharBuffer;

public class PersistenciaLocacao {

	public PersistenciaLocacao() throws IOException {

	}
	File arquivo = new File ("/home/brunomrkta/Dropbox/UFSJ/Estudo_Java/workspace/TrabalhoPratico1/arquivos/teste.txt");
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter out = new BufferedWriter(fw);

	public void salvar(Locacao locacao) throws IOException{
		//TODO Criar método para salvar em arquivo
		out.write(locacao.valor.intValue());
		out.write(";");
		out.write(locacao.dataSaida.toString());
		out.write(";");
		out.write(locacao.dataDevolucao.toString());
		out.write(";");
		out.write((int)locacao.kmSaida);
		out.write(";");
		out.write((int)locacao.kmEntrada);
		out.write("\n");
		out.flush();
		out.close();
	}
	
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);

	public boolean pesquisar(String busca) throws IOException{
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
			if (conteudoLinha.indexOf(busca) != -1) {
				separador = new StringTokenizer(conteudoLinha, ";");
/*				loc.valor = new BigDecimal(separador.nextToken());
				loc.dataSaida = separador.nextToken();
				loc.dataDevolucao = separador.nextToken();
				loc.kmEntrada = separador.nextToken();
				loc.kmSaida = separador.nextToken();
*/				
				System.out.println("Encontrado na linha: " + linhaAtual + " String = " + conteudoLinha);
				return true;
			} else {
				System.out.println("NÃO ENCONTRADO!");
				break;
			}		
		}
		return false;
//		StringTokenizer token = new StringTokenizer("");
	}

	public void deletar(String busca) throws IOException {
		String conteudoLinha = null;
		int linhaAtual = 0;
		while(true){
			
			
		}
	}

	public void obterLista(){
		//TODO Obtem lista de alguma coisa
	}
}	
