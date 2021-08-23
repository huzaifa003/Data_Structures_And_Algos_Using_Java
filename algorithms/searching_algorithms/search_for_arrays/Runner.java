package search_for_arrays;

 class Runner {
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1,2,3,4,5,6,7,8,9};

        SearchArrays searchArrays = new SearchArrays();

        System.out.println(searchArrays.linearSearchByIndex(arr,1));

        System.out.println(searchArrays.linearSearchByValue(arr,1));

        System.out.println(searchArrays.binarySearch(arr,1));
    }
}
