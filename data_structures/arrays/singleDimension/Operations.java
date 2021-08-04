package singleDimension;

public class Operations {
    public void setAt(Object []arr, int index, Object data)
    {
        if (index > arr.length)
        {
            throw new ArrayIndexOutOfBoundsException("Index Out of Bounds");
        }
        arr[index] = data;
    }

    public void insertAt(Object []arr, int index, Object data)
    {
        if (index >= arr.length-1)
        {
            throw new ArrayIndexOutOfBoundsException("Index Out of Bounds");
        }
        for (int i = arr.length-1; i >= index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = data;


    }

    public Object[] resizeArray(Object []arr)
    {
        Object[] temp = new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public Object findMin(Object[]arr)
    {
        Object min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] instanceof Double || arr[i] instanceof Integer || arr[i] instanceof Float)
            {
                if ((Double)arr[i]< (Double)min)
                {
                    min = arr[i];
                }
            }

            else if (arr[i] instanceof String)
            {
                if (((String) arr[i]).compareTo((String) min)<0)
                {
                    min = arr[i];
                }
            }
        }
        return min;
    }
}
