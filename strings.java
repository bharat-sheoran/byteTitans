import java.io.FileReader;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

public class strings {

    public static void printLetters(String fullName) {
        for (int i = 0; i < fullName.length(); i++){
            System.out.print(fullName.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPallindrome(String pallindrome) {
        for (int i = 0; i < pallindrome.length()/2; i++){
            if (pallindrome.charAt(i) != pallindrome.charAt(pallindrome.length()-1-i)){
                System.out.println("The word is not a pallindrome");
                return false;
            }
        }
        System.out.println(" The word is pallindrome");
        return true;
    }

    public static float displacement(String path) {
        int x = 0, y= 0;
        for (int i = 0; i < path.length(); i++ ){
            char dir = path.charAt(i);
            if (dir == 'N'){
                y--;
            }else if (dir == 'S'){
                y++;
            }else if (dir == 'W'){
                x--;
            }else {
                x++;
            }
        }
        int x2 = x*x;
        int y2 = y*y;

        return (float)Math.sqrt(x2 + y2);
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == ' ' && i < str.length()-1 ){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase((str.charAt(i))));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String substr(String str, int si , int ei) {
        String substring = "";

        for (int i = si; i < ei; i++){
            substring += str.charAt(i);
        }
        return substring;
    }

    public static String stringCompression(String str) {
        String newstr = "";

        for (int i = 0; i < str.length(); i++){   //O(n)
            Integer ch = i;
            Integer count = 1;

            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }

            newstr += str.charAt(i);
            if (count > 1){
                newstr += count.toString();
            }
        }
        return newstr;
    }
    public static void main(String[] args) {
        // char arr[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz");

        //  Strings are IMMUTABLE
        // System.out.println(str2);

        //Taking input for a string

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();

        //String length
        // System.out.println(name);

        //concatination
        // String firstName = "Bharat";
        // String lastName = "Sheoran";
        // String fullName = firstName + " " + lastName;

        // printLetters(fullName);

        // String pallindrome = "Racecar";
        // isPallindrome(pallindrome);

        // String path = "NNSSWWEE";

        // System.out.println(displacement(path));\

        // String s1 = "Bharat";
        // String s2 = "Bharat";
        // String s3 = new String("Bharat");

        // if (s1 == s2){
        //     System.out.println("Strings are equal");
        // } else{
        //     System.out.println("Strings are not equal");
        // }

        // if (s1 == s3){
        //     System.out.println("Strings are equal");
        // } else{
        //     System.out.println("Strings are not equal");
        // }
        
        // if (s1.equals(s3)){
        //     System.out.println("Strings are equal");
        // } else{
        //     System.out.println("Strings are not equal");
        // }

        // String str = "Bharat Sheoran";

        // System.out.println(substr(str, 0, 6));
        // Inbult function for substring
        // System.out.println(str.substring(0 , 6));

        // String fruits[] = {"apple", "mango", "banana"};

        // String largest = fruits[0];
        // for (int i = 0; i < fruits.length; i++ ){
        //     if (largest.compareTo(fruits[i]) < 0){
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);

        // StringBuilder sb = new StringBuilder("");
        // for (char i = 'a'; i < 'z'; i++){
        //     sb.append(i);
        // }
        // System.out.println(sb);

        // String str = "hi, i am bharat sheoran";
        // System.out.println(toUpperCase(str));

        String str = "abcd";
        System.out.println(stringCompression(str));
    }
}
