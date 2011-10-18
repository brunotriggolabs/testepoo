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