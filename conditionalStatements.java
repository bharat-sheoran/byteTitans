import java.util.*;

public class conditionalStatements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int income = sc.nextInt();
        // // int b = sc.nextInt();

        // if(income < 500000) {
        //     System.out.println("0");
        // } else if(income > 500000 && income < 1000000) {
        //     System.out.println(income*0.2);
        // }else{
        //     System.out.println(income * 0.3);
        // }

    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     int c = sc.nextInt();

    //     if (a >= b){
    //         if (a >= c ){
    //             System.out.println("a is greatest");
    //         }else {
    //             System.out.println("c is greatest");
    //         }
    //     }else{
    //         if (b >= c ){
    //             System.out.println("b is greatest");
    //         }else{
    //             System.out.println("c is greatest");
        
    //         }
    //     }

    // Ternery operator
        // int number = sc.nextInt();

        // String result = (number > 33)? "Pass": "Fail";

        // System.out.println(result);

    // switch statement

        // Question1:  Write a Java program to get a number from the user and print whether it is positive or negative.
        // float b = sc.nextFloat();

        // if (b > 0.0f) {
        //     System.out.println("positive");
        // }else{
        //     System.out.println("negative");
        // }

        int week = sc.nextInt();

        switch(week){
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
            default: System.out.println("Sunday"); break;
        }

    }
}
