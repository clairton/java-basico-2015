package br.edu.horus.javabasico2015;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@ValidaTotal
public class Pedido extends Identificavel implements Enviavel{
	/*
	 * o "final" deixa o valor ser atribuido apenas uma vez, 
	 * podendo ser iniciado no construtor,
	 * adicionando o "static" o valor deve ser atribuido
	 * na declaração da variavel, sendo uma constante"
	 */
	private final static BigDecimal CEM = new BigDecimal(100);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
//	@Identificador
//	@OneToOne
//	@JoinColumn(name = "cliente_id")
	@Transient
	private Cliente cliente;

	@Identificador
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pedido_item", joinColumns = @JoinColumn(name = "pedido_id")
			, inverseJoinColumns = @JoinColumn(name = "item_id") )
	private Collection<Item> items = new ArrayList<Item>();

	@NotNull
	@DecimalMin("0.01")
	private Double total;
	
	public Pedido(){}
	
	@Deprecated
	public Pedido(Pessoa pessoa){
		this.cliente = new Cliente(pessoa);
	}
	
	public Pedido(Cliente cliente){
		this.cliente = cliente;
	}
	
	public BigDecimal getDesconto(){
		return 
			(cliente == null ? BigDecimal.ZERO : cliente.getDesconto())
			.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public Boolean isTemDesconto(){
		return getDesconto().doubleValue() > 0;
	}
	
	@Override
	public String getConteudo() {
		StringBuilder conteudo = new StringBuilder();
		conteudo.append(cliente.getNome() + "\n");
		
		if(isTemDesconto()){
			conteudo.append("Você teve " + getDesconto() + "% de desconto.\n");			
		}
		
		for (Item item : items) {
			conteudo.append(item.getNome() + " -> " + item.getValor() + "\n");
		}
		
		conteudo.append("Total R$: " + totalizar());
		return conteudo.toString();
	}
	
	public void adicionar(Item... item) {
		items.addAll(Arrays.asList(item));
		totalizar();
	}
	
	public void remover(Item item) {
		items.remove(item);
		totalizar();
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
		BigDecimal total = new BigDecimal(items.stream()
								.mapToDouble(i -> i.getValor())
								.sum());
		
		/*
		 * expressão ternaria, é if else mais "resumido"
		 * nesses caso, se o cliente for nulo, o desconto sera
		 * zero, do contrário será o desconto do cliente
		 */
		BigDecimal desconto = 
				cliente == null ? BigDecimal.ZERO : cliente.getDesconto();
		
		BigDecimal valorDesconto = total
									.multiply(desconto)
									.divide(CEM)
									.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		this.total = total.subtract(valorDesconto).doubleValue();
		return this.total;
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

	public Double getTotal() {
		return total;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
}