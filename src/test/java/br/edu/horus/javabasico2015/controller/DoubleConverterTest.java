package br.edu.horus.javabasico2015.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.vraptor.converter.Converter;

public class DoubleConverterTest {
	Converter<Double> converte = new DoubleConverter();
	
	@Test
	public void testConvertStringClassOfQextendsDouble() {
		assertEquals(Double.valueOf(0.10), converte.convert("0,10", Double.class));
		assertEquals(Double.valueOf(0.15), converte.convert("0,15", Double.class));
		assertEquals(Double.valueOf(1000.11), converte.convert("1.000,11", Double.class));
		assertEquals(Double.valueOf(0.00), converte.convert(null, Double.class));
	}

}
