package visao;
import modelo.*;
import persistencia.*;

public class Locarrao {
	
private static String lerCpf;
private static String lerModelo;
private static int lerTipoLocacao;
private static String lerMotorista;
static final Console con = null;

private static void lerValores (){
	System.out.println("Escolha o modelo do carro");
	lerModelo = con.readString();
	System.out.println("Escolhe o tipo da locação [1 - por KM , 2 - KM livre]");
	lerTipoLocacao = con.readInteger();
	System.out.println("Você será o motorista do carro?");
	lerMotorista = con.readString();
	if (lerMotorista == "Sim" || lerMotorista == "sim" || lerMotorista == "S" || lerMotorista == "s"){
		//TODO realizar cadastro do cliente-motorista
	} else {
		//TODO Realiza cadastro motorista
	}	
}
private static boolean verificaCpf (String cpf){
	//Verifica CPF no arquivo
	
	return true;
}

private static double calculoPreco (TipoVeiculo tipov,Locacao loc,TipoLocacao tipo) {
	final double p;
	loc.setAlugado(false);
	if (tipo.getTipo().equals("porKm")){
		p = (loc.getKmSaida() - loc.getKmEntrada()) + tipov.getTaxaBase()  /*Quantos dias usou*/;
		loc.setPreco(p);
		return loc.getPreco();
	}else{
		loc.setPreco(tipov.getTaxaBase() * /*Quantos dias usou*/);
		return loc.getPreco();
	}
}

private static double receitaEsperada(Data dia,Locacao locacao) {
	//TODO pegar período desejado
	double precoTotal = 0.0;
	if (arquivo.pesquisar (locacao)) {
		if ((dia.getDia() <= locacao.getDataDevolucao().getDia()) && (dia.getMes() <= locacao.getDataDevolucao().getMes())){
			if (locacao.isAlugado()) {
				precoTotal = precoTotal + locacao.getPreco();
			}
		}
	}
	return precoTotal;
}
//TODO ver sobre realatório.
	public static void main(String[] args) {

		System.out.println("********----------LOCARRÃO RENT-A-CAR----------********");
		System.out.println("Verificando se já está cadastrado:");
		System.out.println("Digite seu CPF");
		lerCpf = con.readString();
		//TODO criar método para verificar o CPF
		/*if (verificaCpf == false){
			//TODO realiza cadastro
		}*/
		System.out.println("Devolução:");
		
		
	}
}