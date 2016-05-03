package br.edu.horus.javabasico2015.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class TestController {
	@Inject
	private Result result;

	@Get
	public void index(){
		result.use(Results.json()).from("estou aqui").serialize();
	}
}
