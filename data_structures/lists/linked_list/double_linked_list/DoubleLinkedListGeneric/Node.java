package DoubleLinkedListGeneric;

public class Node <T> {
    T data;
    Node previousNode;
    Node nextNode;

    public Node(T data) {
        this.data = data;
        this.previousNode = null;
        this.nextNode = null;
    }
}
