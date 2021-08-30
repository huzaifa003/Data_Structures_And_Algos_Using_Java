package basics.kadanes_algorithm;

public class MaxSubArray {
    public static int maxSubArray(int[] arr) {
        int currentMax = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMax = currentMax + arr[i]; //getting sum of current array elements with current element which is being pointed by i
            if (currentMax < arr[i]) { //if that sum (yes this  sum includes the current element) < current element
                currentMax = arr[i]; //create a new sub-array and discard the previous one.
            }

            if (maxSoFar < currentMax) { //if currentMax is greater than the maximum value of sum we have found
                maxSoFar = currentMax; //update the maxSoFar
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{4, 4, 3, -2, 6, -12, 7, -1, 6}));
    }
}
