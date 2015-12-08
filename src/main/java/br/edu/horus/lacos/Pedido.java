package br.edu.horus.lacos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Pedido {
	private Collection<Item> items = new ArrayList<Item>();

	public void adicionar(Item item) {
		items.add(item);
	}
	
	public void remover(Item item) {
		items.remove(item);
	}

	public Collection<Item> getItems() {
		return Collections.unmodifiableCollection(items);
	}

	public Double totalizar(){
		/*Double total = 0d;
		for (Item item : items) {
			total += item.getValor();
		}		
		return total;*/
		return items.stream().mapToDouble(i -> i.getValor()).sum();
	}
	
	public Integer contar(){
		return items.size();
	}
}