package br.edu.horus.javabasico2015;

public class ItemNaoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ItemNaoExisteException(String nome) {
		super("Item como o nome "+ nome + " não encontrado");
	}
}
