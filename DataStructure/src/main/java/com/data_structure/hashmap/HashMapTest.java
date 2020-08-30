package com.data_structure.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Key, String> cityMap = new HashMap<Key, String>();
        cityMap.put(new Key(1, "NY"), "New York City");
        cityMap.put(new Key(2, "ND"), "New Delhi");
        cityMap.put(new Key(3, "NW"), "Newark");
        cityMap.put(new Key(4, "NP"), "Newport");

        System.out.println("size before iteration " + cityMap.size());
        for (Key key : cityMap.keySet()) {
            System.out.println(cityMap.get(key));
        }
        System.out.println("size after iteration " + cityMap.size());
    }

}

class Key {
    int index;
    String Name;

    Key(int index, String Name) {
        this.index = index;
        this.Name = Name;
    }

    @Override
    public int hashCode() {
        return 5;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
