package br.edu.horus.javabasico2015.controller;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.horus.javabasico2015.Cliente;
import br.edu.horus.javabasico2015.Item;
import br.edu.horus.javabasico2015.Pedido;
import br.edu.horus.javabasico2015.Pessoa;
import br.edu.horus.javabasico2015.ServicoDao;

@Controller
@Path("/pedidos")
public class PedidosController {
	private Result result;
	private ServicoDao servico;
	private Carrinho carrinho;
    private Validator validation;
	
	@Deprecated
	public PedidosController() {}
	
	@Inject
	public PedidosController(
			Carrinho carrinho, 
			ServicoDao servico, 
			Result result, 
			Validator validation){
		this.result = result;
		this.servico = servico;
		this.carrinho = carrinho;
		this.validation = validation;
	}
	
	@Post("/item")
	public void adicionar(@Valid Item item){
		validation.onErrorForwardTo(this).carrinho();
		carrinho.getPedido().adicionar(item);
		result.include("pedido", carrinho.getPedido());
		result.redirectTo(this).carrinho();
	}
	
	
	@Get("/cliente")
	public void cliente(){
		
	}
	
	@Post("/entregar")
	public void entregar(String nome, BigDecimal desconto){
		Pessoa pessoa = new Pessoa(nome);
		Cliente cliente = new Cliente(pessoa, desconto);
		carrinho.getPedido().entregar(cliente);
		servico.salvar(cliente);
		carrinho.getPedido().totalizar();
		servico.salvar(carrinho.getPedido());
		carrinho.limpar();
		result.redirectTo(this).index();
	}
	
	@Delete("/{id}")
	public void remover(Integer id){
		servico.remover(Pedido.class, id);
		result.redirectTo(this).index();
	}

	@Get({"/", ""})
	public void index(){
		result.include("pedidos", servico.buscar(Pedido.class));
	}

	@Get("/{id}")
	public void editar(Integer id){
		result.include("pedido", servico.buscar(Pedido.class, id));
	}
	
	@Get({"/carrinho"})
	public void carrinho(){
		result.include("pedido", carrinho.getPedido());
	}
}
