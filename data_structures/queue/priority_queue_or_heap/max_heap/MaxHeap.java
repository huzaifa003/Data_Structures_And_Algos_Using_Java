package priority_queue_or_heap.max_heap;

public class MaxHeap<T> {
    T heap[];
    int length;

    public MaxHeap(int size, int length) {
        this.heap = (T[]) new Object[size + 1];
        this.length = length;
    }
}
