package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Data;
import modelo.Locacao;
import modelo.TipoLocacao;
import modelo.TipoVeiculo;
import modelo.Veiculo;

public class PersistenciaVeiculo {
	
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/veiculo.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	//Lê no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);
	
	//Construtor Default
	public PersistenciaVeiculo() throws IOException {
	}
	
	public void salvaVeiculo(Veiculo veiculo) throws IOException {
		bw.append(veiculo.getPlaca() + ";" 	+ veiculo.getMarca() + ";" +  veiculo.getModelo() +
				";" + veiculo.getCor() + ";" + veiculo.getTipo() + ";" + veiculo.getObservacoes() 
				 + ";" + veiculo.getOpcionais() + ";" + veiculo.getDisponivel() +"\n");					//Carrega o buff
		bw.flush();																//escrever o buff no arquivo
		bw.close();																//fecha o arquivo
	}
	
	public Veiculo pesquisarVeiculo(Veiculo veiculo) {
		String conateudoLinha = null;
		int linhaAtual = 0;
		String s[];
		Veiculo vec = new Veiculo("x", "y", "z");
		while(true){
			linhaAtual++;
			try {
				conateudoLinha = br.readLine();
			} catch (IOException e) {
				System.out.println("Erro em IOException");
				break;
			}
			if (conateudoLinha == null) {
				System.out.println("Linha vazia!");
				break;
			}
			s = conateudoLinha.split("\\;");
			vec = converteOriginal(s);
			if (vec.equals(veiculo)){
				System.out.println("Encontrado!");
				return vec;
			}else {
				System.out.println("Não encontrado!");
				return null;
			}
		}
		return null;
	}
	
	
	private Veiculo converteOriginal (String s[]) {		
		Veiculo vec = new Veiculo(s[0], s[1], s[2]);
		vec.setCor(s[3]);
		vec.setTipo(s[4]);
		vec.setObservacoes(s[5]);
		vec.setOpicionais(s[6]);
		vec.setDisponivel(Integer.valueOf(s[7]));
		
		return vec;
	}
	
	public boolean deletaVeiculo(Veiculo veiculo) {
		//TODO implementar a deleção do veiculo
		return false;
	}
}
