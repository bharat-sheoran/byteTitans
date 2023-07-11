import java.security.Key;
import java.util.*;

public class TwoD_Arrays {
    public static boolean search(int matrix[][] , int Key) {
        for (int i = 0; i < matrix.length; i++ ){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == Key){
                    System.out.println("(" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println(" key not found");
        return false;
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        //top
        while (startRow <= endRow && startCol <= endCol){
            for (int j = startCol; j < endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }
            //right
            for (int i = startRow + 1; i <= endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }
            //bootom
            for (int j = endCol - 1; j >= startCol; j--){
                System.out.print(matrix[endRow][j] + " ");
            }
            //left
            for (int i = endRow -1; i >= startRow + 1; i--){
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        System.out.println();
    }
    
    public static int diagnolSum(int matrix[][]) {
        int sum = 0;
        //O (n ^ 2)
        // for (int i = 0; i < matrix.length; i++){
        //     for (int j = 0; j < matrix[0].length; j++){
        //         if (i == j){
        //             sum += matrix[i][j];
        //         }
        //         else if (i + j == matrix.length - 1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        // O (n) optimized code
        for (int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];

            if(i != matrix.length - 1 -i){
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    public static boolean stairCase(int matrix[][] , int key) {
        int row = 0 , col = matrix.length -1; 

        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == key){
                System.out.println("Key found at (" + row + "," + col + ")");
                return true;
            }
            else if (key < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void frequency(int matrix[][]) {
        int countOf7 = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 7){
                    countOf7++;
                }
            }
        }
        System.out.println(countOf7);
    }

    public static void sumOfMiddleRow(int matrix[][]) {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++){
            sum += matrix[1][j];
        }
        System.out.println(sum);
    }

    public static void transponse(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
                System.out.println("(" + i + "," + j + ")");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int matrix[][]= {{10,20,30,40},
        //                 { 15,25,35,45},
        //                 { 27,29,37,48},
        //                 { 32,33,39,50}};
        // int n = matrix.length , m = matrix[0].length;
        // for (int i = 0; i < n; i++ ){
        //     for (int j = 0; j < m; j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // for (int i = 0; i < n; i++ ){
        //     for (int j = 0; j < m; j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // search(matrix, 5);
        // printSpiral(matrix);
        // System.out.println(diagnolSum(matrix));

        // stairCase(matrix, 100);


        // int matrix[][] = { {4,7,8},
        //                 {8,8,7} };


        // frequency(matrix);


        int matrix[][] = {{1,4,9},
                            {11,4,3},
                            {2,2,3} };
                            
                            
        // sumOfMiddleRow(matrix);
        transponse(matrix);

    }

}
