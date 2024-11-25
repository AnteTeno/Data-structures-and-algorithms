package oy.interact.tira.util;

public class Pair<K,V> {
	private K key;
	private V value;
	private boolean removed;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
		removed = false;
	}

	public K getKey() {
		return key;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public void setKey(K key) {
		this.key = key;
	}
	
	public V getValue() {
		return value;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved() {
		removed = true;
	}
}
