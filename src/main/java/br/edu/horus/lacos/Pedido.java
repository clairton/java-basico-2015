package br.edu.horus.lacos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pedido {
	private Collection<Item> items = new ArrayList<Item>();

	public void adicionar(Item... item) {
		items.addAll(Arrays.asList(item));
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

	public void limpar() {
		items.clear();
	}

	public Collection<Item> itemsPorNome() {
		List<Item> list = (List<Item>) items;
		Collections.sort(list, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}