import java.util.Arrays;

public class DynamicProgramming {

    public static int fibo(int n , int f[]){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }

        f[n] = fibo(n - 1 , f) + fibo(n - 2 , f);
        return f[n];
    }

    public static int fiboTabulation(int n){
        int dp[] = new int [n + 1];
        dp[1] = 1;
        for(int i = 2; i<= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Memoization  ==> O(n)  |||| rec = O(2^n)
    public static int countWays(int n , int ways[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = countWays(n - 1 , ways) + countWays(n - 2 , ways);
        return ways[n];
    }

    public static int countWaysTab(int n){
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i<= n; i++){
            if(i == 1){
                dp[i] = dp[i - 1];
            }else{
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static int zeroOneKnapsack(int val[] , int wt[] , int W , int n , int dp[][]){
        if(W == 0 || n == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(W >= wt[n - 1]){ // Valid condition
            int ans1 = val[n - 1] + zeroOneKnapsack(val, wt, W - wt[n - 1], n - 1 , dp);  // Include
            int ans2 = zeroOneKnapsack(val, wt, W, n - 1 , dp);  // Exclude
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = zeroOneKnapsack(val, wt, W, n - 1 , dp);
            return dp[n][W];
        }
    }

    public static void print(boolean dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsackTab(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for(int i = 0; i< dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < W + 1; j++){
                int v = val[i - 1];
                int w = wt[i - 1];

                if(w <= j){   // Valid
                    int incAns = v + dp[i - 1][j - w];
                    int excAns = dp[i - 1][j];
                    dp[i][j] = Math.max(incAns, excAns);
                }else{
                    int excAns = dp[i - 1][j];
                    dp[i][j] = excAns;
                }
            }
        }
        // print(dp);
        return dp[n][W];
    }

    public static boolean targetSumSubset(int arr[] , int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for(int i = 0; i< n + 1; i++){
            // i = items
            dp[i][0] = true;
        }

        for(int i = 1; i< n + 1; i++){
            for(int j = 1; j< sum + 1; j++){
                int v = arr[i - 1];
                if(v <= j && dp[i - 1][j - v] == true){
                    dp[i][j] = true;
                }else if(dp[i - 1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public static int unboundedknapsackTab(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for(int i = 0; i< dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < W + 1; j++){
                int v = val[i - 1];
                int w = wt[i - 1];

                if(w <= j){   // Valid
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                }else{
                    int excAns = dp[i - 1][j];
                    dp[i][j] = excAns;
                }
            }
        }
        // print(dp);
        return dp[n][W];
    }

    
    public static void main(String[] args) {
        // int n = 5;
        // int ways[] = new int[n + 1];
        // Arrays.fill(ways, -1);
        // System.out.println(fibo(n , f));
        // System.out.println(fiboTabulation(n));
        // System.out.println(countWays(n , ways));
        // System.out.println(countWaysTab(n));

        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        // int dp[][] = new int[val.length + 1][W + 1];
        // for(int i = 0; i< dp.length; i++){
        //     for(int j = 0; j < dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(zeroOneKnapsack(val, wt, W, val.length , dp));
        // System.out.println(knapsackTab(val, wt, W));

        // int arr[] = {4,2,7,1,3};
        // int sum = 5;
        // System.out.println(targetSumSubset(arr, sum));
        System.out.println(unboundedknapsackTab(val, wt, W));
        System.out.println(knapsackTab(val, wt, W));




    }
}
