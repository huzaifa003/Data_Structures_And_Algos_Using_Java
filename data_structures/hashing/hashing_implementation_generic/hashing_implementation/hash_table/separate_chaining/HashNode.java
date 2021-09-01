package hashing_implementation.hash_table.separate_chaining;


/*
 * Hash Node consists of:
 * -> Key <K>
 * -> Value <V>
 * -> Next pointer to link nodes in case of collision by using separate chaining method
 */
public class HashNode<K, V> {
    K key;
    V value;
    HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
