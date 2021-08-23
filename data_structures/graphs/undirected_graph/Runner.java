package undirected_graph;

public class Runner {
    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph(4);

        undirectedGraph.addEdge(1,2);
        undirectedGraph.addEdge(1,3);
        undirectedGraph.addEdge(3,2);

        undirectedGraph.printAdjacencyMatrix();
        undirectedGraph.printAdjacencyList();

        undirectedGraph.breadthFirstSearch(3);


    }
}
