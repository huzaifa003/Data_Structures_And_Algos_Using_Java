package DoubleLinkedListGeneric;

public class DoubleLinkedListImplementation<T> {
    private  Node head; //first element
    private  Node tail; //last element

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void insertBackwards(T data) //we will only move head
    {
        Node node = new Node(data); //creating new node
        if (head == null && tail == null) //for empty list
        {
            head = node;
            tail = node;
        }
        else
        {
            Node n = head;  //getting head
            while (n.previousNode!= null) //moving pointer backwards till null is reached but its unnecessary as head will always be the first element
            {
                n = n.previousNode;
            }
            n.previousNode = node; //inserting node backwards
            node.nextNode = n; //adding the current node address into the nextNode of new Node
            head = node; //changing the head to first element

        }
    }

    public void insertForwards(T data)
    {
        Node node = new Node(data);
        if (head == null && tail == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            Node n = tail;

            while (n.nextNode != null)
            {
                n= n.nextNode;
            }
            n.nextNode = node;
            node.previousNode = n;
            tail = node;
        }
    }

    public void displayForwards()
    {
        if (head!= null) {
            Node n = head;
            while (n != null) {
                System.out.println(n.data);
                n = n.nextNode;
            }
            System.out.println();
        }
    }

    public void displayBackwards()
    {
        if (tail!=null)
        {
            Node n = tail;
            while (n != null)
            {
                System.out.println(n.data);
                n = n.previousNode;
            }
            System.out.println();
        }
    }

    public void deleteFirst()
    {
        if (head != null)
        {
            head = head.nextNode;
            head.previousNode = null;
        }
    }

    public void deleteLast()
    {
        if (tail!=null)
        {
            tail = tail.previousNode;
            tail.nextNode = null;
        }
    }

    public void reverseList()
    {
        Node tempNode = null;
        Node currentNode = null;
        if (head!= null && head.nextNode != null)
        {

            currentNode = head;
            while (currentNode !=null)
            {
                tempNode = currentNode.previousNode;
                currentNode.previousNode = currentNode.nextNode;
                currentNode.nextNode = tempNode; //swaping the forward and backward direction
                currentNode = currentNode.previousNode; //jumping to next node, but since we have reversed the direction we are using previous methods
            }
            if (tempNode!=null) //for empty or single variable
            {
                tail = head; //swapping tail with head
                head = tempNode.previousNode; //using previous node cause the most previous node is now the most forward one, hence we used the previous node method
            }
        }


    }
}
