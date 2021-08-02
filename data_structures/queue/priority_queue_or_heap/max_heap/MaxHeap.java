package priority_queue_or_heap.max_heap;

public class MaxHeap {
    Object heap[];
    int length;

    public MaxHeap(int size) {
        this.heap = new Object[size + 1];
        length = 0;
    }
}
