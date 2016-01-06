package br.edu.horus.javabasico2015;

import java.util.HashMap;
import java.util.Map;

public class MapItem extends HashMap<Integer, Item> implements Map<Integer, Item> {
	private static final long serialVersionUID = 0L;

	public void add(Item item) {
		put(item.getId(), item);
	}
}
