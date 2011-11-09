package tdd;

import static org.junit.Assert.assertEquals;

import java.io.Console;
import java.io.IOException;

import modelo.Cliente;

import org.junit.Test;

import persistencia.PersistenciaCliente;

public class TesteCliente {

	@Test
	public void test1() throws IOException {
		System.out.println("Digite alguma coisa");
		int algo = modelo.Console.readInteger();
		System.out.println(algo);
		int dois = 2;
		if (algo == dois) {
			System.out.println("é igual");
		} else {
			System.out.println("não é igual");
		}
		//		PersistenciaCliente pers = new PersistenciaCliente();
//		Cliente cli = new Cliente("fernando", "456");
//		cli.addLocacao(1);
//		cli.addLocacao(2);
//		//pers.salvaCliente(cli);
//		cli = pers.pesquisarCliente("456");
//		System.out.println(cli.getNome());
//		cli = pers.pesquisarCliente("123");
//		System.out.println(cli.getNome());
//		cli = pers.pesquisarCliente("321");
//		System.out.println(cli.getNome());
//		assertEquals("fernando", pers.pesquisarCliente("456").getNome());
//		assertEquals("bruno", pers.pesquisarCliente("123").getNome());
//		assertEquals("iago", pers.pesquisarCliente("321").getNome());
	}
	
//	@Test
//	public void test2() throws IOException {
//		PersistenciaCliente pers = new PersistenciaCliente();
//		pers.deletaCliente("456");
//	}
}
