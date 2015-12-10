package br.edu.horus.lacos;

public class Item {
	private String nome;
	
	private Double valor;
	
	public Item(String nome, Double valor){
		this.valor = valor;
		this.nome = nome;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		return this.nome.toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item){
			Item item = (Item) obj;
			if(item.getNome() != null){
				return item.getNome().equalsIgnoreCase(this.nome);
			}
		}		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
