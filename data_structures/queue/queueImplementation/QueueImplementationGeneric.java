package queueImplementation;

/*
 * Queue is basically same as singly linked list
 * FRONT of the queue is the first element
 * REAR is the last element
 * it works on FIFO principle
 * the only DIFFERENCE with linked list is that adding is done by front and deletion by rear
 * IT MIMICS REAL QUEUE (This queue is followed by everybody though:))
 * REAR IS USED TO ADD ELEMENTS
 * FRONT IS USED TO DELETE ELEMENTS
 */
public class QueueImplementationGeneric<T> {
    Node front;  // will be used to remove data or dequeue
    Node rear; //will be used to add data or enqueue
    int length;
    public void enqueue(T data) {
        Node node = new Node(data);
        if (front == null && rear == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node; //using rear part to insert the nodes at the end
        }
        length++;
    }

    public T dequeue() //same as poll()
    {
        Node node = front;
        if (this.front!= null && this.front.next != null)
        {
            this.front = this.front.next; //replacing front with another element
        }
        else
        {
            this.front = null;
            this.rear = null;
        }
        length--;
        return (T)node.data; //returning the last node
    }

    public boolean isEmpty()
    {
        if (getLength()== 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getLength() {
        return length;
    }
}
