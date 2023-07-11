import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Backtracking {

    // Backtracking on Arrays
    public static void changeArr(int arr[] , int i , int val) {
        // Base Case
        if (i == arr.length){
            printArr(arr);
            return;
        }
        // Recursion
        arr[i] = val;
        changeArr(arr, i+1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr( int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findSubString(String Str , String ans, int i) {
        // Base Case
        if (i == Str.length()){
            if (ans.length() == 0){
                System.out.println("null");
                
            }else {
                System.out.println(ans);
            }
            return;
        }

        // Recursion
        // Yes Choice
        findSubString(Str, ans + Str.charAt(i), i + 1);
        // No Choice
        findSubString(Str, ans, i+1);
    }

    public static void findPermutation(String Str , String ans) {
        // Base Case
        if (Str.length() == 0){
            System.out.println(ans);
            return;
        }
        // Recursion  TC = O(n *n!)
        for (int i = 0; i < Str.length(); i++){
            char curr = Str.charAt(i);
            String newStr = Str.substring(0, i) + Str.substring(i + 1);
            findPermutation(newStr, ans + curr);
        }
    }

    public static void permutation(String name , String combination) {
        // Base Case
        if (name.length() == 0){
            System.out.println(combination);
            return;
        }
        // Recursion
        for (int i = 0; i < name.length(); i++){
            char curr = name.charAt(i);
            String newName = name.substring(0, i) + name.substring(i + 1);
            permutation(newName, combination + curr);
        }
    }


    public static boolean isSafe(char board[][] , int row , int col) {
        // Vertically up
        for(int i = row - 1; i >= 0; i--){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        // diag left up
        for (int i = row - 1 , j = col - 1; i >= 0 && j >=0; i-- , j--){
                if (board[i][j] == 'Q'){
                    return false;
                }
        }

        // diag right up
        for (int i = row - 1 , j = col + 1; i >= 0 && j < board.length; i-- , j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static boolean nQueens(char board[][] , int row) {
        // Base Case
        if (row == board.length){
            // printQueen(board);
            count++;
            return true;
        }

            for (int j = 0; j < board.length; j++) {
                if (isSafe(board , row , j)){
                    board[row][j] = 'Q';
                    if (nQueens(board, row + 1)){
                        return true;
                    } // Function Call
                    board[row][j] = '.'; // Backtracking Step
                }
            }
            return false;
    }

    public static void printQueen(char board[][]) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int gridWays(int i , int j ,int n , int m) {
        // Base Case
        if ( i == n-1 && j == m-1){  // Condition for last cell
            return 1;
        }else if (i == n || j == n){  // Condition for boundary cell
            return 0;
        }
        // Recursion equation
        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static boolean isSudokuSafe(int sudoku[][] , int row , int col , int digit) {
        // Coloumn
        for (int i = 0; i <= 8; i++){
            if (sudoku[i][col] == digit){
                return false;
            }
        }

        // row
        for (int j = 0; j <= 8; j++){
            if (sudoku[row][j] == digit){
                return false;
            }
        }

        // Grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        //3x3 Grid
        for (int i = sr; i < sr + 3; i++){
            for (int j = sc; j < sc + 3; j++){
                if (sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][] , int row , int col) {
        // Base Case
        if (row == 9){
            return true;
        }

        // Recursion
        int nextRow = row , nextCol = col + 1;
        if (col + 1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++){
            if (isSudokuSafe(sudoku, row , col, digit)){
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    public static void rat(int ratPath[][] , int sol[][] , int x , int y) {
        // Base Case

        // Recursion
    }

    static int count = 0;
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        String Str = "KDTPA";
        // findSubString(Str, "", 0);
        findPermutation(Str, "");
        // int n = 3;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < n; j++){
        //         board[i][j] = '.';
        //     }
        // }
        // if (nQueens(board , 0)){
        //     System.out.println("Solution is possible");
        //     printQueen(board);
        // }else{
        //     System.out.println("Solution is not possible");
        // }
        // System.out.println("The total number of ways to which n can be print " + count);
        
        // System.out.print(gridWays(0 , 0, 3, 4));

        // int sudoku[][] = {{0,0,8,0,0,0,0,0,0},
        //                 {4,9,0,1,5,7,0,0,2},
        //                 {0,0,3,0,0,4,1,9,0},
        //                 {1,8,5,0,6,0,0,2,0},
        //                 {0,0,0,0,2,0,0,6,0},
        //                 {9,6,0,4,0,5,3,0,0},
        //                 {0,3,0,0,7,2,0,0,4},
        //                 {0,4,9,0,3,0,0,5,7},
        //                 {8,2,7,0,0,9,0,1,3}};

        // if(sudokuSolver(sudoku, 0, 0)){
        //     System.out.println(" The Solution exist");
        //     printSudoku(sudoku);
        // }else{
        //     System.out.println(" The Solution does not exist");
        // }

        // permutation("BEK", "");

    //     int ratPath[][] = {{1,0,0,0},
    //                     {1,1,0,1},
    //                     {0,1,0,0},
    //                     {1,1,1,1}};

    //     int sol[][] = {{0,0,0,0},
    //                 {0,0,0,0},
    //                 {0,0,0,0},
    //                 {0,0,0,0}};
    }
}