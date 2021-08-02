package Max_Heap_Using_ArrayList_Generics;

import java.util.ArrayList;

public class MaxHeapGenericArrayList<T extends Comparable<T>> {
    ArrayList<T>maxHeapList;
    int length;

    public MaxHeapGenericArrayList(int size) {
        maxHeapList = new ArrayList<>(size+1);
        maxHeapList.add(0,null); //cause first element is empty
        this.length = 0;
    }

    public void swim_max_heapify(int position)
    {
        while (position > 1 && maxHeapList.get(position).compareTo(maxHeapList.get(position/2))>0)
        {
            T temp = maxHeapList.get(position/2);
            maxHeapList.set(position/2,maxHeapList.get(position));
            maxHeapList.set(position,temp);
            position = position/2;
        }
    }

    public void insert(T data)
    {
        this.length++;
        maxHeapList.add(this.length,data); //here we need index cause first index is supposed to be empty!
        swim_max_heapify(length);
    }

    public void display()
    {
        for (int i = 1; i < length+1; i++) {
            System.out.println(maxHeapList.get(i));
        }
        System.out.println();
    }
}
