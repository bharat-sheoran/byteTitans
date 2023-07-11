import java.util.Arrays;

public class DynamicProgramming4 {
    public static boolean isMatch(String s , String p){
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        // initialise
        dp[0][0] = true;

        for(int i = 1; i < n + 1; i++){
            dp[i][0] = false;
        }

        for(int j = 1; j < m + 1; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 1];
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];   // j - 1 --> ignore || i - 1 --> match
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }

    public static int catalan(int n , int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += catalan(i , dp)*catalan(n - i - 1 , dp);
        }
        return dp[n] = ans;
    }

    public static int catalanTab(int n , int dp[]){
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i - 1; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static int countBST(int n , int dp[]){   // Same as Catalan number
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j]  *  dp[i - j - 1];
                        //left      //right        BSTs
            }
        }
        return dp[n];
    }

    public static int mountainRanges(int n , int dp[]){      // Also same as catatlan number
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        // String s = "abc";
        // String p = "**d";  // True
        // System.out.println(isMatch(s, p));
        int n = 3;
        int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(catalan(n , dp));
        // System.out.println(catalanTab(n, dp));
        // System.out.println(countBST(n, dp));
        System.out.println(mountainRanges(n, dp));
    }
}
