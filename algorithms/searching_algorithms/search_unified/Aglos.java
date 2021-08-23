package search_unified;

import DoubleLinkedListGeneric.DoubleLinkedListImplementation;
import LinkedListGeneric.LinkedListGenericImplementation;
import LinkedListGeneric.Node;
import circular_singly_linked_list.CircularLinkedListImplementation;

public class Aglos {
    //-------------------------------ARRAY SEARCH--------------------------------------\\
    public Integer linearSearchByValue(Object arr[], Object data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return null;
    }

    public Object linearSearchByIndex(Object arr[], int index) {
        if (index < arr.length) {
            return arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    public Integer binarySearch(Object arr[], Object data) {
        int left = 0;
        int right = arr.length - 1;
        int middle;


        if (arr[0] instanceof Double || arr[0] instanceof Integer || arr[0] instanceof Float) {
            while (left <= right) {
                middle = (left + right) / 2;
                if (convertObjectToDouble(arr[middle]) == convertObjectToDouble(data)) {
                    return middle;
                } else if (convertObjectToDouble(arr[middle]) > convertObjectToDouble(data)) {
                    right = middle - 1; //ignoring right half if data is greater
                } else {
                    left = middle + 1; // ignoring left half if data is small
                }
            }
        } else if (arr[0] instanceof String) {
            while (left != right) {
                middle = (left + right) / 2;
                if (convertObjectToString(arr[middle]).equals(convertObjectToString(data))) {
                    return middle;
                } else if (convertObjectToString(arr[middle]).compareTo(convertObjectToString(data)) < 0) {
                    right = middle - 1; //ignoring right half if data is greater
                } else {
                    left = middle + 1; // ignoring left half if data is small
                }
            }
        }

        return null;
    }

    private double convertObjectToDouble(Object element) {
        return Double.parseDouble(element.toString());
    }

    private String convertObjectToString(Object element) {
        return element.toString();
    }

    //-------------------------------ARRAY SEARCH END------------------------------\\


    //-------------------------------CIRCULAR LINKED LIST------------------------------\\

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

    //-------------------------------CIRCULAR LINKED LIST END------------------------------\\


    //-------------------------------Single LINKED LIST------------------------------\\

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

    //-------------------------------Single LINKED LIST END------------------------------\\


    //-------------------------------Double LINKED LIST------------------------------\\

    public <T extends Comparable<T>> Integer linearSearchByValue(DoubleLinkedListImplementation<T> list, T data) {
        DoubleLinkedListGeneric.Node temp = list.getHead();
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
        DoubleLinkedListGeneric.Node temp = list.getHead();
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

    public class SearchCircularLinkedList {
        public <T extends Comparable<T>> Integer linearSearchByValue(CircularLinkedListImplementation<T> list, T data) {
            Node temp = list.tail.next; // equals to head but since using head isn't a rule in circular list hence we use tail.next
            int index = 0;
            do {
                if (data.compareTo((T) temp.data) == 0) { //moving till element is found
                    return index;
                } else {
                    index++; //to return the index
                    temp = temp.next;
                }
            } while (temp != list.tail.next); //loop wont terminate until we reach list.tail.next TWICE because of temp = temp.next
            return null; //if element is not found
        }
    }

    //-------------------------------Double LINKED LIST END------------------------------\\
}
