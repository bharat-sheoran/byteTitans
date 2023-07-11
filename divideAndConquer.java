public class divideAndConquer {
    public static void printArr(String strarr[]) {
        for (int i = 0; i < strarr.length; i++){
            System.out.print(strarr[i] + " ");
        }
    }

    // merge Sort
    public static void mergeSort( int arr[] , int si , int ei) {
        if(si >= ei){
            return;
        }
        
        int mid = si + (ei - si)/2 ;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr , si , mid , ei);
    }

    public static void merge(int arr[], int si , int mid , int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= ei){
            if (arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //left part
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // right part
        while (j <= ei){
            temp[k++] = arr[j++];
        }

        // Copying the temporary into array
        for (k = 0 ,i = si;  k<temp.length; k++ , i++){
            arr[i] = temp[k];
        }
    }

    // quick Sort 
    public static void quickSort(int arr[] , int si , int ei) {
        if (si >= ei){
            return;
        }
        
        int pIdx = partition(arr , si , ei);
        quickSort(arr, si, pIdx - 1); // left part
        quickSort(arr, pIdx + 1, ei); // right part
    }

    public static int partition(int arr[] , int si , int ei) {
        int pivot = arr[ei];
        int i = si -1 ;

        for (int j = si; j < ei; j++){
            if (arr[j] < pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i ;
    }

    public static int searchSortedRotated(int arr[] , int target, int si , int ei) {
        if (si > ei){
            return -1;
        }
        
        int mid = si + (ei - si)/ 2 ;

        if (arr[mid] == target){
            return mid;
        }

        if (arr[si] <= arr[mid]){
            if (arr[si] <= target && target <= arr[mid]){
                return searchSortedRotated(arr, target, si, mid - 1);
            }else {
                return searchSortedRotated(arr, target, mid + 1, ei);
            }
        }else{
            if (arr[mid] <= target && target <= arr[ei]){
                return searchSortedRotated(arr, target, mid + 1, ei);
            }else {
                return searchSortedRotated(arr, target, si, mid - 1);
            }
        }
    }

    public static int majorityNums(int nums[]) {
        int majorityCount = nums.length / 2;

        for (int i = 0; i < majorityCount; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    count++;
                }
            }
            if (count >= majorityCount){
                return nums[i];
            }
        }
        return -1;
    }

    public static int invCount(int arrnums[]) {
        int count = 0;
        for (int i = 0; i < arrnums.length - 1; i++){
            for (int j = i + 1; j < arrnums.length; j++){
                if (arrnums[i] > arrnums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int arr[]= {4,5,6,7,0,1,2};
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);
        // System.out.println(searchSortedRotated(arr, 3, 0, arr.length - 1));
        // String strarr[] = {"sun" , "earth" , "mars" , "mercury"};
        // stringMergeSort(strarr, 0, strarr.length);
        // printArr(strarr);
        // int nums[] = {3,2,3,2,2,2};
        // System.out.println(majorityNums(nums));

        int arrnums[] = {2, 4, 1, 3, 5};
        System.out.println(invCount(arrnums));
    }
}
