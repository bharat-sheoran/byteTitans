import java.util.*;

class BinaryExponentiation{

    public static long binaryExpo(long a , long n){
        if(n == 0){
            return 1;
        }

        long res = binaryExpo(a , n/2);

        if(n % 2 != 0){
            return res * res * a;
        }else{
            return res * res;
        }
    }

    public static void main(String args[]){
        long a = 5;
        long n = 6;

        System.out.println(binaryExpo(a , n));
    }
}