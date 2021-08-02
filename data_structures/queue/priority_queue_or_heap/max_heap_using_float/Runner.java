package priority_queue_or_heap.max_heap_using_float;

public class Runner {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(4);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);

        maxHeap.display();
    }
}
