package LinkedListGeneric;

import circular_singly_linked_list.CircularLinkedListImplementation;

public class LinkedListGenericImplementationRunner {
    public static void main(String[] args) {
        LinkedListGenericImplementation<Integer> list = new LinkedListGenericImplementation<Integer>();
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(3);
        list.insert(1);
        list.insert(2);
        list.display();
        LinkedListGenericImplementation<String> list2 = new LinkedListGenericImplementation<String>();
        list2.insert("Hello");
        list2.insert("World");
        list2.display();

        list2.insertAtStart("48");
        list2.display();
        list2.deleteAt(0);
        list2.display();
        list2.deleteAt(1);
        list2.display();

        System.out.println("length of LIST 2 = " + list2.getLength());
        System.out.println();

        list.insertAt(2, 45);
        list.display();

        System.out.println("length of list = " + list.getLength());
        System.out.println("Middle of list is = " + list.getMiddle().data);

        list.reverseList();
        list.display();

        list.deleteDuplicates();
        list.display();

        LinkedListGenericImplementation<Double> list3 = new LinkedListGenericImplementation<>();

        list3.insert(1.1);
        list3.insert(2.2);
        list3.insert(3.3);
        list3.head.next.next.next = list3.head; //artificially creating a loop

//        list3.display(); //generates infinite loop

        Node n = list3.detectLoop();

        if (n != null) {
            System.out.println("LOOP DETECTED");
        } else {
            System.out.println("No LOOP DETECTED");
        }

        System.out.println("Loop starts at value" + list3.detectStartOfLoop().data);

        list3.removeLoop();
        n = list3.detectLoop();

        if (n != null) {
            System.out.println("LOOP DETECTED");
        } else {
            System.out.println("No LOOP DETECTED");
        }

        list3.display();

        CircularLinkedListImplementation<Integer> circularList = new CircularLinkedListImplementation<>();
        circularList.insert(4);
        circularList.insert(3);
        circularList.insert(2);
        circularList.display();
        System.out.println("length of circular list is = " + circularList.getLength());

    }
}
