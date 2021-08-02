package priority_queue_or_heap.max_heap_using_float;

public class MaxHeap {
    float heap[];
    int length;

    public MaxHeap(int size) {
        this.heap = new float[size + 1];
        length = 0;
    }

    public void maxHeapify(int position)
    {
        while (position > 1 &&  heap[position/2] < heap[position] )
        {
            float temp =  heap[position];
            heap[position] = heap[position/2];
            heap[position/2] = temp;
            position  = position/2;
        }
    }

    public void insert(float data)
    {
        length++;
        heap[length] = data;
        maxHeapify(length);
    }

    public void display()
    {
        for (Object data :
                heap) {
            System.out.println(data);
        }
        System.out.println();
    }
}
