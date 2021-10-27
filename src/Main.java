public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(16);
        //We fill the graph with our data
        g.addEdge(0, 7, 28);
        g.addEdge(0, 11, 13);
        g.addEdge(0, 12, 25);
        g.addEdge(0, 5, 60);
        g.addEdge(1,6, 24);
        g.addEdge(1, 8, 25);
        g.addEdge(1, 9, 19);
        g.addEdge(1, 13, 47);
        g.addEdge(1, 10, 48);
        g.addEdge(1, 14, 34);
        g.addEdge(1, 12, 40);
        g.addEdge(2, 3, 34);
        g.addEdge(2, 4, 44);
        g.addEdge(2, 5, 66);
        g.addEdge(2, 9, 36);
        g.addEdge(2, 13, 32);
        g.addEdge(2, 10, 46);
        g.addEdge(2, 14, 34);
        g.addEdge(3, 5, 94);
        g.addEdge(3, 6, 58);
        g.addEdge(3, 9, 56);
        g.addEdge(3, 13, 33);
        g.addEdge(3, 10, 74);
        g.addEdge(3, 14, 63);
        g.addEdge(4, 9, 62);
        g.addEdge(4, 13, 70);
        g.addEdge(4, 10, 39);
        g.addEdge(4, 14, 51);
        g.addEdge(5, 8, 45);
        g.addEdge(5, 10, 20);
        g.addEdge(6, 8, 35);
        g.addEdge(6, 9, 28);
        g.addEdge(6, 13, 25);
        g.addEdge(6, 12, 60);
        g.addEdge(7, 15, 27);
        g.addEdge(7, 11, 26);
        g.addEdge(8, 13, 57);
        g.addEdge(8, 9, 26);
        g.addEdge(8, 10, 37);
        g.addEdge(8, 14, 32);
        g.addEdge(8, 12, 28);
        g.addEdge(9, 13, 31);
        g.addEdge(9, 14, 15);
        g.addEdge(9, 12, 58);
        g.addEdge(10, 14, 14);

        //We call the Prims algorithm
        g.primMST();
    }
}