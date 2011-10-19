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
	
	
	//DeclaraÃ§Ã£o do aquivo 	
	File arquivo = new File ("arquivos/veiculo.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

	//LÃª no arquivo
	FileReader fr = new FileReader(arquivo);
	BufferedReader br = new BufferedReader(fr);
	
	//Construtor Default
	public PersistenciaVeiculo() throws IOException {
	}
	
	public void salvaVeiculo(Veiculo veiculo) throws IOException {
		bw.append(veiculo.getPlaca() + ";" 	+ veiculo.getMarca() + ";" +  veiculo.getModelo() +
				";" + veiculo.getCor() + ";" + veiculo.getTipo() + ";" + veiculo.getOpicionais() + ";" + veiculo.getDisponivel() +
				";" + String.valueOf(veiculo.getLocacao()) + ";" + veiculo.getObservacoes() + "\n");	//Carrega o buff
		bw.flush();																									//escrever o buff no arquivo
		bw.close();																									//fecha o arquivo
	}
	
	public Veiculo pesquisarVeiculo(String placa) {
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
			if (vec.getPlaca().equals(placa)) {
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
		String s0 = s[0]; // PLACA
		String s1 = s[1]; // MARCA
		String s2 = s[2]; // MODELO
		String s3 = s[3]; // COR
		String s4 = s[4]; // TIPO
		String s5 = s[5]; // OPCIONAIS
		if (s[6] != null) {
			int s6 = Integer.parseInt(s[6]); // DISPONÍVEL
		} else {
			int s6 = 0;
		}
		int s7 = Integer.parseInt(s[7]); // LOCAÇÃO
		String s8 = s[8]; // OBSERVAÇÕES
		
		Veiculo vec = new Veiculo(s0, s1, s2);
		vec.setCor(s3);
		vec.setTipo(s4);
		vec.setOpicionais(s5);
		vec.setObservacoes(s8);
		return vec;
	}
	
	public boolean deletaVeiculo(Veiculo veiculo) {
		//TODO implementar a deleÃ§Ã£o do veiculo
		return false;
	}
}
