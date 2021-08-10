package for_linked_list.single;

import LinkedListGeneric.LinkedListGenericImplementation;
import LinkedListGeneric.Node;

public class SearchSingleLinkedList<T extends  Comparable<T>> {
    public Integer linearSearchByValue(LinkedListGenericImplementation<T> list, T data)
    {
        Node temp = list.head;
        int index = 0;
        while (temp != null)
        {
            if (data.compareTo((T) temp.data) == 0 )
            {
                return index;
            }
            else
            {
                index++;
                temp = temp.next;
            }
        }
        return null;
    }

    public T linearSearchByIndex(LinkedListGenericImplementation<T> list, int index)
    {
        Node temp = list.head;
        int i = 0;
        for (i = 0; i <= index && temp != null; i++) {
            temp = temp.next;
        }
        if (i < index)
        {
            return null;
        }
        else
        {
            return (T) temp.data;
        }

    }

}
