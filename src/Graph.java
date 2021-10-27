import java.util.ArrayList;

public class Graph{
    int vertices;
    public ArrayList<ArrayList<Edge>> adjacencylist;

    public Graph(int vertices){ //creation of graph
        this.vertices = vertices;
        this.adjacencylist = new ArrayList<>(vertices);
        for (int i = 0; i < this.vertices; ++i){
            this.adjacencylist.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight){ //To add an edge to the graph
        adjacencylist.get(u).add(new Edge(u, v, weight));
        if (u == v){ // self loop in case of an error
            return;
        }
        adjacencylist.get(v).add(new Edge(v, u, weight)); //because the road goes both ways
    }

    public void decreaseKey(MinHeap minHeap, int newKey, int vertex){ //decrease the number of nodes in our Heap after taking the minimum out
        int index = minHeap.indexes[vertex];
        HeapNode node = minHeap.node[index];

        node.key = newKey;
        minHeap.bubbleUp(index);
    }

    public void primMST(){ //Prims algorithm
        boolean[] inHeap = new boolean[this.vertices];
        ResultSet[] resultSet = new ResultSet[this.vertices];
        int[] key = new int[this.vertices];
        HeapNode[] heapNodes = new HeapNode[this.vertices];

        // Set default value of heap nodes resultset and keys
        for (int i = 0; i < this.vertices; i++){
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].key = Integer.MAX_VALUE; //setting it as infinite
            resultSet[i] = new ResultSet();
            resultSet[i].parent = -1;
            inHeap[i] = true;
            key[i] = Integer.MAX_VALUE; //setting it as infinite
        }

        heapNodes[0].key = 0;
        MinHeap minHeap = new MinHeap(this.vertices);

        //We fill our heap
        for (int j = 0; j < this.vertices; j++){
            minHeap.insert(heapNodes[j]);
        }

        int i = 0;

        while(!minHeap.isEmpty()){
            HeapNode extractedNode = minHeap.extractMin(); //we get the smallest element
            int extractedVertex = extractedNode.vertex;
            inHeap[extractedVertex] = false;

            //we go through our adjacency list
            while(i < adjacencylist.get(extractedVertex).size()){
                Edge edge = adjacencylist.get(extractedVertex).get(i);

                if(inHeap[edge.v]){
                    int v = edge.v;
                    int w = edge.weight;
                    if(key[v] > w){
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

        //We display our results
        int result = 0;
        System.out.print("Here is the list of cities and roads you will have to complete your electricity grid:\n");
        for (int node = 1; node < this.vertices; ++node) {
            System.out.println(" " + ID(resultSet[node].parent) + " ----> " + ID(node));
            result += resultSet[node].weight;
        }

        int cost = result * 100000;
        System.out.println("\n In totality, we will cover " + result + "km.\n"); // Display distance
        System.out.println(" This electrical grid will cost " + cost + " dkk."); //Display cost
    }

    //We use a switch case to identify each index to the name of a city
    public String ID(int num){
        String name = switch (num) {
            case 0 -> "Eskildstrup";
            case 1 -> "Haslev";
            case 2 -> "Holbæk";
            case 3 -> "Jærgerspris";
            case 4 -> "Kalundborg";
            case 5 -> "Korsør";
            case 6 -> "Køge";
            case 7 -> "Maribo";
            case 8 -> "Næstved";
            case 9 -> "Ringsted";
            case 10 -> "Slagelse";
            case 11 -> "Nykøbing F";
            case 12 -> "Vordingborg";
            case 13 -> "Roskilde";
            case 14 -> "Sorø";
            case 15 -> "Nakskov";
            default -> "";
        };

        return name;
    }
}
