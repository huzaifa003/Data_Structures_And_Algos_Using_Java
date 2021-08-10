package DoubleLinkedListGeneric;

public class DoubleLinkedListImplementationRunner {
    public static void main(String[] args) {

        DoubleLinkedListImplementation<Integer> list1 = new DoubleLinkedListImplementation<>();
        list1.insertForwards(1);
        list1.insertForwards(2);
        list1.insertForwards(3);
        list1.insertForwards(4);
        list1.insertBackwards(5);
        list1.insertBackwards(6);

        list1.displayForwards();
        list1.displayBackwards();

        list1.deleteFirst();
        list1.displayForwards();

        list1.deleteLast();
        list1.displayForwards();

        list1.reverseList();
        list1.displayForwards();
        list1.displayBackwards();

        System.out.println("Length of DoubleLinked List is = " + list1.getLength());
    }
}
