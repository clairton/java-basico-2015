package br.edu.horus.lacos;

import java.util.ArrayList;
import java.util.Collection;

public class Pedido {
	private Collection<Item> items = new ArrayList<Item>();

	public void adicionar(Item item) {
		items.add(item);
	}

	public Collection<Item> getItems() {
		return items;
	}
}