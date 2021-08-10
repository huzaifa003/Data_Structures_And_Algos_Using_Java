package DoubleLinkedListGeneric;

public class Node <T> {
    public T data;
    public Node previousNode;
    public Node nextNode;


    public Node(T data) {
        this.data = data;
        this.previousNode = null;
        this.nextNode = null;
    }
}
