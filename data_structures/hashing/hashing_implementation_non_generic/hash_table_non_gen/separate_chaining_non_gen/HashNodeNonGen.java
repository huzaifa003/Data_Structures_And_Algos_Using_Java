package hash_table_non_gen.separate_chaining_non_gen;

/*
 * Hash Node consists of:
 * -> Key
 * -> Value
 * -> Next pointer to link nodes in case of collision by using separate chaining method
 */
class HashNodeNonGen {
    Integer key;
    String value;
    HashNodeNonGen next;

    public HashNodeNonGen(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}
