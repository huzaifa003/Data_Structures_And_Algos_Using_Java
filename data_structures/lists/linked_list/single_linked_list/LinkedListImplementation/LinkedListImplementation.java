package LinkedListImplementation;

/*
 *LinkedList is a list that consists of nodes, each node has data at first block and a reference to another list at second block both of which combine to form the node
 *
 * HEAD CONTAINS THE FIRST NODE
 *
 * We can implement it by checking for null references of each node
 * where references are null it means  that it is the end of the linked list
 */
public class LinkedListImplementation {
    Node head;

    public void insert(int data) {
        Node node = new Node(data); //creates a new node with data and next reference as null
        if (head == null) //for first iteration
        {
            node.next = null; //next is another reference inside node class, its not needed here though
            head = node;
        } else {
            Node n = head; //assigns first element aka head
            while (n.next != null) //checks if next reference is null (used to get the final node)
            {
                n = n.next;
            }
            n.next = node; //inserting the above created node at the end of LinkedList

        }
    }

    public void display() {
        System.out.println(); //just for adding a space
        Node node = head; //first node
        while (true) {
            if (node == null) //if current node has null reference then break
                break;
            else {
                System.out.println(node.data);
                node = node.next; //keeps iterating through nodes
            }
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node(data);
        if (head == null) {
            insert(data);
        } else {
            node.next = head; // making head the second node of the new node
            head = node; //updating the value of head to reflect the first node
        }
    }

    public void insertAt(int index, int data) {
        Node n = head;
        Node node = new Node(data);
        if (index == 0) { //for first one
            insertAtStart(data);
        } else {
            for (int i = 0; i < index-1; i++) { //reason for -1 is because if index 1 is entered it has to make changes at 0 node means always 1 less than what is entered
                if (n == null && i < index - 1) {
                    throw new ArrayIndexOutOfBoundsException("Index out of Bounds");
                }
                n = n.next;
            }

            node.next = n.next; //placing the n.next reference in node.next
            n.next = node; //updating the n.next node to hold node
            //        this means that new node will point to reference of n+1 index and n node will point to new node

        }
    }

    public void deleteAt(int index)
    {
        Node n = head;
        if (index == 0 && n.next != null)
        {
            head = n.next;
            System.out.println("fml");
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                if (n == null && i < index - 1) {
                    throw new ArrayIndexOutOfBoundsException("Index out of bounds");
                }
                n = n.next;
            }
        }
        n.next = (n.next).next;
    }
}
