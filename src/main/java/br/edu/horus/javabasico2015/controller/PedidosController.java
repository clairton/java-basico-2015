package br.edu.horus.javabasico2015.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.horus.javabasico2015.Item;
import br.edu.horus.javabasico2015.Pedido;
import br.edu.horus.javabasico2015.ServicoDao;

@Controller
@Path("/pedidos")
public class PedidosController {
	private Result result;
	private ServicoDao servico;
	
	@Deprecated
	public PedidosController() {}
	
	@Inject
	public PedidosController(ServicoDao servico, Result result){
		this.result = result;
		this.servico = servico;
	}
	
	
	@Get({"/", ""})
	public void index(){
		result.include("pedidos", servico.buscar(Pedido.class));
	}

	@Get("/{id}")
	public void editar(Integer id){
		result.include("pedido", servico.buscar(Pedido.class, id));
	}
	
	@Get({"/novo"})
	public void novo(){
		Pedido pedido = new Pedido();
		pedido.adicionar(new Item("Banana", 5.0));
		servico.salvar(pedido);
		result.redirectTo(this).editar(pedido.getId());
	}
	
}
