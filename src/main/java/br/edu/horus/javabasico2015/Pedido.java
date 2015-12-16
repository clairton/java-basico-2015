package br.edu.horus.javabasico2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Pedido extends Identificavel implements Enviavel{
	private Pessoa cliente;

	@Identificador
	private Collection<Item> items = new ArrayList<Item>();

	public Pedido(){}
	
	public Pedido(Pessoa pessoa){
		this.cliente = pessoa;
	}
	
	@Override
	public String getConteudo() {
		StringBuilder conteudo = new StringBuilder();
		conteudo.append(cliente.getNome() + "\n");
		
		for (Item item : items) {
			conteudo.append(item.getNome() + " -> " + item.getValor() + "\n");
		}
		
		conteudo.append("Total R$: " + totalizar());
		return conteudo.toString();
	}
	
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

	public Identificavel pesquisarPorNome(String nome) throws ItemNaoExisteException {
		try{			
			return items.stream()
					//.filter(i -> i.getNome().equals(nome))
					.filter(new Predicate<Item>() {
						
						@Override
						public boolean test(Item t) {
							return t.getNome().equals(nome);
						}
					})
					.collect(Collectors.toList())
					.get(0);		
		}catch(IndexOutOfBoundsException e){
			throw new ItemNaoExisteException(nome);
		}
	}
}