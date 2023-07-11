import java.util.*;

public class Practice {
    public static void average(int a , int b , int c) {
        int average = (a + b +c )/3;
        System.out.println(average);
    }
    
    public static boolean isEven(int n) {
        if (n%2==0){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Find the average of 3 numbers
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();

        // float average = (a+b+c)/3;
        // System.out.println(average);


        // Find area of square
        // float s = sc.nextFloat();
        // float area = s*s;
        // System.out.println(area);

        // byte b = 4;
        // char c = 'a';
        // short s = 512;
        // int i = 1000;
        // float f = 3.14f;
        // double d = 99.998;

        // double result = (f*b) + (i%c) - (d*s);
        // System.out.println(result);

        // int $ = 24;
        // System.out.print($);


        // int number;
        // int choice;

        // int evenSum = 0;
        // int oddSum = 0;

        // do{
        //     System.out.println("Enter Your number: ");
        //     number = sc.nextInt();

        //     if (number % 2 == 0){
        //         evenSum = number + evenSum;
        //     }else {
        //         oddSum = number + oddSum;
        //     }

        //     System.out.println("Do you want to continue? Press 1 if not then press 0");
        //     choice = sc.nextInt();
        // }while (choice == 1);

        // System.out.println("sum is " + evenSum);
        // System.out.println("sum is " + oddSum);

        // int n = sc.nextInt();
        // int product = 1;

        // while(n > 0) {
        //     product = product * n;
        //     n--;
        // }
        // System.out.println(product);

        // int n = sc.nextInt();

        // for (int i= 0; i <= 20; i++){
        //     int product = n*i;

        //     System.out.println(product);
        // }

        System.out.println(isEven(2));
    }
}
