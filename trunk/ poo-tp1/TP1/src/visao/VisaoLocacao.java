package visao;

import java.io.IOException;
import modelo.Cliente;
import modelo.Console;
import modelo.Locacao;
import persistencia.PersistenciaCliente;
import persistencia.PersistenciaLocacao;

public class VisaoLocacao {
	
	private static boolean checaCpf(String cpf)throws IOException {
		String lerCpf;
		PersistenciaCliente arquivoCliente = new PersistenciaCliente();
		System.out.println("Verificando se já está cadastrado:");
		System.out.println("Digite seu CPF:");
		lerCpf = Console.readString();
		if (arquivoCliente.pesquisarCliente(lerCpf) == null){
			System.out.println("Realizando Cadastro:");
			System.out.println("Digite o seu nome:");
			Cliente cliente = new Cliente(Console.readString(), lerCpf);
			arquivoCliente.salvaCliente(cliente);
			return false;
		} else {
			System.out.println("Cliente já cadastrado!");
			return true;
		}
	}
	
	public int cadastraLocacao() throws IOException{
		String lerCpf;
		int menu;
		System.out.println("Digite seu CPF:");
		lerCpf = Console.readString();
		if(!checaCpf(lerCpf)){
			System.out.println("Digite a Km de Saida,Tipo da Locacao(por Km ou Km livre) e a previsão de dias da locacao.");
			Locacao locacao = new Locacao(Console.readInteger(), Console.readInteger(), Console.readInteger());
			PersistenciaLocacao arquivoLocacao = new PersistenciaLocacao();
			arquivoLocacao.salvar(locacao);
			return menu = Locarrao.escolhaMenu();
		}else return 0;		
	}
}