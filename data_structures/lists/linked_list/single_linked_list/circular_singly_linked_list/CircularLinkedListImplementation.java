package circular_singly_linked_list;

import LinkedListGeneric.Node;
/*
    * In circular linked list we add the last node to first node and it creates a node
    * THE ONLY NODE THAT WE NEED TO KEEP TRACK OF IS THE LAST NODE
    * AKA TAIL, NOT HEAD
    * THE REASON WE ARE USING HEAD IN HERE IS JUST FOR OUR OWN CONVENIENCE
    * OTHERWISE WE CAN LOOP THE TAIL UNTIL TAIL IS AGAIN FOUND
 */
public class CircularLinkedListImplementation<T> {
    Node<T> head; //first parameter
    Node<T> tail; // last parameter

    public void insert(T data)
    {
        Node<T> n = new Node<>(data);
        if (head == null && tail == null)
        {
            head = n;
            tail = head;
            tail.next = head;
        }
        else
        {
            tail.next = n;
            tail = n;
            tail.next = head;
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
}
