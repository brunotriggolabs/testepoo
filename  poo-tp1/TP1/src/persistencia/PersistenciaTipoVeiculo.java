package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public TipoVeiculo pesquisarTipoVeiculo(String tipo) throws IOException{
		String conateudoLinha = null;
		String s[];	 	
	 	FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
	 	TipoVeiculo tipoVei = new TipoVeiculo("", 0.0, 0.0);
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
			tipoVei = converteOriginalTipoVeiculo(s);
			if (tipoVei.getTipo().equals(tipo)){
				System.out.println("Encontrado!");
				br.close();
				return tipoVei;
			}
		}
		return null;
	}
	
	public TipoVeiculo converteOriginalTipoVeiculo(String s[]){
		String tipo = s[0];
		double precoKm = Double.parseDouble(s[1]);
		double taxaBase = Double.parseDouble(s[2]);
		TipoVeiculo tipoVei = new TipoVeiculo(tipo, precoKm, taxaBase);
		return tipoVei;
	}
	
	public void deletaTipoVeiculo(String tipo) throws IOException {
		String conateudoLinha = null;
		String s[];
		TipoVeiculo tipoVeiculo = new TipoVeiculo("tipo", 2, 3);
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/tipoVeiculoTemp.txt");
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
			tipoVeiculo = converteOriginal(s);
			if (tipoVeiculo.getTipo().equals(tipo)){
				System.out.println("Motorista deletado do registro");
			} else {
				bwTemp.append(tipoVeiculo.getTipo() + ";" + tipoVeiculo.getPrecokm() + ";" + tipoVeiculo.getTaxaBase() + "\n");			
			}
		}
		bwTemp.flush();														//escrever o buff no arquivo
		bwTemp.close();														//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/tipoVeiculo.txt"));  
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
			tipoLoc = converteOriginalLoc(s);
			if (tipoLoc.getTipo().equals(tipo)){
				System.out.println("Encontrado!");
				br.close();
				return tipoLoc;
			}
		}
		return null;
	}
	
	private TipoVeiculo converteOriginal (String s[]) {		
		String s0 = s[0]; // TIPO
		double s1 = Double.parseDouble(s[1]); // PRECOKM
		double s2 = Double.parseDouble(s[2]); // TAXABASE
		TipoVeiculo tipo = new TipoVeiculo(s0, s1, s2);
		return tipo;
	}
	
	private TipoLocacao converteOriginalLoc (String s[]) {		
		String s0 = s[0]; // TIPO
		double s1 = Double.parseDouble(s[1]); // PRECOKM
		double s2 = Double.parseDouble(s[2]); // TAXABASE
		TipoLocacao tipo = new TipoLocacao(s0, s1, s2);
		return tipo;
	}
}
