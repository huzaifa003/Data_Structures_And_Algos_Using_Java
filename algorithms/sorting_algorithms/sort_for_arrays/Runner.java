package sort_for_arrays;

  class Runner {
    public static void main(String[] args) {
        double [] arr = new double[]{-1,10,-2,4.7,63.7};

        DoubleSortArray doubleSortArray = new DoubleSortArray();
        doubleSortArray.printArray(arr,"unsorted");
        doubleSortArray.selectionSort(arr);
        doubleSortArray.printArray(arr,"Selection Sorted");

        arr = new double[]{-1,10,-2,4.7,63.7};

        doubleSortArray.printArray(arr,"unsorted before insertion");
        doubleSortArray.insertionSort(arr);
        doubleSortArray.printArray(arr,"sorted after insertion");

        double []arr2 = new double[]{-4,-2,1.2,-5,-6,5,2};
        double []arr1 = new double[]{-1,10,-2,4.7,6,3.7,2.4};

//        doubleSortArray.printArray(doubleSortArray.mergeSortedArrays(arr1,arr2,false));


        doubleSortArray.mergeSort(arr2);


    }
}
