package min_heap_using_generic_array_list;

public class Runner {
    public static void main(String[] args) {
        MinHeapGenericArrayList<Integer> heap = new MinHeapGenericArrayList<>(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.display();

        heap.deleteRoot();
        heap.display();
    }
}
