package br.edu.horus.javabasico2015.controller;

import java.util.Locale;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;

@Specializes
@Convert(Double.class)
public class DoubleConverter extends br.com.caelum.vraptor.converter.DoubleConverter{

	@Deprecated
	public DoubleConverter() {
		this(null);
	}

	@Inject
	public DoubleConverter(Locale locale) {
		super(locale);
	}
	
	
	@Override
	public Double convert(String value, Class<? extends Double> type) {
		if(value == null || value.isEmpty()){
			value = "0.00";
		}
		value = value.replaceAll("\\.", "").replaceAll(",", ".");
		return Double.valueOf(value);
	}
	
}
