package main;

import hashtable.MyHashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String> table = new MyHashTable<>(2);

        table.add("Otkritie");
        table.add("Sberbank");
        table.add("Alpha");

    }
}
