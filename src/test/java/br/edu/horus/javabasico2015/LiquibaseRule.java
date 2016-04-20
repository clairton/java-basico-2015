package br.edu.horus.javabasico2015;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class LiquibaseRule implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		System.setProperty("br.edu.horus.javabasico2015.DROP_ALL", "true");
		System.setProperty("br.edu.horus.javabasico2015.FORCE_UPDATE", "true");
		return base;
	}

}
