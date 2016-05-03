package br.edu.horus.javabasico2015.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.edu.horus.javabasico2015.Pedido;

@Controller
public class PedidosController {
	
	
	public List<Pedido> list(){
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(new Pedido());
		return pedidos;
	}
//	private ServicoDao servico;
//	private Result result;
//	
//	@Deprecated
//	public PedidosController() {}
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
