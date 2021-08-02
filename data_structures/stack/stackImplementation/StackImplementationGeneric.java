package stackImplementation;

/*
 * A stack consists of elements on top of each other
 * Stack uses push and pop
 * in Stack the top node is the top element
 * Top Element is used to push new elements or pop previous elements
 * It's like a SINGLE LINKED LIST IN UPWARD DIRECTION WHERE TOP == HEAD pointing to element below it
 * the below element points toward the next below element
 * CONSIDER IT LIKE A CLOSED SINGLE LINKED LIST
 * Length here is the total length starting from 0
 */
public class StackImplementationGeneric<T> {
    Node top;
    int length;

    public int push(T data) {
        Node node = new Node(data);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        length++;
        return length;
    }

    public T pop()
    {
        T result = null;
        if (top != null && top.next != null)
        {
            result = (T) top.data;
            top = top.next;
            length-- ;
        }
        else if (top != null)
        {
            result = (T) top.data;
            length--;
            top = null;
        }
        return result;
    }

    public T peek()
    {
        if (length != 0)
        {
            return (T)top.data;
        }
        else
        {
            return null;
        }
    }

    public boolean isEmpty()
    {
        if (length == 0)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
}
