package com.datastructure.hashmap;

public class MyHashTable {
	private int TABLE_SIZE;
	private int size;
	private LinkedHashEntry[] table;
	
	MyHashTable(int ts){
		setSize(0);
		TABLE_SIZE = ts;
		table = new LinkedHashEntry[TABLE_SIZE];
		for(int i = 0;i < TABLE_SIZE;i++) {
			table[i] = null;
		}
	}
	
	public void insert(String key, int value) {
		int hash = (myHash(key) % TABLE_SIZE);
		if(table[hash] == null) {
			table[hash] = new LinkedHashEntry(key,value);
		}else {
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new LinkedHashEntry(key, value);
		}
		size++;
	}
	
	private int myHash(String x) {
		int hashVal = x.hashCode();
		hashVal %= TABLE_SIZE;
		if(hashVal < 0) {
			hashVal += TABLE_SIZE;
		}
		return hashVal;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
    /* Function to print hash table */
    public void printHashTable()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            System.out.print("\nBucket "+ (i + 1) +" : ");
            LinkedHashEntry entry = table[i];
            while (entry != null)
            {
                System.out.print(entry.value +" ");
                entry = entry.next;
            }            
        }
    }
}
