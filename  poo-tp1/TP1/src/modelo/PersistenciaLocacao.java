package modelo;

import java.io.*;
import java.nio.CharBuffer;

public class PersistenciaLocacao {

	public PersistenciaLocacao() throws IOException {

	}
	File arquivo = new File ("/home/samuel/Faculdade/POO/Workspace/TrabalhoPratico1/arquivos/teste.txt");
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter out = new BufferedWriter(fw);

	public void salvar(String texto) throws IOException{
		//TODO Criar método para salvar em arquivo
		out.write("\t");
		out.write(texto);
		out.flush();
		out.close();
	}

	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);

	public boolean pesquisar(String busca) throws IOException{
		//TODO Criar método para pesquisa em arquivo
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
			if (conteudoLinha.indexOf(busca) != -1) {
				System.out.println("Encontrado na linha: " + linhaAtual);
				return true;
			} else {
				System.out.println("NÃO ENCONTRADO!");
				break;
			}		
		}
		return false;
		
	}

	public void deletar(){
		//TODO Método para deletar no arquivo
	}

	public void obterLista(){
		//TODO Obtem lista de alguma coisa
	}
}	
