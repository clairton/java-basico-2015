package br.edu.horus.javabasico2015;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Carrinho implements Serializable{
	private static final long serialVersionUID = 1L;

	private Pedido pedido = new Pedido();
	
	public void adicionar(Item item){
		pedido.adicionar(item);
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void limpar() {
		pedido = new Pedido();
	}
}
