package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public boolean pesquisaTipoVeiculo(TipoVeiculo tipo) {
		//TODO implementar a pesquisa
		return false;
	}
	
	public boolean deletaTipoVeiculo(TipoVeiculo tipo) {
		//TODO implementar a deleção do TipoVeiculo
		return false;
	}
}
