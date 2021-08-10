package for_linked_list.doubly;

import DoubleLinkedListGeneric.DoubleLinkedListImplementation;
import DoubleLinkedListGeneric.Node;

public class SearchDoubleLinkedList {
    public <T extends Comparable<T>> Integer linearSearchByValue(DoubleLinkedListImplementation<T> list, T data)
    {
        Node temp = list.getHead();
        int index = 0;
        while (temp != null) {
            if (data.compareTo((T) temp.data) == 0) { //moving till element is found
                return index;
            } else {
                index++; //to return the index
                temp = temp.nextNode;
            }
        }
        return null; //if element is not found
    }

    public <T extends Comparable<T>> T linearSearchByIndex(DoubleLinkedListImplementation<T> list, int index) throws IndexOutOfBoundsException {
        Node temp = list.getHead();
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
            temp = temp.nextNode;
        }
        if (i < index) {
            return null;
        } else {
            return (T) temp.data;
        }

    }

}
