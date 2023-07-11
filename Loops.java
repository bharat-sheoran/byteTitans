import java.util.*;

public class Loops {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //While loop
        // int count = 1;
        // int n = sc.nextInt();
        // int sum = 0;

        // while (count <= n){
        //     sum += count;
        //     count++;
        // }
        // System.out.println(sum);

        //For loops

        // for (int i = 0; i<=4; i++){
        //     System.out.println("****");
        // }

        // Reverse the number
        // int n = sc.nextInt();

        // while (n>0){
        //     int lastDigit = n%10;
        //     System.out.print(lastDigit);
        //     n /= 10;
        // }

        //other method of reversing the number
        // int n = 23122003;
        // int rev = 0;

        // while (n> 0){
        //     int lastDigit = n%10;
        //     rev = (rev*10) + lastDigit;
        //     n /= 10;
        // }
        // System.out.println(rev);

        //Do while loop

        // int n = 0;
        // do {
        //     System.out.println("Hello World!");
        //     n++;
        // } while(n<10);

        // for (int i = 0; i < 10; i++) {
        //     if (i == 5) {
        //         continue;
        //     }
        //     System.out.println(i);
        // }

        // do {
        //     int i = sc.nextInt();
        //     if (i%10 == 0){
        //         continue;
        //     }
        //     System.out.println(i);
        // }while (true);

        // check if a number is prime of not
        // int n = sc.nextInt();
        // boolean isPrime = true;

        // if (n == 2){
        //     System.out.println(n + " is a prime number");
        // }else{
        //     for (int i = 2; i <= n-1; i++) {
        //         if (n % i == 0){
        //             isPrime = false;
        //         }
        //     } if (isPrime == true){
        //         System.out.println(n + " is prime");
        //     }else {
        //         System.out.println(n + " is not a prime number");
        //     }
        // }
        // for(int i=0; i<5; i++) {
        //     System.out.println("Hello");
        //     i+=2;
        // }

        // Nested Loops
        // for (int line = 1; line <= 10; line++){
        //     for (int star = 1; star <= (10 - line + 1); star++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

            // Half pyramid pattern
        char ch = 'A';

        for (int line = 1; line <= 20; line++){
            for (int number = 1; number <= line; number++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
