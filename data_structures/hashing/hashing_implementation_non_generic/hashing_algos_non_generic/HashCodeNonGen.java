package hashing_algos_non_generic;

public class HashCodeNonGen {

    public int HashCodeNative(Integer key) {
        return key.hashCode();
    }

    public int HashCodeModular(int key, int size) {
        return key % size;
    }
}
