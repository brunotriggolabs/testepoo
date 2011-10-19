package tdd;

import static org.junit.Assert.*;

import java.io.IOException;


import modelo.Locacao;

import org.junit.Test;

import persistencia.PersistenciaLocacao;

public class TesteLocacao {
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws IOException {
		Locacao.numLocacoes = 8;
		PersistenciaLocacao pers = new PersistenciaLocacao();
		Locacao loc = new Locacao(20, 1);
		pers.salvar(loc);
		pers.salvar(loc);
		//pers.salvar(loc);
		//pers.salvar(loc);
//		pers.deletaLocacao(2);
//		pers.deletaLocacao(1);
//		pers.deletaLocacao(4);
	}
}
