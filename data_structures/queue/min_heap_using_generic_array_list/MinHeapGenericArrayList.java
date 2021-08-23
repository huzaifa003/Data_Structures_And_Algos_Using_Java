package min_heap_using_generic_array_list;

import java.util.ArrayList;

public class MinHeapGenericArrayList<T extends Comparable<T>> {

    ArrayList<T> minHeapList;
    int length;

    public MinHeapGenericArrayList(int size) {
        minHeapList = new ArrayList<>(size+1);
        minHeapList.add(0,null); //cause first element is empty
        this.length = 0;
    }

    public void swim_min_deheapify(int position)
    {
        while (position > 1 && minHeapList.get(position).compareTo(minHeapList.get(position/2))<0)
        {
            T temp = minHeapList.get(position/2);
            minHeapList.set(position/2, minHeapList.get(position));
            minHeapList.set(position,temp);
            position = position/2;
        }
    }

    public void insert(T data)
    {
        this.length++;
        minHeapList.add(this.length,data); //here we need index cause first index is supposed to be empty!
        swim_min_deheapify(length);
    }

    public void display()
    {
        for (int i = 1; i <= length; i++) {
            System.out.println(minHeapList.get(i));
        }
        System.out.println();
    }

    public void deleteRoot()
    {
        minHeapList.set(1, minHeapList.get(length)) ;
        minHeapList.set(length,null);
        length--;
        structurePostDelete(1);
    }

    public void deleteAt(int position)
    {
        minHeapList.set(position, minHeapList.get(length));
        minHeapList.set(length,null);
        length--;
        structurePostDelete(position);
    }

    private void structurePostDelete(int position)
    {
        if (position >= length || position * 2 + 1 >= length || minHeapList.get(position).compareTo(minHeapList.get(position*2)) <0 && minHeapList.get(position).compareTo(minHeapList.get(position*2+1)) <0)
            return;
        else
        {
            T left = minHeapList.get(position*2);
            T right = minHeapList.get(position*2+1);
            if (left.compareTo(right) < 0 )
            {
                minHeapList.set(position*2, minHeapList.get(position));
                minHeapList.set(position,left);
                structurePostDelete(position*2);
            }
            else
            {
                minHeapList.set(position*2+1, minHeapList.get(position));
                minHeapList.set(position,right);
                structurePostDelete(position*2+1);
            }
        }
    }


}
