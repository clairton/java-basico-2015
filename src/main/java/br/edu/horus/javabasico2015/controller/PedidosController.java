package br.edu.horus.javabasico2015.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.horus.javabasico2015.Cliente;
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
		List<?> pedidos = Arrays.asList(new Pedido(new Cliente()));
		result.include("pedidos", pedidos);
	}
//	private Result result;
//	

//	
//	@Inject
//	public PedidosController(ServicoDao servico, Result result){
//		this.servico = servico;
//		this.result = result;
//	}
//	
//	@Get({"/", ""})
//	public void index(){
//		Collection<Pedido> pedidos = servico.buscar(Pedido.class);
//		result.include("pedidos", pedidos);
//	}
//
//	@Post({"/", ""})
//	public void novo(){
//		Pessoa pessoa = new PessoaFisica("", LocalDate.now());
//		Cliente cliente = new Cliente(pessoa);
//		Pedido pedido = new Pedido(cliente);
//	}
	
}
