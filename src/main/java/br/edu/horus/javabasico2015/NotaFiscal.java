package br.edu.horus.javabasico2015;

public class NotaFiscal extends Pedido{
	
	private @Identificador String codigo;
	
	public NotaFiscal(String codigo, Cliente cliente) {
		super(cliente);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
}
