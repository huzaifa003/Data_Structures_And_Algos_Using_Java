package sort_for_arrays;

public class DoubleSortArray {

    public void printArray(double[] arr)
    {
        System.out.println("------------------------START-------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("-------------------------END-----------------");

    }

    public void printArray(double[] arr,String args)
    {
        System.out.println("--------------------START of "+ args + "-----------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("--------------------END of "+ args + "--------");

    }

    public void selectionSort(double[] arr) //Selection sort works by swapping minimum value at each iteration
    {
        int minimumIndex;
        double temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minimumIndex = i; //getting minimum index as i
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minimumIndex]) //finding index of smallest number
                {
                    minimumIndex = j;
                }
            }
            temp = arr[minimumIndex]; //swapping using minimum value index
            arr[minimumIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public void insertionSort(double[] arr)
    {
        //Insertion Sort works like cards we have one sorted and one unsorted array
        //we simply adjust the pieces of unsorted array into sorted array
        //it is like the opposite side of bubble sort

        double temp; //swap variable
        for (int i = 1; i < arr.length; i++) { //unsorted array representation
            int j = i-1;

            while (j>=0) //sorted array representation
            {

                if (arr[j+1] < arr[j]) //j+1 = i in first iteration, after that it keeps on swapping elements till j = 0
                {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                j = j-1;
            }
        }
    }

    public double[] mergeSortedArrays(double[] arr1,double[] arr2, boolean isSorted)
    {
        if (!isSorted) {
            selectionSort(arr1);
            selectionSort(arr2);
        } //sorting both arrays if they arent sorted
        double result[] = new double[arr1.length+arr2.length];

        int i = 0,j = 0,k = 0; //i,j,k are loop variables for arr1, arr2, result respectively
        if (arr1.length == arr2.length) //checking if they are of equal length
        {
            while (i < arr1.length && j < arr2.length ) //running both arr1 and arr2 pointers till they reach end
            {

                if (arr1[i] < arr2[j])
                {
                    result[k] = arr1[i];
                    i++; //incrementing only if that element of array is placed in resultant array
                }
                else
                {
                    result[k] = arr2[j];
                    j++; //incrementing only if that element of array is placed in resultant array
                }
                k++; //incrementing resultant pointer always
            }
            //since we dont know which array will be exhausted first hence we use both i and j variables to fulfill the remaining elements of each array
            while (i < arr1.length) //placing the remaining elements of arr1 in resultant array
            {
                result[k] =  arr1[i];
                i++; k++;
            }

            while (j < arr2.length) //placing resultant elements of arr2 in resultant array
            {
                result[k] = arr2[j];
                j++; k++;
            }


        }
        else
        {
            System.out.println("Not of equal length" + arr1.length + "   "+ arr2.length);
        }

        return result;
    }
    public void mergeSort(double arr[])
    {
        double[] temp = new double[arr.length];
        mergeSort(arr,temp,0,arr.length-1);
        printArray(arr);
    }
    public void mergeSort(double arr[], double temp[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(arr,temp, l, m); //dividing the left arrays
            mergeSort(arr,temp, m + 1, r); //dividing the right arrays

            // Merge the sorted halves
            mergeSortedArrays(arr,temp,l,m,r);
        }
    }

    private void mergeSortedArrays(double[] arr, double[] temp, int low, int mid, int high) { //this algo merges two arrays into temp array passed and lower higher balues
        for(int i = low; i <= high; i++){
            temp[i] = arr[i];
        }
        int i = low; // traverse left sorted subarray
        int j = mid + 1; // traverse right sorted subarray
        int k = low; // will merge both arrays into original array (arr)

        while(i <= mid && j <= high){
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            arr[k] = temp[i];
            k++;
            i++;
        }

        while (j <= high)
        {
            arr[k] = temp[j];
            k++; j++;
        }
    }

}
