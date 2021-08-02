package LinkedListImplementation;

public class LinkedListImplementationRunner {
    public static void main(String[] args) {
        LinkedListImplementation linkedList = new LinkedListImplementation();
        linkedList.insert(4);
        linkedList.insert(86);
        linkedList.display();
        linkedList.insert(54);
        linkedList.display();

        linkedList.insertAtStart(34);
        linkedList.display();

        linkedList.insertAt(1,100);
        linkedList.display();

        linkedList.deleteAt(10);
        linkedList.display();
    }
}
