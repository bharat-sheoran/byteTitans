import javax.sql.rowset.spi.SyncResolver;

class Complex{
    int real;
    int imag;

    public Complex(int r, int i) {
        real = r;
        imag = i;
    }

    public static Complex add (Complex a , Complex b){
        return new Complex ((a.real + b.real) , (a.imag + b.imag));
    }

    public static Complex subtract (Complex a , Complex b){
        return new Complex ((a.real - b.real) , (a.imag - b.imag));
    }

    public static Complex product (Complex a , Complex b){
        return new Complex  ((a.real * b.real) - (a.imag * b.imag) , (a.imag * b.real) - (a.real * b.imag));
    }

    public void printComplex(){
        if (real == 0 && imag != 0){
            System.out.println(imag + "i");
        }else if(imag == 0 && real != 0){
            System.out.println(real);
        }else{
            System.out.println(real + imag + "i");
        }
    }
}


public class OOPs {
    public static void main(String[] args) {
        // Pen p1 = new Pen(); // Created a pen object
        // p1.setColor("Blue");
        // System.out.println(p1.color);

        // BankAccount myAcc = new BankAccount();
        // myAcc.username = "Bharat Sheoran";
        // myAcc.setPassword("abcdefghi");

        // Student s1 = new Student();
        // // System.out.println(s1.name);
        // s1.name = "Bharat Sheoran";
        // s1.roll = 108;
        // s1.password = "abcd";


        // Student s2 = new Student(s1);
        // s2.password = "xyz";
        // s1.marks[2]= 100;
        // for (int i = 0; i < 3; i++){
        //     System.out.println(s2.marks[i]);
        // }

        // Fish Shark = new Fish();
        // Shark.eat();

        // Dog dobby = new Dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);

        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(1.5f, 2));

        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // chicken c = new chicken();
        // c.eat();
        // c.walk();

        // Horse myHorse = new Horse();
        // Animal => Horse => Mustang

        // Queen q = new Queen();
        // q.moves();

        // Student s1 = new Student();
        // s1.schoolName = "IPS";

        // Student s2 = new Student();
        // System.out.println(s2.schoolName);

        Complex c = new Complex(5, 2);

    }
}

// class Pen{
//     // Properties and functions
//     String color;
//     int tip;

//     void setColor(String newColor){
//         color = newColor;
//     }

//     void setTip(int newTip){
//         tip = newTip;
//     }
// }

// class Student {
//     String name;
//     int roll;
//     String password;
//     int marks[];

//     //Copy constructor4
//     // Student(Student s1){
//     //     marks = new int[3];
//     //     this.name = s1.name;
//     //     this.roll = s1.roll;
//     // }

//     //deep copy constructor
//     Student (Student s1){
//         marks = new int[3];
//         this.name = s1.name;
//         this.roll = s1.roll;

//         for (int i = 0; i < marks.length; i++){
//             this.marks[i] = s1.marks[i];
//         }
//     }
// }

// class BankAccount{
//     public String username;
//     private String password;

//     private void setPassword(String pwd){
//         password = pwd;
//     }
// } 


//Base Class
// class Animal {
//     String color;
    
//     void eat(){
//         System.out.println("Eats");
//     }

//     void breathe(){
//         System.out.println("breathes");
//     }
// }

// class Mammal extends Animal {
//     int legs;
// }

// class Dog extends Mammal{
//     String breed;
// }

// Derived Class
// class Fish extends Animal{
//     int fins;

//     void swim(){
//         System.out.println("Swims in water");
//     }
// }


// Method Overloading
class Calculator {
    int sum (int a, int b){
        return a + b; 
    }

    float sum (float a, float b){
        return a + b;
    }

    int sum (int a, int b, int c){
        return a + b + c;
    }
}

// Abstract Method
abstract class Animal{
    // String color;


    Animal(){
        System.out.println("animal constructor called");
    }
    // void eat(){
    //     System.out.println("animal Eats");
    // }

    abstract void walk(); // Abstract method vo hote h jinme implementation nhi hota
}

// class Horse extends Animal{
//     Horse (){
//         System.out.println("Horse constructor called");
//     }
    
//     // void walk(){
//     //     System.out.println("Walks on 4 legs");
//     // }
// }

// class chicken extends Animal{
//     void walk(){
//         System.out.println("Walks on 2 legs");
//     }
// }

// class Mustang extends Horse{
//     Mustang(){
//         System.out.println("Mustang constructor called");
//     }
// }

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up , down, left , right in all four directions");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up , down, left , right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up , down, left , right and diagnol by one step");
    }
}

class Student{
    String name;
    int roll;

    static String schoolName;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}

