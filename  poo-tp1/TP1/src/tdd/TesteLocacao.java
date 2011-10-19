package tdd;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import modelo.Locacao;

import org.junit.Test;

import persistencia.PersistenciaLocacao;

public class TesteLocacao {

	
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws IOException {
		PersistenciaLocacao pers = new PersistenciaLocacao();
		Locacao loc = new Locacao(20, 1);
		loc.setId(50);
		//pers.salvar(loc);
		pers.deletaLocacao(2);
	}
}
