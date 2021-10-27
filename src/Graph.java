import java.util.ArrayList;

public class Graph {
    int vertices;
    public ArrayList<ArrayList<Edge>> adjacencylist;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencylist = new ArrayList<>(vertices);
        for (int i = 0; i < this.vertices; ++i)
            this.adjacencylist.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int weight) {

        adjacencylist.get(u).add(new Edge(u, v, weight));
        if (u == v) {
            // self loop
            return;
        }
        adjacencylist.get(v).add(new Edge(v, u, weight));
    }

    public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {
        int index = minHeap.indexes[vertex];
        HeapNode node = minHeap.node[index];
        node.key = newKey;
        minHeap.bubbleUp(index);
    }

    public void primMST() {
        boolean[] inHeap = new boolean[this.vertices];
        ResultSet[] resultSet = new ResultSet[this.vertices];
        int[] key = new int[this.vertices];
        HeapNode[] heapNodes = new HeapNode[this.vertices];
        // Set default value of heap nodes resultset and keys
        for (int i = 0; i < this.vertices; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].key = Integer.MAX_VALUE;
            resultSet[i] = new ResultSet();
            resultSet[i].parent = -1;
            inHeap[i] = true;
            key[i] = Integer.MAX_VALUE;
        }
        heapNodes[0].key = 0;
        MinHeap minHeap = new MinHeap(this.vertices);
        for (int j = 0; j < this.vertices; j++) {
            minHeap.insert(heapNodes[j]);
        }
        int i = 0;
        while (!minHeap.isEmpty()) {
            HeapNode extractedNode = minHeap.extractMin();
            int extractedVertex = extractedNode.vertex;
            inHeap[extractedVertex] = false;
            while (i < adjacencylist.get(extractedVertex).size()) {
                Edge edge = adjacencylist.get(extractedVertex).get(i);
                if (inHeap[edge.v]) {
                    int v = edge.v;
                    int w = edge.weight;
                    if (key[v] > w) {
                        key[v] = w;
                        decreaseKey(minHeap, w, v);
                        resultSet[v].parent = extractedVertex;
                        resultSet[v].weight = w;
                    }
                }
                i++;
            }
            i = 0;
        }
        int result = 0;
        System.out.print("\n The Minimum Spanning Tree is:\n\n");
        for (int node = 1; node < this.vertices; ++node) {
            System.out.println(" " + ID(resultSet[node].parent) + " -- " + resultSet[node].weight + " --> " + ID(node));
            result += resultSet[node].weight;
        }
        int cost = result * 100000;
        // Display calculated result
        System.out.println("\n Total minimum weight : " + result);
        System.out.println(" Total minimum cost : " + cost);
    }

    // Display graph nodes and edges
    public void printGraph() {
        System.out.print("\n Graph Adjacency List ");
        for (int i = 0; i < this.vertices; ++i) {
            System.out.print(" \n [" + ID(i) + "] :");
            // iterate edges of i node
            for (int j = 0; j < this.adjacencylist.get(i).size(); ++j) {
                System.out.print("  " + ID(this.adjacencylist.get(i).get(j).v));
            }
        }
    }

    public String ID(int num) {
        String name = "";
        switch (num) {
            case 0:
                name = "Eskildstrup";
                break;
            case 1:
                name = "Haslev";
                break;
            case 2:
                name = "Holbæk";
                break;
            case 3:
                name = "Jærgerspris";
                break;
            case 4:
                name = "Kalundborg";
                break;
            case 5:
                name = "Korsør";
                break;
            case 6:
                name = "Køge";
                break;
            case 7:
                name = "Maribo";
                break;
            case 8:
                name = "Næstved";
                break;
            case 9:
                name = "Ringsted";
                break;
            case 10:
                name = "Slagelse";
                break;
            case 11:
                name = "Nykøbing F";
                break;
            case 12:
                name = "Vordingborg";
                break;
            case 13:
                name = "Roskilde";
                break;
            case 14:
                name = "Sorø";
                break;
            case 15:
                name = "Nakskov";
                break;
        }
        return name;
    }
}
