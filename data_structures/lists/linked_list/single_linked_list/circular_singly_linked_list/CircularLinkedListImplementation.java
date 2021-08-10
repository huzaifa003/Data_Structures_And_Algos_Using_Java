package circular_singly_linked_list;

import LinkedListGeneric.Node;
/*
    * In circular linked list we add the last node to first node and it creates a loop
    * THE ONLY NODE THAT WE NEED TO KEEP TRACK OF IS THE LAST NODE
    * AKA TAIL, NOT HEAD
    * THE REASON WE ARE USING HEAD IN HERE IS JUST FOR OUR OWN CONVENIENCE
    * OTHERWISE WE CAN LOOP THE TAIL UNTIL TAIL IS AGAIN FOUND
 */
public class CircularLinkedListImplementation<T> {
    public Node<T> head; //first parameter
    public Node<T> tail; // last parameter

    public void insert(T data)
    {
        Node<T> n = new Node<>(data);
        if (head == null && tail == null)
        {
            head = n;
            tail = n;
            tail.next = head;
        }
        else
        {
            tail.next = n; //adding the next element in front of last element
            tail = n; //changing the tail to last element
            tail.next = head; //pointing the last element to head again
        }

    }

    public void display()
    {
        Node n = tail;
        if (n.next == tail)
        {
            System.out.println(tail.data);
        }
        else {
            do { //using do while so the loop runs until we encounter tail and print tail and then terminate
                n = n.next; //first incrementing the list
                System.out.println(n.data);
            } while (n != tail);
        }
        System.out.println();
    }

    public int getLength() {
        if (tail == null)
        {
            return 0;
        }

        Node temp = tail;
        int length = 1;
        do {
            temp = temp.next;
            length++;
        } while (temp.next != tail);
        return length;
    }
    // IT'S IMPLEMENTATION IS DONE IN THE PACKAGE OF SINGLE LINKED LIST
}
