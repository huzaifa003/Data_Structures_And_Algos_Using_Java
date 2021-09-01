package hashing_algorithms;

public class HashCode<K> {
    public int HashCodeModular(K key, int size) {
        return key.hashCode() % size; //identity hash code returns hashCode() and 0 in case of null
    }

    public int HashCodeNative(K key) {
        return key.hashCode();
    } //returns native hashCode()
}
