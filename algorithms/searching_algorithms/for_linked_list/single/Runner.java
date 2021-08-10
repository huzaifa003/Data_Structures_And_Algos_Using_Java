package for_linked_list.single;

import LinkedListGeneric.LinkedListGenericImplementation;

public class Runner {
    public static void main(String[] args) {
        LinkedListGenericImplementation<Integer> list = new LinkedListGenericImplementation<>();
        list.insert(4);
        list.insert(87);

        SearchSingleLinkedList search  = new SearchSingleLinkedList();
        System.out.println(search.linearSearchByIndex(list,4));
        System.out.println(search.linearSearchByValue(list,88));


    }
}
