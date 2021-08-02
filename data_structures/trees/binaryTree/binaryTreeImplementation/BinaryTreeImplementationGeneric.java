package binaryTreeImplementation;

import queueImplementation.QueueImplementationGeneric;
import stackImplementation.StackImplementationGeneric;

/*
 * Binary tree is non linear structure that consists of child and parent nodes
 * EACH node has a right and left structure
 * There are different ways to insert and traverse data through the tree
 */
public class BinaryTreeImplementationGeneric<T> {
    Node root;

    public void insertUsingLevelOrder(T data) {
        /*
         * here we are using level order to insert the data, which  means all levels are filled with data before moving on to next level
         * For this we use queue as it provides with FIFO structure and we keep storing all levels in a queue and then we manage them
         */
        Node node = new Node(data);
        if (root == null) { //making of root
            root = node;
        } else {
            Node temp;
            QueueImplementationGeneric<Node> queue = new QueueImplementationGeneric<>();
            queue.enqueue(root); //enqueuing the root outside of loop to make sure list aint empty
            while (!queue.isEmpty()) { //traversing until we find a node with empty left and right values
                temp = queue.dequeue(); //retriving every node address from queue
                //Non Null nodes go into queue for further traversal
                if (temp.left != null) {
                    queue.enqueue(temp.left);
                }
                if (temp.right != null) {
                    queue.enqueue(temp.right);
                }
                //cause trees are read from the left hence if first left is checked and then right side is checked
                if (temp.left == null) {
                    temp.left = node;
                    return;
                } else if (temp.right == null) {
                    temp.right = node;
                    return;
                }
            }
        }
    }

    public void displayUsingLevelOrderIterative() {
        if (root == null) {
            System.out.println("Empty Tree");
        } else {
            Node temp;
            QueueImplementationGeneric<Node> queue = new QueueImplementationGeneric<>();
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                temp = queue.dequeue();
                System.out.println(temp.data);
                if (temp.left != null) {
                    queue.enqueue(temp.left);
                }
                if (temp.right != null) {
                    queue.enqueue(temp.right);
                }

            }
        }
    }

    public void displayUsingPreOrderRecursive() {
        displayUsingPreOrderRecursive(root); //automatically passing root to the below function, its optional so user does not have to pass it!
    }

    public void displayUsingPreOrderRecursive(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data);
            displayUsingPreOrderRecursive(node.left); //surfing the left node first till null is reached
            displayUsingPreOrderRecursive(node.right); //surfing the right node until null is reached
        }
    }

    public void displayUsingPreOrderIterative() {
        //here we are using FILO aka stack to traverse iteratively just like we used queue for the LEVEL TRAVERSAL
        if (root != null) {

            Node temp = null;
            StackImplementationGeneric<Node> stack = new StackImplementationGeneric<>();
            stack.push(root); //pushing root inside the track
            while (!stack.isEmpty()) {
                temp = stack.pop(); //popping each element in  stack
                System.out.println(temp.data); //printing data of stack

                //here right is pushed first because its FILO, it means right will be executed last in stack and left will be executed earlier,
                // which is what we want as trees are traversed from left to right
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
    }

    public void displayUsingInOrderIterative()
    {
        if (root != null)
        {

            Node temp = root;
            StackImplementationGeneric<Node> stack = new StackImplementationGeneric<>();
            while (!stack.isEmpty() || temp != null)
            {
                if (temp != null) //traversing till empty left node
                {
                    stack.push(temp);
                    temp = temp.left; //traversing till we have last left node
                }
                else
                {
                    temp = stack.pop(); //popping after reaching last node
                    System.out.println(temp.data); //printing data after poping to get the middle node
                    temp = temp.right; //surfing the right node
                }
            }
        }
    }

    public void displayUsingInOrderRecursive()
    {
        displayUsingInOrderRecursive(root);
    }

    public void displayUsingInOrderRecursive(Node temp)
    {
        if (temp == null) //base condition
        {
            return;
        }
        else
        {
            displayUsingInOrderRecursive(temp.left); //traversing left tree first
            System.out.println(temp.data); //printing the middle node as in inorder
            displayUsingInOrderRecursive(temp.right); //traversing right tree

        }
    }




}
