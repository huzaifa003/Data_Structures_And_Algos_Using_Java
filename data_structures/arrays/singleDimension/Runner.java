package singleDimension;

public class Runner {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Object [] arr = new Object[5];
        arr = operations.resizeArray((Object[]) arr);
        arr[8] = 4;
        System.out.println( "Length of arr : "+arr.length );

        operations.insertAt(arr,8,5);
        operations.displayArrayWithIndex(arr);

        operations.setAt(arr,8,1);
        operations.displayArrayWithIndex(arr);

        String []arrString= new String[2];
        operations.insert(arrString,"Hello");
        operations.insert(arrString,"World");
        operations.displayArrayWithIndex(arrString);

        operations.displayArrayWithIndex(arr);
        operations.reverseArray(arr);
        operations.displayArrayWithIndex(arr);

        operations.displayArrayWithIndex(arrString);
        operations.reverseArray(arrString);
        operations.displayArrayWithIndex(arrString);

        System.out.println("Min Value of arrString : "+operations.findMin(arrString));

    }
}
