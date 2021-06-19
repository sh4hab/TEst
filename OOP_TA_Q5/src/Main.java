import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isDirected = Boolean.parseBoolean(scanner.nextLine());
        int numberOfVertices = Integer.parseInt(scanner.nextLine());
        int numberOfEdges = Integer.parseInt(scanner.nextLine());
        Edge[] edges = new Edge[numberOfEdges];
        for (int i = 0; i < numberOfEdges; i++) {
            String edgeStr = scanner.nextLine();
            edges[i] = new Edge(edgeStr);
        }
        Graph graph;
        if (isDirected) graph = new DirectedGraph(numberOfVertices,edges);
        else graph = new UndirectedGraph(numberOfVertices,edges);
        System.out.println(graph.getMaxDegree());
        System.out.println(graph.getTotalDegree());
        System.out.println(graph.hasZeroDegree());
    }
}
class Edge{

    public Edge[int NumberOfEdges]{

    {

    }
class Graph {
}

class DirectedGraph extends Graph {
    int numberOfVertices ;
    Edge edges = new Edge[] ;

    public DirectedGraph(int numberOfVertices, Edge[] edges) {
        this.numberOfVertices = numberOfVertices;
        this.edges = edges;
    }
}
class UndirectedGraph extends Graph {

}