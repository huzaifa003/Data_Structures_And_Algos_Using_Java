package for_arrays;

public class SearchArrays {
    public Integer linearSearchByValue(Object arr[], Object data)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(data))
            {
                return i;
            }
        }
        return null;
    }

    public Object linearSearchByIndex(Object arr[], int index)
    {
        if (index < arr.length)
        {
            return arr[index];
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    public Integer binarySearch(Object arr[], Object data)
    {
        int left = 0;
        int right = arr.length-1;
        int middle;


        if (arr[0] instanceof Double || arr[0] instanceof Integer || arr[0] instanceof Float)
        {
            while (left <= right)

            {
                middle = (left + right)/2;
                if (convertObjectToDouble(arr[middle] ) == convertObjectToDouble(data))
                {
                    return middle;
                }
                else if (convertObjectToDouble(arr[middle] ) > convertObjectToDouble(data))
                {
                    right = middle -1; //ignoring right half if data is greater
                }
                else
                {
                    left = middle +1 ; // ignoring left half if data is small
                }
            }
        }
        else if (arr[0] instanceof  String)
        {
            while (left != right)

            {
                middle = (left + right) /2;
                if (convertObjectToString(arr[middle] ) .equals(convertObjectToString(data)) )
                {
                    return middle;
                }
                else if (convertObjectToString(arr[middle]).compareTo(convertObjectToString(data)) < 0)
                {
                    right = middle -1; //ignoring right half if data is greater
                }
                else
                {
                    left = middle +1 ; // ignoring left half if data is small
                }
            }
        }

        return null;
    }

    private double convertObjectToDouble(Object element)
    {
        return Double.parseDouble(element.toString());
    }

    private String convertObjectToString(Object element)
    {
        return element.toString();
    }
}
