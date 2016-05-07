package br.edu.horus.javabasico2015.controller;

import java.math.BigDecimal;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.horus.javabasico2015.Carrinho;
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
	
	@Deprecated
	public PedidosController() {}
	
	@Inject
	public PedidosController(Carrinho carrinho, ServicoDao servico, Result result){
		this.result = result;
		this.servico = servico;
		this.carrinho = carrinho;
	}
	
	@Post("/item")
	public void adicionar(Item item){
		carrinho.adicionar(item);
		result.redirectTo(this).carrinho();
	}

	@Delete("/item")
	public void devolver(Item item){
		carrinho.getPedido().remover(item);
		servico.salvar(carrinho.getPedido());
		result.include("pedido", carrinho.getPedido());
	}

	@Delete("/{id}")
	public void remover(Integer id){
		Pedido pedido = servico.buscar(Pedido.class, id);
		servico.remover(pedido);
		result.redirectTo(this).index();
	}
	
	@Get({"/", ""})
	public void index(){
		result.include("pedidos", servico.buscar(Pedido.class));
	}

	@Get("/{id}")
	public void editar(Integer id){
		Pedido pedido = servico.buscar(Pedido.class, id);		
		carrinho.setPedido(pedido);
		result.redirectTo(this).carrinho();
	}
	
	@Get({"/carrinho"})
	public void carrinho(){
		result.include("pedido", carrinho.getPedido());
	}

	@Get({"/cliente"})
	public void cliente(){
	}	

	@Post({"/entregar"})
	public void entregar(String nome, BigDecimal desconto){
		Cliente cliente = new Cliente(new Pessoa(nome), desconto);
		carrinho.getPedido().entregar(cliente);
		servico.salvar(carrinho.getPedido().getCliente());
		servico.salvar(carrinho.getPedido());
		carrinho.limpar();
		result.redirectTo(this).index();
	}
}
