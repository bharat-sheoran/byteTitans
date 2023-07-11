public class BitwiseOperators {

    public static void OddEven(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;

        if ((n & bitmask) == 0 ){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearIthBit(int n, int i) {
        int bitmask = 1 << i;
        return (n & (~bitmask));
    }

    public static int updateIthBit(int n , int i, int bit) {
        if (bit == 0){
            return clearIthBit(n, i);
        }else{
            return setIthBit(n, i);
        }
    }

    public static int clearIBits(int n, int i) {
        int bitmask = ((~0)<< i);

        return n & bitmask;
    }

    public static int clearRange(int n, int i , int j) {
        int a = ((~0)<< (j +1));
        int b = ((1 << i) - 1);

        int bitmask = a | b ;
        return n & bitmask;
    }

    public static void powerTwo(int n) {
        if ((n & (n-1)) != 0){
            System.out.println("No," + n + " is not a power of two");
        }else{
            System.out.println("Yes," + n + " is a power of two");
        }
    }

    public static int countSetBits(int n ) {
        int count = 0;

        while(n > 0){
            if ((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExponention(int n, int p) {
        int ans = 1;

        while(p > 0){
            if ((p&1) != 0){
                ans = ans + n;
            }
            n = n * n;
        }
        return ans;
    }

    public static void swapWithoutVariable(int a , int b) {
        System.out.println("The x is " + a + " and y is " + b );

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.println("The x is " + a + " and y is " + b );
    }
    public static void main(String[] args) {
        // System.out.println(5 & 6); //AND Operator
        // System.out.println(5 | 6); //OR Operator
        // System.out.println(5 ^ 6); //XOR Operator
        // System.out.println(~5); //One's complement Operator
        // System.out.println(5<<2); //Left shift Operator
        // System.out.println(6>>1); //right shift Operator


        // OddEven(8);
        // System.out.println(getIthBit(10, 2));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearIBits(15, 2));
        // System.out.println(clearRange(10, 2, 4));
        // powerTwo(4);
        // System.out.println(countSetBits(15));
        // System.out.println(fastExponention(5, 3));
        // swapWithoutVariable(3, 4);
    }
}
