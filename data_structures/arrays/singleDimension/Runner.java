package singleDimension;

public class Runner {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Object [] arr = new Object[5];
        arr = operations.resizeArray((Object[]) arr);
        arr[8] = 4;
//        System.out.println(arr.length);

        operations.insertAt(arr,8,5);
        System.out.println(arr[8]);
        System.out.println(arr[9]);

        operations.setAt(arr,8,1);
        System.out.println(arr[8]);
        System.out.println(arr[9]);

        System.out.println(operations.findMin(arr));

    }
}
