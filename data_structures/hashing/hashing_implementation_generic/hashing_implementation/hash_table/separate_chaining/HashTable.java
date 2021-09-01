package hashing_implementation.hash_table.separate_chaining;


import hashing_algorithms.HashCode;

import java.util.ArrayList;

public class HashTable<K extends Comparable<K>, V> {
    /*
     * Hash table works by passing keys through hashCode Method.
     * Using that index to store each HashNode
     * Capacity just like ArrayList is defined at start cause it is basically an array structure
     * in Separate Chaining it uses A Different HashNode that is joined in CASE OF COLLISION.
     * Here head of Node will be at the specified index.
     */
    ArrayList<HashNode<K, V>> buckets; //HashTable consists of HashNodes in an Array Form
    int capacity; //capacity is total capacity to hold pairs
    int size; //size keeps track of no of pairs inserted

    public HashTable() {
        this(10); //default capacity
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList<>(capacity); //using ArrayList for generics
        this.size = 0; //at start the size is = 0
        for (int i = 0; i < capacity; i++) {
            buckets.add(null); //adding the null elements at start
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertUsingModular(K key, V value) {
        int index = new HashCode<K>().HashCodeModular(key, this.capacity); //getting index by hashing algorithm
        HashNode<K, V> head = buckets.get(index); //first node
        if (head != null) { //at start if its null
            while (head != null) {
                if (head.key.compareTo(key) == 0) {
                    head.value = value; //if key is same as entered key then value is overridden
                    return;
                }
                head = head.next; //until the pointer reaches the last HashNode of the index in case of collision (separate chaining)
            }
        }
        head = buckets.get(index); //head is again assigned the start of the value
        HashNode<K, V> node = new HashNode<>(key, value);
        node.next = head; //placing iterated head at next pointer of new node
        buckets.set(index, node);//inserting key value pair at start of iterated head cause order doesn't matter in Hash

    }

    public V getUsingModular(K key) {
        int index = new HashCode<K>().HashCodeModular(key, this.capacity); //getting index by hashing algorithm
        System.out.println();
        HashNode<K, V> head = buckets.get(index); //first node
        while (head != null) {
            if (head.key.compareTo(key) == 0) { //iterating head till we reach end of elements
                return head.value;
            } else {
                head = head.next; //moving head
            }
        }
        return null;
    }

    public V deleteUsingModular(K key) {
        int index = new HashCode<K>().HashCodeModular(key, this.capacity); //getting index by hashing algorithm
        HashNode<K, V> head = buckets.get(index); //first node

        if (head != null) {
            if (head.key.compareTo(key) == 0) {
                buckets.set(index, buckets.get(index).next);
                return head.value;
            } else if (head.next != null) {
                HashNode<K, V> temp = head.next;
                while (temp.key.compareTo(key) != 0) {
                    head = head.next;
                    temp = head.next;
                }
                head.next = head.next.next;
                return temp.value;
            }

        }
        return null;
    }
}


