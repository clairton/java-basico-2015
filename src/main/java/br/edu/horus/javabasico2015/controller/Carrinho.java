package br.edu.horus.javabasico2015.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.edu.horus.javabasico2015.Pedido;

@SessionScoped
public class Carrinho implements Serializable{
	private Pedido pedido = new Pedido();
	
	
	public Pedido getPedido() {
		return pedido;
	}


	public void limpar() {
		this.pedido = new Pedido();	
	}
}
