package LinkedListGeneric;

public class LinkedListGenericImplementation<T> {
    Node head;

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void display() {
        if (detectLoop() == null) {
            Node n = head;
            while (true) {
                if (n == null)
                    break;
                else {
                    System.out.println(n.data);
                    n = n.next;
                }
            }
            System.out.println();
        }
    }

    public void insertAtStart(T data) {
        Node node = new Node(data);
        if (head == null) {
            insert(data);
        } else {
            node.next = head; // making head the second node of the new node
            head = node; //updating the value of head to reflect the first node
        }
    }

    public void insertAt(int index, T data) {
        Node n = head;
        Node node = new Node(data);
        if (index == 0) { //for first one
            insertAtStart(data);
        } else {
            for (int i = 0; i < index - 1; i++) { //reason for -1 is because if index 1 is entered it has to make changes at 0 node means always 1 less than what is entered
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

    public void deleteAt(int index) {
        Node n = head;
        if (index == 0 && n.next != null) {
            head = n.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                if (n == null && i < index - 1) {
                    throw new ArrayIndexOutOfBoundsException("Index out of bounds");
                }
                n = n.next;
            }
        }
        n.next = (n.next).next;
    }

    public int getLength() {
        if (detectLoop() == null) {
            int length = 1; //for empty head we used the if condition
            Node n = head;
            if (head == null) {
                return 0;
            } else {
                while (n.next != null) {
                    length++;
                    n = n.next;
                }
            }
            return length;
        } else {
            return -1;
        }
    }

    public void reverseList() {

        if (head != null && head.next != null) {
            Node presentNode = head;
            Node previousNode = null;
            Node nextNode = head;
            while (nextNode.next != null) {

                nextNode = nextNode.next;
                presentNode.next = previousNode;
                previousNode = presentNode;
                presentNode = nextNode;
            }
            head = nextNode; //making last element the head
            head.next = previousNode;
        }
    }

    public void deleteDuplicates() {
        Node outerNode;
        Node innerNode;
        outerNode = head;

        while (outerNode.next != null) {
            innerNode = outerNode;
            while (innerNode.next != null) {
                if (innerNode.next.data == outerNode.data) {
                    innerNode.next = innerNode.next.next;
                    continue; //to check if same same data is there on two or more consecutive locations
                }
                innerNode = innerNode.next; //if data is not same then increment the inner node
            }
            outerNode = outerNode.next;
        }
    }

    public Node detectLoop() {
        Node fastNode = head;
        Node slowNode = head;
        if (fastNode != null && fastNode.next != null && fastNode.next.next != null) {
            while (fastNode != null && fastNode.next != null) {
                fastNode = fastNode.next.next; //if there is a loop then slow pointer will catch up to fast pointer
                slowNode = slowNode.next; //slow pointer travels 2x slower than fast pointer
                if (slowNode == fastNode) {
                    return slowNode;
                }
            }
        }
        return null; // null means no loop
    }

    public Node detectStartOfLoop() //Floyd's Cycle Detection algorithm, proof is there
    {
        Node slowNode = detectLoop();
        if (slowNode == null) {
            return null;
        } else {
            Node temp = head;
            while (temp != slowNode) {
                temp = temp.next;
                slowNode = slowNode.next;
            }

            return temp;
        }
    }

    public void removeLoop() {
        //here nodes are = pointers
        //for single loop in whole list
        Node slowNode = detectLoop(); //returns slowPointer
        Node startingNode = detectStartOfLoop(); //returns the startingPointer
        if (slowNode == startingNode) // checking if slowNode = startingNode
        {
            while (slowNode.next != startingNode) //looping until we have the last element of loop (before loop restarts)
            {
                slowNode = slowNode.next;
            }
            slowNode.next = null;
            return;
        }

        //for loop in a list with other values as well
        if (slowNode != null) {
            Node temp = head;
            while (temp.next != slowNode.next) { //getting the last element of loop before loop is restarted
                System.out.println(slowNode.data);
                temp = temp.next;
                slowNode = slowNode.next;
            }
            slowNode.next = null; //breaking the cycle before end and start of loop

        }
    }


}
