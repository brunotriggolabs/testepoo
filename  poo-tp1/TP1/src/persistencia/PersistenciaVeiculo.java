package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.Veiculo;

public class PersistenciaVeiculo {
	
	//Declaração do aquivo 	
	File arquivo = new File ("arquivos/veiculo.txt");

	//Escrever no arquivo
	FileWriter fw = new FileWriter(arquivo,true);
	BufferedWriter bw = new BufferedWriter(fw);

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
	
	public Veiculo pesquisarVeiculo(String placa) throws FileNotFoundException {
		String conateudoLinha = null;
		int linhaAtual = 0;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
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
				System.out.println("Veículo não encontrado!");
				return null;
			}
			s = conateudoLinha.split("\\;");
			vec = converteOriginal(s);
			if (vec.getPlaca().equals(placa)) {
				System.out.println("Encontrado!");
				return vec;
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
		int s6;
		if (s[6] != null) {
			s6 = Integer.parseInt(s[6]); // DISPON�VEL
		} else {
			s6 = 0;
		}
		int s7 = Integer.parseInt(s[7]); // LOCA��O
		String s8 = s[8]; // OBSERVA��ES
		
		Veiculo vec = new Veiculo(s0, s1, s2);
		vec.setCor(s3);
		vec.setTipo(s4);
		vec.setOpicionais(s5);
		vec.setDisponivel(s6);
		vec.setLocacao(s7);
		vec.setObservacoes(s8);
		return vec;
	}
	
	public void deletaVeiculo(String placa) throws IOException {
		String conateudoLinha = null;
	 	String s[];
		Veiculo vec = new Veiculo("a", "b", "c");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File novo = new File("arquivos/veiculoTemp.txt");
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
			vec = converteOriginal(s);
			if (vec.getPlaca().equals(placa)){
				System.out.println("Veículo deletado do registro");
			} else {
				bwTemp.append(vec.getPlaca() + ";" 	+ vec.getMarca() + ";" +  vec.getModelo() +
						";" + vec.getCor() + ";" + vec.getTipo() + ";" + vec.getOpicionais() + ";" + vec.getDisponivel() +
						";" + String.valueOf(vec.getLocacao()) + ";" + vec.getObservacoes() + "\n");		
			}
		}
		bwTemp.flush();														//escrever o buff no arquivo
		bwTemp.close();														//fecha o arquivo
		arquivo.delete();
		novo.renameTo(new File("arquivos/veiculo.txt"));  
	}
	
	public void pesquisarDisponivel() throws FileNotFoundException {
		String conateudoLinha = null;
		String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		Veiculo vec = new Veiculo("x", "y", "z");
		System.out.print("Veículos disponíveis:");
		while(true){
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
			vec = converteOriginal(s);
			if (vec.getDisponivel() == 1) {
				System.out.print(" " + vec.getPlaca());
			}
		}
		System.out.println();
	}
	
	public int contaVeiculos() throws FileNotFoundException {
		String conateudoLinha = null;
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		int contador = 0;
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
			contador++;
		}
		return contador;
	}
	
	public Veiculo[] montaVetorVeiculos(int quantidade) throws FileNotFoundException {
		String conateudoLinha = null;
		Veiculo vetor[] = new Veiculo[quantidade];
		Veiculo vec;
	 	String s[];
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		int linhaAtual = -1;
		while(true) {
			linhaAtual++;
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
			vec = converteOriginal(s);
			vetor[linhaAtual] = vec;
		}
		return vetor;
	}
	
	public boolean aluga(String placa) throws FileNotFoundException {
		Veiculo veiculo = pesquisarVeiculo(placa);
		if (veiculo.getDisponivel() == 1) {
			veiculo.setDisponivel(0);
			return true;
		}
		return false;
	}
	
	public boolean veiculoDisponivel(String placa) throws FileNotFoundException {
		Veiculo vec = new Veiculo("placa", "placa", "placa");
		vec = pesquisarVeiculo(placa);
		int i = vec.getDisponivel();
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
}
