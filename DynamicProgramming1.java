import java.util.*;

public class DynamicProgramming1 {

    public static int coinChange(int coins[] , int sum){
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        // initialisation
        for(int i = 0; i< n + 1; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j < sum + 1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i< n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(coins[i - 1] <= j){  // Valid
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }else{   // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void print(int dp[][]){
        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int maxRodProfit(int length[] , int price[] , int totRod){
        int n = length.length;
        int dp[][] = new int[n + 1][totRod + 1];

        for(int i = 1; i< n + 1; i++){
            for(int j = 1; j < totRod + 1; j++){
                if(length[i - 1] <= j){
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][totRod];
    }

    public static int lcs(String str1 , String str2 , int n , int m){
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i< n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                dp[i][j] = -1;
            }
        }
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n - 1) == str2.charAt(m - 1)){
            dp[n][m] = lcs(str1, str2, n - 1, m - 1) + 1;
            return dp[n][m];
        }else{
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    public static int lcsTab(String str1 , String str2 , int n , int m){
        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(str1.charAt(i - 1)== str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static int longestSubstring(String str1 , String str2 , int n , int m){
        int dp[][] = new int[n + 1][m + 1];
        int max = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        print(dp);
        return max;
    }
    public static void main(String[] args) {
        // int coins[] = {2,5,3,6};
        // int sum = 10;  // ans = 4
        // System.out.println(coinChange(coins, sum));

        // int length[] = {1,2,3,4,5,6,7,8};
        // int price[] = {1,5,8,9,10,17,17,20};
        // int totRod = 8;
        // System.out.println(maxRodProfit(length, price, totRod));

        String str1 = "abcde";
        String str2 = "abgce";
        // System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        // System.out.println(lcsTab(str1, str2, str1.length(), str2.length()));
        // System.out.println(longestSubstring(str1, str2, str1.length(), str2.length()));
        
    }
}
