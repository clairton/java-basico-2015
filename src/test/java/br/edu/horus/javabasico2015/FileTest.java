package br.edu.horus.javabasico2015;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FileTest {
	
	@Test
	public void testEscrever() throws IOException{
		String nome = "target/test.txt";
		String conteudo = "lawçnowqehoiqwehthqwhtwu";
		Files.write(new File(nome).toPath(), conteudo.getBytes());
	}
	

	@Test
	public void testContinuarEscrever() throws IOException{
		String nome = "target/test.txt";
		String conteudo = "\nlaodihfkjhgdhkj";
		Files.write(
			new File(nome).toPath(), 
			conteudo.getBytes(),
			StandardOpenOption.APPEND
		);
	}
	
	@Test
	public void testLer() throws IOException{
		String nome = "src/test/resources/arquivo.txt";
		List<String> lines = Files.readAllLines(
			new File(nome).toPath()
		);
		List<String> cs = lines.stream()
								.filter(l -> l.startsWith("c"))
								.collect(Collectors.toList());
		for (String linha : cs) {
			System.out.println(linha);
		}
	}
	
	@Test
	public void testDiretorios() throws Exception{
		File target = new File("target/novaPasta");
		if(!target.exists()){
			Files.createDirectory(target.toPath());
		}
	}	
	
	
}
