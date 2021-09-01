package hash_table_non_gen.separate_chaining_non_gen;

public class Runner {
    public static void main(String[] args) {

        HashTableNonGen hashTable = new HashTableNonGen(10);

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

        try {
            hashTable.deleteUsingModular(9);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(hashTable.getUsingModular(9));
        System.out.println(hashTable.getUsingModular(99));
        System.out.println(hashTable.getUsingModular(999));

        try {
            hashTable.deleteUsingModular(999);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(hashTable.getUsingModular(9));
        System.out.println(hashTable.getUsingModular(99));
        System.out.println(hashTable.getUsingModular(999));

        hashTable.insertUsingModular(9, "Collision1 After Deleting");
        System.out.println(hashTable.getUsingModular(9));

        hashTable.insertUsingModular(999, "Collision3 After Deleting");
        System.out.println(hashTable.getUsingModular(999));


    }
}
