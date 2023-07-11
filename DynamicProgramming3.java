import java.util.*;

public class DynamicProgramming3 {
    public static int lcs(int arr1[] , int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(arr1[i - 1] == arr2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public static int lis(int arr1[]){
        HashSet<Integer> set = new HashSet<>();  // To take only unique elements
        for(int i = 0; i< arr1.length; i++){
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);

        return lcs(arr1 , arr2);
    }

    public static void print(int dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int editDist(String word1 , String word2){
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0;  i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i = 1; i < n + 1;  i++){
            for(int j = 1; j < m + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int add = dp[i][j - 1];
                    int delete = dp[i - 1][j - 1];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(add, Math.min(delete, replace)) + 1;
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static void stringConversion(String word1 , String word2){
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1; i< n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int comlen = dp[n][m];
        int delete = word1.length() - comlen;
        int insert = word2.length() - comlen;
        System.out.println("The no. of delete operations are: " + delete);
        System.out.println("The no. of insert operations are: " + insert);
    }
    public static void main(String[] args) {
        // int arr1[] = {50,3,10,7,40,80};
        // System.out.println(lis(arr1));

        String word1 = "pear";
        String word2 = "sea";
        // System.out.println(editDist(word1, word2));
        // stringConversion(word1, word2);
    }
}
