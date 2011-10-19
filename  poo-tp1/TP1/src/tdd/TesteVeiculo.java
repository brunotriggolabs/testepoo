package tdd;

import static org.junit.Assert.*;

import java.io.IOException;

import modelo.Veiculo;

import org.junit.Test;

import persistencia.PersistenciaVeiculo;

public class TesteVeiculo {
	@Test
	public void test() throws IOException {
		PersistenciaVeiculo pers = new PersistenciaVeiculo();
		Veiculo vec = new Veiculo("gtk 2988", "Fusca", "2001");
		vec.setCor("vermelho");
		//pers.salvaVeiculo(vec);
		assertEquals("vermelho", pers.pesquisarVeiculo("gtk 2987").getCor());
		assertEquals("2001", pers.pesquisarVeiculo("gtk 2988").getModelo());
		assertEquals("vermelho", pers.pesquisarVeiculo("gtk 2987").getCor());
		pers.deletaVeiculo("gtk 2988");
		pers.deletaVeiculo("gtk 2990");
		pers.deletaVeiculo("gtk 29");
		
	}
}
