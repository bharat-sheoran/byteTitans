public class Patterns{
    
    public static void hollow_rectangle(int totalRow , int totalCol){
        //Outer loop
        for (int i = 1; i <= totalRow; i++){
            // inner loop
            for (int j = 1; j <= totalCol; j++){
                // (i,j)
                if (i == 1 || i == totalRow || j == 1 || j == totalCol){
                    System.out.print("*");
                }else {
                    System.out.print( " ");
                }
            }
            System.out.println();
        }
    }


    public static void inverted_pyramid(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    } 
    
    public static void number_pyramid(int n){
        for ( int i = 1; i <= n; i++){
            int num = 1;
            for ( int j = 1; j <= n-i+1; j++){
                System.out.print(num);
                num++;
            }
            for (int j = 1; j <= i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int n) {
        int num = 1;
        for (int i =1; i <=n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(num + " ");
                num++;
            }
            for (int j = 1; j<= n-i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void zeroOne_triangle(int n) {
        for (int i = 1; i <= n; i++){
            for (int j =1; j <= i; j++){
                if ((i+j)%2 == 0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.err.println();
        }
    }
    

    public static void butterfly(int n) {
        for (int i =1; i<=n; i++){
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            for (int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i =n; i>=1; i--){
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            for (int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int r) {
        for (int i=1; i<=r; i++){
            for (int j=1; j<=r-i; j++){
                System.out.print(" ");
            }
            for (int j=1; j<=r; j++){
                if (i == 1 || i == r || j == 1 || j == r){
                    System.out.print("*");
                }else {
                    System.out.print( " ");
                }
            }
            System.out.println();
        }
    }

    public static void numberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j=1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (int j =1; j <= i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void palindromic(int n) {
        for (int i =1; i <= n; i++){
            for (int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--){
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void diamond(int n) {
        for (int i =1; i <= n; i++){
            for (int j =1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (int j =1; j <= 2*i -1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i =n; i >=1; i--){
            for (int j =1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (int j =1; j <= 2*i -1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // inverted_pyramid(4);
        // number_pyramid(6);
        // floyd_triangle(5);
        // zeroOne_triangle(5);
        // butterfly(15);
        // solid_rhombus(5);
        // numberPyramid(6);
        // palindromic(10);
        // diamond(10);
        // hollow_rectangle(5, 7);
    }
}