package tdd;

import static org.junit.Assert.*;

import java.io.IOException;

import modelo.Cliente;
import modelo.Veiculo;

import org.junit.Test;

import persistencia.PersistenciaCliente;
import persistencia.PersistenciaVeiculo;

public class TesteCliente {

	@Test
	public void test() throws IOException {
		PersistenciaCliente pers = new PersistenciaCliente();
		Cliente cli = new Cliente("bruno", "1231543");
		pers.salvaCliente(cli);
		assertEquals("bruno", pers.pesquisarCliente("1231543").getNome());
	}

}
