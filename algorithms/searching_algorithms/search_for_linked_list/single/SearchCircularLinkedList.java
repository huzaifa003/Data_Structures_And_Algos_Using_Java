package search_for_linked_list.single;

import LinkedListGeneric.Node;
import circular_singly_linked_list.CircularLinkedListImplementation;

public class SearchCircularLinkedList {
    public <T extends Comparable<T>> Integer linearSearchByValue(CircularLinkedListImplementation<T> list, T data) {
        Node temp = list.tail.next; // equals to head but since using head isn't a rule in circular list hence we use tail.next
        int index = 0;
        do  {
            if (data.compareTo((T) temp.data) == 0) { //moving till element is found
                return index;
            } else {
                index++; //to return the index
                temp = temp.next;
            }
        } while (temp != list.tail.next); //loop wont terminate until we reach list.tail.next TWICE because of temp = temp.next
        return null; //if element is not found
    }

    public <T extends Comparable<T>> T linearSearchByIndex(CircularLinkedListImplementation<T> list, int index) throws IndexOutOfBoundsException {
        Node temp = list.tail.next;
        int i = 0;
        try {
            if (index > list.getLength()) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out of Bounds from searching by index");
            return null;
        }

        for (i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }
        if (i < index) {
            return null;
        } else {
            return (T) temp.data;
        }

    }
}
