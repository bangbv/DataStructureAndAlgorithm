package com.data_structure.hashmap;

public class LinkedHashEntry {
	String key;
	int value;
	LinkedHashEntry next;
	
	LinkedHashEntry(String key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
