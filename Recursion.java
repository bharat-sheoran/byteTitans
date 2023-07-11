import java.security.Key;

import javax.swing.text.html.HTMLDocument.RunElement;

// import java.util.*;

public class Recursion {
    
    // Decreasing order using recursion
    public static void printDec(int n) {
        if (n == 1){
            System.out.print(n);
            return;
        }
        
        System.out.print(n + " ");
        printDec(n - 1);
    }
    // Increasing order using recursion
    public static void printInc(int n) {
        if (n == 1){
            System.out.print(n + " ");
            return;
        }
        
        printInc(n - 1);
        System.out.print(n + " ");
    }

    // Print factorial of n
    public static int printFact(int n) {
        if (n == 0){
            return 1;
        }
        
        int fnm1 = printFact(n - 1);
        int fn = n * printFact(n-1);
        return fn;
    }

    // Print the sum of the first N natural numbers
    public static int printSum(int n) {
        if (n == 1){
            return 1;
        }
        
        int sum = n + printSum(n - 1);
        return sum;
    }

    // Print the fibonacci number
    public static int printFibbo(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        
        int fibn = printFibbo(n - 1) + printFibbo(n - 2);
        return fibn;
    }

    // Check if the array is sorted or not
    public static boolean isSorted(int arr[] , int i ) {
        if (i == arr.length - 1){
            return true;
        }
        
        if (arr[i] > arr[i + 1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    
    // find the first occurance of the element
    public static int firstOccurance( int arr[], int Key , int i) {
        if (i == arr.length){
            return -1;
        }
        
        if (arr[i] == Key){
            return i;
        }
        return firstOccurance(arr, Key, i - 1);
        
    }
    // Find the last occurance of the element
    public static int lastOccurance( int arr[], int Key , int i) {
        int isFound = lastOccurance(arr, Key, i - 1);
        if (i == arr.length - 1){
            return -1;
        }
        
        if (isFound == -1 || arr[i] == Key){
            return i;
        }
        return isFound;
    }

    // Print x^n 
    public static int printXPN(int x , int n) {
        if (n == 1){
            return x;
        }

        int XPNM1 = printXPN(x, n - 1);
        int XPN = x * XPNM1;
        return XPN;
    }

    // Print x^n in an optimized way
    public static int printXPNO(int x , int n) {
        if (n == 0){
            return 1;
        }
        
        int halfPower = printXPNO(x , n/2);
        int halfPowersq = halfPower * halfPower;
        if (n % 2 != 0){
            halfPowersq = x * halfPowersq;
        }

        return halfPowersq;
    }

    // Tilling problem
    public static int tilingProblem(int n) {
        if (n == 0 || n == 1){
            return 1;
        }

        // place vertical tiles
        int verticalTiles = tilingProblem(n - 1);

        // place horizontal tiles
        int horizontalTiles = tilingProblem(n - 2);

        int totalWays = horizontalTiles + verticalTiles;
        return totalWays;
    }
    
    public static void removeDuplicate(String str , int idx , StringBuilder newStr , boolean map[]) {
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true){
            removeDuplicate(str, idx + 1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int friendsPariring(int n) {
        if (n == 1 || n == 2){
            return n;
        }

        // Choice
        // Single
        int fnm1 = friendsPariring(n - 1);
        // Pair
        int fnm2 = friendsPariring(n - 2);
        int pairWays = (n - 1) * fnm2 ;

        // total Ways
        int totalWays = pairWays + fnm1;
        return totalWays;
    }

    public static void binaryProblem(int n, String str , int lastPlace) {
        if (n == 0){
            System.out.println(str);
            return;
        }


        if (lastPlace == 0){
            binaryProblem(n - 1, str+"0", 0);
            binaryProblem(n - 1, str+"1", 1);
        }else{
            binaryProblem(n - 1, str+"0", 0); 
        }
    }

    public static void allOccurance(int arr[] , int key, int i) {
        if (i == arr.length){
            return;
        }
        
        if (arr[i] == key){
            System.out.println(i + " ");
        }

        allOccurance(arr, key, i + 1);
    }

    static String Digits[] = {"Zero" , "One" , "Two" , "Three" , "Four" , "Five" , "Six" , "Seven" , "Eight" , "Nine"};

    public static void convertString(int n) {
        if (n == 0){
            return;
        }
        
        int lastDigits = n % 10;
        convertString(n / 2);
        System.out.print(Digits[lastDigits] + " " );
    }

    public static void findLength(String n) {
        System.out.println(n.length());
    }

    public static void noOfCase(String str) {
        
    }
    public static void main(String[] args) {
        // int n = 5;
        // System.out.println(printFibbo(n));

        // int arr[] = {8 , 3 , 6 , 9 , 5 , 10 , 2, 5 , 3};
        // System.out.println(lastOccurance(arr, 5, 0));

        // System.out.println(printXPN(5, 2));

        // System.out.println(printXPNO(2, 5));

        // System.out.println(tilingProblem(4));

        // removeDuplicate("appnnacoollege", 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPariring(3));

        // binaryProblem(3, "", 0);

        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // allOccurance(arr, 2, 0);

        // convertString(2019);

        // findLength("");

    }
}
