package priority_queue_or_heap.max_heap_using_double_Using_Array;
/*
    * Max Heap is like a queue
    * it's normally implemented by the arrays
    * in Max Heap the child is smaller than its parent
    * formula for parent at a specific position is position/2th index
    * the 0th index is always kept empty in an array!
    * The values are inserted in the form of level order tree
 */
public class MaxHeap {
    double[] heap;
    int length;

    public MaxHeap(int size) {
        this.heap = new double[size + 1];
        length = 0;
    }

    public void maxHeapify(int position) { //if child is greater than we swap the parent and child!
        while (position > 1 && heap[position / 2] < heap[position]) {
            double temp = heap[position];
            heap[position] = heap[position / 2];
            heap[position / 2] = temp;
            position = position / 2; //reaching parent of every child
        }
    }

    public void insert(float data) {
        this.length++;
        heap[this.length] = data;
        maxHeapify(this.length); //swapping the data from LAST index aka length until child is smaller than parent
    }

    public void display() {
        for (int i = 1; i <= length + 1; i++) {
            System.out.println(heap[i]); //printing from index 1 as 0 index is always empty
        }

    }

    public void deleteRoot()
    {
        heap[1] = heap[length];
        heap[length] = 0.0f;
        length--;

    }

    public void structurePostDelete(int position)
    {
        if (position == length)
            return;
        else
        {
            double left = heap[2 * position];
            double right = heap[2 * position+1];
            if (left > right)
            {
                heap[2*position] = heap[position];
                heap[position] = left;
                structurePostDelete(position*2);
            }
            else
            {
                heap[2*position+1] = heap[position];
                heap[position] = left;
                structurePostDelete(position*2+1);
            }
        }
    }
}
