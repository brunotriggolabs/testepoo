package tdd;

import static org.junit.Assert.*;

import java.io.IOException;

import modelo.Motorista;

import org.junit.Test;

import persistencia.PersistenciaMotorista;

public class TesteMotorista {

	@Test
	public void test() throws IOException {
		PersistenciaMotorista pers = new PersistenciaMotorista();
		Motorista mot = new Motorista("Iago", "10970173628", "cnh");
		pers.salvaMotorista(mot);
		assertEquals("cnh", pers.pesquisarMotorista("10970173628").getCnh());
		assertEquals("Bruno", pers.pesquisarMotorista("10981732617").getNome());
		assertEquals("cnh", pers.pesquisarMotorista("10970173628").getCnh());
		pers.deletaMotorista("10970173628");
	}
}
