import java.util.*;
import java.util.Locale.LanguageRange;

public class Arrays_1{

    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }

    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == key){
                return i;
            }
        }
        return -1;
    }
        //largeest and smallest value
    public static int  getLargest(int numbers[]) {
        // int largestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++){
            if ( smallestNumber > numbers[i]){
                smallestNumber = numbers[i];
            }
        }
        return smallestNumber;
    }

    public static int binarySearch(int numbers[] , int key) {
        int start = 0, end = numbers.length -1;

        while( start <= end){
            int mid = (start + end )/2;

            if (numbers[mid] == key){
                return mid;
            }
            if (numbers[mid] < key){ //right
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    public static void reverse(int numbers[]) {
        int first = 0 , last = numbers.length-1;

        while(first < last){
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }

    public static void arrayPair(int numbers[]){
        int tp = 0;
        for (int i = 0; i <numbers.length; i++){
            int curr = numbers[i];
            for (int j= i+1; j < numbers.length; j++){
                System.out.print("(" + curr + "," + numbers[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs:" + tp);
    }

    public static void subArray(int numbers[]) {
        int ts = 0;
        for (int i = 0; i < numbers.length; i++){
            int start = i;
            for (int j = i; j < numbers.length; j++){
                int end = j;
                for (int k = start; k <= end; k++){
                    System.out.print(numbers[k] + "+" );
                    ts++;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total subarrays are = " + ts);
    }
    
    public static void maxSubArraySum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++){
            int start = i;
            for (int j = i; j < numbers.length; j++){
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++){
                    currSum += numbers[k];
                }
                System.out.println(currSum);
                if (maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maximum sum is = " + maxSum);
    }
    
    public static void maxSubArraySumPrefix(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        //calculate prefix array
        prefix[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++){
            int start = i;
            for (int j = i; j < numbers.length; j++){
                int end = j;
                currSum = start == 0? prefix[end]: prefix[end] - prefix[start -1];
                

                if (maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maximum sum is = " + maxSum);
    }

    public static void maxSubArraySumKadane(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs+ numbers[i];
            if (cs < 0){
                cs = 0;
            }
        }
        ms = Math.max(ms, cs);
        System.out.println(ms);
    }

    public static int waterTrapped(int height[]) {
        int trappedWater = 0;
        int waterLevel = 0;
        //Calculate the max left value :- array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        //Calculate the max right value :- array

        int rightMax[] = new int [height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length - 2; i >=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        //loop
        for (int i = 0; i < height.length; i++){
            //calculate min [leftmax, rigthmax]
            waterLevel = Math.min(leftMax[i], rightMax[i]);
            //trapped water = waterlevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static int profitStock(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++){
            if (buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static boolean nums(int nums[]) {
        for (int i = 0; i < nums.length; i++ ){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static int numsIndex(int nums[]) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[i+1]){
                return nums[i+1];
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        // input in array
        
        // int marks[] = new int[100];
        
        // Scanner sc = new Scanner(System.in);
        
        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();
        // System.out.println(marks[0]);
        // System.out.println(marks[1]);
        // System.out.println(marks[2]);
        // int marks[] = {97 , 98 , 99};
        // update(marks);
        // for (int i = 0; i < marks.length; i++){
        //     System.out.print(marks[i] + " ");
        // }
        // System.out.println();

        int height[] = {10,2,4,6,8,9};
        int key = 10;

        // int index = linearSearch(height, key);
        // if (index == -1){
        //     System.out.println("NOT FOUND");
        // }else{
        //     System.out.println(index);
        // }

        // System.out.println(getLargest(height));

        // System.out.println(binarySearch(height, key));

        // reverse(height);
        // for (int i =0; i < height.length; i++){
        //     System.out.print(height[i] +" ");
        // }
        // System.out.println();

        // arrayPair(height);

        // subArray(height);
        // maxSubArraySum(numbers);
        // maxSubArraySumPrefix(numbers);
        // maxSubArraySumKadane(numbers);
        // System.out.println(waterTrapped(height));

        // int prices[] = {7,1,5,3,6,4};
        // System.out.println(profitStock(prices));

        // int nums[] = {4,  5, 6, 7, 0, 1, 2 };
        // System.out.println(nums(nums));

        // System.out.println(numsIndex(nums));
    }
}