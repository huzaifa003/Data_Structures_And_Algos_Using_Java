package search_for_linked_list.single;

import LinkedListGeneric.LinkedListGenericImplementation;
import circular_singly_linked_list.CircularLinkedListImplementation;

public class Runner {
    public static void main(String[] args) {
        LinkedListGenericImplementation<Integer> list = new LinkedListGenericImplementation<>();
        list.insert(4);
        list.insert(87);

        SearchSingleLinkedList search  = new SearchSingleLinkedList();
        System.out.println(search.linearSearchByIndex(list,4));
        System.out.println(search.linearSearchByValue(list,88));

        CircularLinkedListImplementation<Double> circularList = new CircularLinkedListImplementation<>();
        circularList.insert(4.0);
        circularList.insert(57.4);
        circularList.display();

        SearchCircularLinkedList searchCircularLinkedList = new SearchCircularLinkedList();
        System.out.println("57.4 Element's Index is  = " + searchCircularLinkedList.linearSearchByValue(circularList,57.4) );
        System.out.println("Element at Index 0 = " + searchCircularLinkedList.linearSearchByIndex(circularList,0));
    }
}
