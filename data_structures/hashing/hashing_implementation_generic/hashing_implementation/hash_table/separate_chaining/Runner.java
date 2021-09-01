package hashing_implementation.hash_table.separate_chaining;

public class Runner {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>(10);

        hashTable.insertUsingModular(1, "hello"); //adding first value
        System.out.println(hashTable.getUsingModular(1)); //retrieving first value using key

        hashTable.insertUsingModular(1, "World"); //adding same key
        System.out.println(hashTable.getUsingModular(1)); //value is overridden.

        hashTable.insertUsingModular(9, "collision 1");
        hashTable.insertUsingModular(99, "collision 2");
        hashTable.insertUsingModular(999, "collision 3");

        System.out.println(hashTable.getUsingModular(9));
        System.out.println(hashTable.getUsingModular(99));
        System.out.println(hashTable.getUsingModular(999));


        System.out.println("Deleted : " + hashTable.deleteUsingModular(9));


        System.out.println(hashTable.getUsingModular(9));
        System.out.println(hashTable.getUsingModular(99));
        System.out.println(hashTable.getUsingModular(999));


        System.out.println("DELETED : " + hashTable.deleteUsingModular(999));

        System.out.println(hashTable.getUsingModular(9));
        System.out.println(hashTable.getUsingModular(99));
        System.out.println(hashTable.getUsingModular(999));

        hashTable.insertUsingModular(9, "Collision1 After Deleting");
        System.out.println(hashTable.getUsingModular(9));

        hashTable.insertUsingModular(999, "Collision3 After Deleting");
        System.out.println(hashTable.getUsingModular(999));
    }
}
