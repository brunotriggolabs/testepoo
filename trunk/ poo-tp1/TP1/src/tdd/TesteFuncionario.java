package tdd;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import modelo.Funcionario;

import org.junit.Test;

import persistencia.PersistenciaFuncionario;;

public class TesteFuncionario {

	
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws IOException {
		PersistenciaFuncionario pers = new PersistenciaFuncionario();
		Funcionario fun = new Funcionario("Iago", "10970173628", "Gerente do CRC");
		pers.salvaFuncionario(fun);
		assertEquals("Iago", pers.pesquisarFuncionario("10970173628").getNome());	
	}
}