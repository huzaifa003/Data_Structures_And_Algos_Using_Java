package min_heap_using_generic_array_list;

import java.util.ArrayList;

public class MinHeapGenericArrayList<T extends Comparable<T>> {

    ArrayList<T> maxHeapList;
    int length;

    public MinHeapGenericArrayList(int size) {
        maxHeapList = new ArrayList<>(size+1);
        maxHeapList.add(0,null); //cause first element is empty
        this.length = 0;
    }

    public void swim_min_deheapify(int position)
    {
        while (position > 1 && maxHeapList.get(position).compareTo(maxHeapList.get(position/2))<0)
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
        swim_min_deheapify(length);
    }

    public void display()
    {
        for (int i = 1; i <= length; i++) {
            System.out.println(maxHeapList.get(i));
        }
        System.out.println();
    }

    public void deleteRoot()
    {
        maxHeapList.set(1,maxHeapList.get(length)) ;
        maxHeapList.set(length,null);
        length--;
        structurePostDelete(1);
    }

    public void deleteAt(int position)
    {
        maxHeapList.set(position,maxHeapList.get(length));
        maxHeapList.set(length,null);
        length--;
        structurePostDelete(position);
    }

    private void structurePostDelete(int position)
    {
        if (position >= length || position * 2 + 1 >= length || maxHeapList.get(position).compareTo(maxHeapList.get(position*2)) <0 && maxHeapList.get(position).compareTo(maxHeapList.get(position*2+1)) <0)
            return;
        else
        {
            T left = maxHeapList.get(position*2);
            T right = maxHeapList.get(position*2+1);
            if (left.compareTo(right) < 0 )
            {
                maxHeapList.set(position*2,maxHeapList.get(position));
                maxHeapList.set(position,left);
                structurePostDelete(position*2);
            }
            else
            {
                maxHeapList.set(position*2+1,maxHeapList.get(position));
                maxHeapList.set(position,right);
                structurePostDelete(position*2+1);
            }
        }
    }


}
