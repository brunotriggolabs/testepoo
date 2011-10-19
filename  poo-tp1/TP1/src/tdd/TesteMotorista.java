package tdd;

import static org.junit.Assert.*;

import java.io.IOException;

import modelo.Motorista;

import org.junit.Test;

import persistencia.PersistenciaLocacao;
import persistencia.PersistenciaMotorista;

public class TesteMotorista {

	@Test
	public void test() throws IOException {
		PersistenciaMotorista pers = new PersistenciaMotorista();
		Motorista mot = new Motorista("Bruno", "10981732617", "123");
		pers.salvaMotorista(mot);
		assertEquals("Bruno", pers.pesquisarMotorista("10981732617").getNome());
	}
}
