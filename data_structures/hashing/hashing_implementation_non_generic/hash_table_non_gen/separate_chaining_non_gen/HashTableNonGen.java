package hash_table_non_gen.separate_chaining_non_gen;

import hashing_algos_non_generic.HashCodeNonGen;

/*
 * Hash table works by passing keys through hashCode Method.
 * Using that index to store each HashNode
 * Capacity just like ArrayList is defined at start cause it is basically an array structure
 * in Separate Chaining it uses A Different HashNode that is joined in CASE OF COLLISION.
 * Here head of Node will be at the specified index.
 */
public class HashTableNonGen {
    HashNodeNonGen[] buckets; //HashTable consists of HashNodes in an Array Form
    int capacity; //capacity is total capacity to hold pairs
    int size; //size keeps track of no of pairs inserted

    public HashTableNonGen() {
        this(10); //default capacity
    }

    public HashTableNonGen(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashNodeNonGen[capacity];
        this.size = 0; //at start the size is = 0
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertUsingModular(int key, String value) {
        int index = new HashCodeNonGen().HashCodeModular(key, this.capacity); //getting index by hashing algorithm
        HashNodeNonGen head = buckets[index]; //first node
        if (head != null) { //at start if its null
//            System.out.println(key + "    " + (head.key != key) + "   " + (head != null));
            while (head != null) {
                if (head.key == key) {
                    head.value = value; //if key is same as entered key then value is overridden
                    return;
                }
                head = head.next; //until the pointer reaches the last HashNode of the index in case of collision (separate chaining)
            }
        }
        head = buckets[index];
        HashNodeNonGen node = new HashNodeNonGen(key, value);
        node.next = head; //placing iterated head at next pointer of new node
        buckets[index] = node;//inserting key value pair at start of iterated head cause order doesn't matter in Hash

    }

    public String getUsingModular(int key) {
        int index = new HashCodeNonGen().HashCodeModular(key, this.capacity);
        HashNodeNonGen head = buckets[index]; //first node

        while (head != null) {
            if (head.key == key) { //iterating head till we reach end of elements
                return head.value;
            } else {
                head = head.next; //moving head
            }
        }
        return null;
    }

}
