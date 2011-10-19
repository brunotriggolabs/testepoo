package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Locacao;
import modelo.Motorista;
import modelo.TipoLocacao;
import modelo.TipoVeiculo;

public class PersistenciaTipoVeiculo {

	public PersistenciaTipoVeiculo() throws IOException{
	}
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/tipoVeiculo.txt");
	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);
	//Lê no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);
	
	public void salvaTipoVeiculo(TipoVeiculo tipo) throws IOException {
		bw.append(tipo.getTipo() + ";" + tipo.getPrecokm() + ";" + tipo.getTaxaBase() + "\n");
		bw.flush();
		bw.close();
	}
	
	public TipoLocacao pesquisarTipoLocacao(int tipo) throws IOException {
		String conateudoLinha = null;
		String s[];	 	
	 	FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
	 	TipoLocacao tipoLoc = new TipoLocacao("a", 1.0, 1.0);
		while(true) {
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Tipo de Locacao não encontrado.");
				br.close();
				return null;
			}
			s = conateudoLinha.split("\\;");
			tipoLoc = converteOriginal(s);
			if (tipoLoc.getTipo().equals(tipo)){
				System.out.println("Encontrado!");
				br.close();
				return tipoLoc;
			}
		}
		return null;
	}
	
	private TipoLocacao converteOriginal (String s[]) {
		double precoKm = Double.parseDouble(s[8]);
		double taxa = Double.parseDouble(s[11]);
		TipoLocacao tipoLoc = new TipoLocacao(s[0], taxa, precoKm);
		
		return tipoLoc;
	}
	
	public boolean deletaTipoVeiculo(TipoVeiculo tipo) {
		
		return false;
	}
}
