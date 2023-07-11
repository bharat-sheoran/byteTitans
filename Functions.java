import java.util.*;

public class Functions {
    public static int printProduct(int a , int b) {  // is paranthesis m parameters hoga
        // Scanner sc = new Scanner(System.in);
        // int sum = a+b;
        // System.out.println(sum);
        int product = a*b;
        return product;
    }


    // Convert binary into decimal number
    public static void binToDec(int binNum) {
        int pow = 0;
        int decNum = 0;

        while(binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit *(int)( Math.pow(2, pow)));

            pow++;
            binNum = binNum%10;
        }
        System.out.println(decNum);
    }

    // convert decimal to binary
    public static void decToBin(int n){
        int bin = 0;
        int pow = 0;
        while (n>0){
            int rem = n%2;
            bin = bin + (rem * (int) Math.pow(10, pow));
            n = n/2;
            pow++;
        }
        System.out.println(bin);
    }

    public static void main(String args[]) { // public static == Object oriented programming m hoga;   void is return type of function ;   main is the name of function which is already stored in java;    String and args[] is input of the function;
        // printSum(); // is function m argument hoga means value dena
        // Swap means values ko exchange kr dena
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // // swap
        // int temp = a;
        // a = b;
        // b = temp;

        // System.out.println(a);
        // System.out.println(b);

        // int fact = fact(5);
        // int facto = facto(2);
        // int factor = factor(5 , 2);

        // System.out.println(fact /(facto*factor));

        // primeRange(200);

        // binToDec(01);

        decToBin(11);
        
    }
// finding the binomial coefficient
    public static int fact(int n) {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f = f*i;
        }
        return f;
    }


    
    public static int facto(int r) {
        int fr = 1;

        for (int i = 1; i <= r; i++) {
            fr = fr*i;
        }
        return fr;
    }

    public static int factor(int n , int r) {
        int fs = 1;

        for (int i = 1; i <= (n-r); i++) {
            fs = fs*i;
        }
        return fs;
    }

    //function overloading using parameters
    //Calculate sum of two numbers
    // public static int sum(int a, int b) {
    //     return a+b ;
    // }
    // //Calculate sum of three numbers
    // public static int sum(int a, int b, int c) {
    //     return a+b+c ;
    // }

    //overloading using datatypes 
    // function to calculate int sum
    public static int sum(int a , int b) {
        return a+b;
    }

    public static float sum(float a , float b) {
        return a+b;
    }

    public static boolean prime(int n) {
        boolean prime = true;
        for (int i = 2; i<= Math.sqrt(n); i++) {
            if (n == 2){
                prime = true;
            }
            if (n%i == 0){
                prime = false;
            }
        }
        return prime;
    }

    public static void primeRange(int n) {
        for (int i = 2; i <= n; i++){
            if (prime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
