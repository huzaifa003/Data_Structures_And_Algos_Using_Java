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
    
    public void insert(Object []arr, Object data)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
            {
                arr[i] = data;
                break;
            }
        }
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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
            {
                min = arr[i];
                break;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] instanceof Double || arr[i] instanceof Integer || arr[i] instanceof Float)
            {
                if ((Double.parseDouble(arr[i].toString())< (Double.parseDouble(min.toString()))))
                {
                    min = arr[i];
                }
            }

            else if (arr[i] instanceof String)
            {
                if (arr[i].toString().compareTo(min.toString())<0)
                {
                    min = arr[i];
                }
            }
        }
        return min;
    }

    public void displayArray(Object []arr)
    {
        seperator();
        for (Object data :
                arr) {
            if (data != null)
            {
                System.out.println(data);
            }
        }
        seperator();
    }

    public void displayArrayWithIndex(Object []arr)
    {
        seperator();
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] != null)
            {
                System.out.println("Index: " + i  + "  || Value :   " + arr[i]);
            }
        }
        seperator();
    }

    public void reverseArray(Object []arr)
    {
        Object temp;
        for (int i = 0,j = arr.length-1; i < arr.length/2; i++,j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private void seperator()
    {
        System.out.println("-----------------------------------------");
    }
}
