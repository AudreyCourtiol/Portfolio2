public class Edge {
    int u; // first edge of the vertex
    int v; // second edge of the vertex
    int weight;  // the value of the distance between the edges

    public Edge(int u, int v, int weight){ //creation of an edge
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}
