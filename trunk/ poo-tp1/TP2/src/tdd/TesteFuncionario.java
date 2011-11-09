package tdd;

import static org.junit.Assert.*;

import java.io.IOException;

import modelo.Funcionario;

import org.junit.Test;

import persistencia.PersistenciaFuncionario;;

public class TesteFuncionario {

	@Test
	public void test() throws IOException {
		PersistenciaFuncionario pers = new PersistenciaFuncionario();
		Funcionario fun = new Funcionario("Iago", "456", "CRC");
		assertEquals(null, pers.pesquisarFuncionario("1234"));
		assertEquals("Iago", pers.pesquisarFuncionario("456").getNome());
		pers.salvaFuncionario(fun);
		//assertEquals("Iago", pers.pesquisarFuncionario("10970173628").getNome());
		//pers.deletaFuncionario("321");
	}
}