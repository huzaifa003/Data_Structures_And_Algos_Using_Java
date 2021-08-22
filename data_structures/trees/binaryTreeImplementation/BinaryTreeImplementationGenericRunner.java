package binaryTreeImplementation;

public class BinaryTreeImplementationGenericRunner {
    public static void main(String[] args) {
        BinaryTreeImplementationGeneric<Integer> binaryTree1 = new BinaryTreeImplementationGeneric<>();

        binaryTree1.insertUsingLevelOrder(4);
        binaryTree1.insertUsingLevelOrder(5);
        binaryTree1.insertUsingLevelOrder(6);
        binaryTree1.insertUsingLevelOrder(7);
        binaryTree1.insertUsingLevelOrder(8);
        binaryTree1.insertUsingLevelOrder(10);
//        System.out.println(binaryTree1.root.data);
        System.out.println("-------------------------");
        binaryTree1.displayUsingLevelOrderIterative();
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        binaryTree1.displayUsingPreOrderRecursive(binaryTree1.root);
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        binaryTree1.displayUsingPreOrderIterative();
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        binaryTree1.displayUsingInOrderIterative();
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        binaryTree1.displayUsingInOrderRecursive(binaryTree1.root);
        System.out.println("-------------------------");
        System.out.println("--------------------------");
        binaryTree1.displayUsingPostOrderRecursive(binaryTree1.root);
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        binaryTree1.displayUsingPostOrderIterative();

    }
}
