package undirected_graph;

import LinkedListGeneric.LinkedListGenericImplementation;
import LinkedListGeneric.Node;
import queueImplementation.QueueImplementationGeneric;

/*
    * graphs are used to show relations and help in implementing social media sites
    * adjacency matrix is used to show relationship between each vertex
    * every 1 in adjacency matrix represents an edge to vertices
    * in Undirected graph we add 1 to both sides since edges are bi directional
    *
    * adjacency list is basically another way of representing graph relations
    * An ARRAY OF LINKED LISTS is called adjacency list
    * this list tells the relation of how one edge is related with entire graph instead of just other element
    * you can access all the connected edges of one edge
 */
public class UndirectedGraph {
    int [][] adjacencyMat;
    LinkedListGenericImplementation<Integer>[] adjacencyList;
    public UndirectedGraph(int noOfNodes)
    {
        this.adjacencyMat = new int[noOfNodes][noOfNodes];

        this.adjacencyList = new LinkedListGenericImplementation[noOfNodes]; //creating array of noOfNodes
        for (int i = 0; i < noOfNodes; i++) {
            this.adjacencyList[i] = new LinkedListGenericImplementation<>(); //adding list to each element of array
        }
    }
    public void printAdjacencyMatrix()
    {
        separator();
        for (int i = 0; i < adjacencyMat.length; i++) {
            System.out.print(i + "  |");
            for (int j = 0; j < adjacencyMat[i].length; j++) {
                System.out.print(" " + adjacencyMat[i][j] + " " );
            }
            System.out.println("|");
        }
        separator();

    }

    public void printAdjacencyList()
    {
        separator();
        System.out.println("ARRAY NO :  LIST" );
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print( + i + ":  ");
            adjacencyList[i].display(false);
        }
        separator();
    }

    public void addEdge(int x, int y)
    {
        this.adjacencyMat[x][y] = 1;
        this.adjacencyMat[y][x] = 1; //adding 1 to both sides cause of undirected graph

        adjacencyList[x].insert(y); //one parameter acts as location/ index while other as data
        adjacencyList[y].insert(x); //for undirected graph
    }

    public void breadthFirstSearch(int node)
    {
        /*
            * bfs is a level order traversal like in trees
            * each connected node is visited by adding it into a queue
            * we need a VISITED[] to make sure we dont revisit the same node because a graph can contain a cycle as opposed to tree
            * in it we also use adjacency list to parse each value of array
            * THE NODES/VERTICES ARE SAME AS INDEX NUMBER! Don't CONFUSE EM :)
            * node IN PARAMETER is the node from where traversing is gonna start
         */

        boolean[] visited = new boolean[adjacencyList.length]; //no of nodes
        QueueImplementationGeneric<Integer> queue = new QueueImplementationGeneric<>();

        queue.enqueue(node); //visiting given vertex
        visited[node] = true; //index and vertices are same

        separator();
        while (!queue.isEmpty())
        {
            int x = queue.dequeue(); //getting x element out of queue
            System.out.println(x);

            Node head = adjacencyList[x].head; // using x element to get the arrayNo of adjacency list and storing its head
            for (int i = 0; i < adjacencyList[x].getLength(); i++) { //iterating through whole list of x arrayNo
                int y = (int) head.data; //storing each element of that list in y
                if (!visited[y]) // using y as index checking if we have visited it before for loop detection
                {
                    queue.enqueue(y); //using y as index and enqueuing it
                    visited[y] = true; //checking the flag as true
                }
                head = head.next; //iterating list
            }
        }
        separator();

    }





    public void separator()
    {
        System.out.println("-----------------------------");
    }
}
