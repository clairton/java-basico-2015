package br.edu.horus.javabasico2015;

public interface Notificacao {

	<T extends Enviavel> void enviar(T mensagem);

}
