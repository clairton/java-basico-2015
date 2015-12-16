package br.edu.horus.javabasico2015;

public class Email implements Notificacao {

	@Override
	public <T extends Enviavel> void enviar(T mensagem) {
		System.out.println("Enviando por email: " + mensagem.getConteudo());
	}

}
