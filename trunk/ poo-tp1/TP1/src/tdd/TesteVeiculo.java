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
		Veiculo vec = new Veiculo("gkr 2712", "Gol", "bolinha");
		pers.salvaVeiculo(vec);
		assertEquals("bolinha", pers.pesquisarVeiculo("gkr 2712").getModelo());
	}
}
