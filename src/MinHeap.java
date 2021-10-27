class HeapNode {
    int vertex;
    int key;
}

class ResultSet {
    int parent;
    int weight;
}

public class MinHeap {
    int capacity;
    int currentSize;
    HeapNode[] node;
    int[] indexes;
    public MinHeap(int capacity) {
        this.capacity = capacity;
        node = new HeapNode[capacity + 1];
        indexes = new int[capacity];
        node[0] = new HeapNode();
        node[0].key = Integer.MIN_VALUE;
        node[0].vertex = -1;
        currentSize = 0;
    }
    public void swap(int a, int b) {
        HeapNode temp = node[a];
        node[a] = node[b];
        node[b] = temp;
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public int heapSize() {
        return currentSize;
    }
    public void bubbleUp(int pos) {
        int parentIdx = pos / 2;
        int currentIdx = pos;
        while (currentIdx > 0 && node[parentIdx].key > node[currentIdx].key) {
            HeapNode currentNode = node[currentIdx];
            HeapNode parentNode = node[parentIdx];
            indexes[currentNode.vertex] = parentIdx;
            indexes[parentNode.vertex] = currentIdx;
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx / 2;
        }
    }
    public void insert(HeapNode x) {
        currentSize++;
        int idx = currentSize;
        node[idx] = x;
        indexes[x.vertex] = idx;
        bubbleUp(idx);
    }
    public HeapNode extractMin() {
        HeapNode min = node[1];
        HeapNode lastNode = node[currentSize];
        indexes[lastNode.vertex] = 1;
        node[1] = lastNode;
        node[currentSize] = null;
        sinkDown(1);
        currentSize--;
        return min;
    }
    public void sinkDown(int k) {
        int smallest = k;
        // left child
        int leftChild = 2 *k;
        // right child
        int rightChild = 2 *k + 1;
        if (leftChild < heapSize() && node[smallest].key > node[leftChild].key)
        {
            smallest = leftChild;
        }
        if (rightChild < heapSize() && node[smallest].key > node[rightChild].key)
        {
            smallest = rightChild;
        }
        if (smallest != k)
        {
            HeapNode smallestNode = node[smallest];
            HeapNode kNode = node[k];
            indexes[smallestNode.vertex] = k;
            indexes[kNode.vertex] = smallest;
            swap(k, smallest);
            sinkDown(smallest);
        }
    }
}
