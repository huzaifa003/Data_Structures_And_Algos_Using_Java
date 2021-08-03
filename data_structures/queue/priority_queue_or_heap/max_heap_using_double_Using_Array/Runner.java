package priority_queue_or_heap.max_heap_using_double_Using_Array;

public class Runner {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(8);

        maxHeap.display();

        maxHeap.deleteRoot();
        maxHeap.display();
    }
}
