package for_linked_list.single;

import LinkedListGeneric.LinkedListGenericImplementation;
import LinkedListGeneric.Node;

public class SearchSingleLinkedList {
    public <T extends Comparable<T>> Integer linearSearchByValue(LinkedListGenericImplementation<T> list, T data) {
        Node temp = list.head;
        int index = 0;
        while (temp != null) {
            if (data.compareTo((T) temp.data) == 0) { //moving till element is found
                return index;
            } else {
                index++; //to return the index
                temp = temp.next;
            }
        }
        return null; //if element is not found
    }

    public <T extends Comparable<T>> T linearSearchByIndex(LinkedListGenericImplementation<T> list, int index) throws IndexOutOfBoundsException {
        Node temp = list.head;
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
