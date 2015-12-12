package br.edu.horus.javabasico2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentificavelTest {
	Identificavel i = new Identificavel();

	@Test
	public void testIsNull() {
		assertFalse(i.equals(null));
	}

	@Test
	public void testOutroTipo(){
		assertFalse(i.equals("0q9qwyr23y8"));		
	}
	
	@Test
	public void testMesmoObjeto(){
		assertTrue(i.equals(i));		
	}
}
