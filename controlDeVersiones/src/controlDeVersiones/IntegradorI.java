package controlDeVersiones;

import java.util.Scanner;

public class IntegradorI {
	
    
    public static Scanner console=new Scanner (System.in);//Method to read the user's input
    public static final int iterations=1000;
    public static final int limitSum=6;//Number of iterations of the cosine function
    public static final double epsilon=0.0001;//Margin of error for the bisection method
    //OPERATIONS
    public static double abs(double x){
        if(x>=0){//evaluates if the number has a positive sign or if its 0
            return x;//if true, returns the number as it is
        }else {
            return -(x);//if false, return the number with its sign changed
        }
    }
    public static double pow(double base,double exponent){//Pow function: based on a "base" and "exponent" input,
        double pow=1;                                     //multiples the base number "exponent" times.
        for(int i=1;i<=exponent;i++){
            pow*=base;
        }
        return pow;//Returns the final value of the "base" multiplied "exponent" times.
    }
    public static int factorial(int n){//Factorial function: based on a input number, multiplies said n by the smaller
        int factorial=1;               //whole numbers.
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        return factorial;//Returns the multiplication of the n number by the whole numbers smaller to it.
    }

    public static double cos(double x){//Cosine function: Uses a pre-establised sequence to find the aproximated cosine
        double cos=0;                  //of a x input number given in radians.
        for(int i=0;i<limitSum;i++){
            cos+=(pow(-1,i))*pow(x,(2*i))/ (factorial(2*i));
        }
        return cos;
    }

    public static double function1(double x){//Function 1: 2*cos(x^2)
        return 2*Math.cos(pow(x,2));//Given a value to x, returns the result of the evaluation of x in said function
    }
    public static double function2(double x){//Function 2: 3x^3+7x^2+5
        return 3*(pow(x, 3))+7*(pow(x, 2))+5;//Given a value to x, returns the result of the evaluation of x in said function
    }
    public static double function3(double x){//Function 3: x*cos(x)
        return x*cos(x);//Given a value to x, returns the result of the evaluation of x in said function
    }
    public static double bisection1(double a, double b){//Bisection method for the first function (having 2 input values corresponding to the extremes of an interval)
        int i=1;
        double c = 0;
        //c is the middle value between the higher and lower extreme of the interval
        while (abs(b - a) >= epsilon && i<=iterations) {//the cycle is repeated while the difference between the extremes of the interval is bigger than the margin of error
            c = (a + b) / 2;
            if (function1(c) == 0.0) {//if said statement is true, the while cycle ends
                break;
            } else if (function1(a)*function1(b)>0) {
                c=0;
                break;
            } else if (function1(c) * function1(a) < 0) {//evaluates if f(a) and f(c) have different sign
                b = c;                                   //if true, b is the new "middle" value
            } else {
                a = c;                                   //if false, the new "middle" value is a
            }
            i++;
        }

        return c;//Returns the smallest "middle" value found, which is the most aproximated value of the root of the function
    }            //c-->Ouput variable
    public static double bisection2(double a,double b){//Bisection method for the second function (having 2 input values corresponding to the extremes of an interval)
        int i=0;
        double c = 0;
        while (abs((b - a)) >= epsilon && i<=iterations) {
            c = (a + b) / 2;
            if (function2(c) == 0.0) {
                break;
            } else if (function2(a)*function2(b)>0) {
                c=0;
                break;
            } else if (function2(c) * function2(a) < 0) {
                b = c;
            } else {
                a = c;
            }
            i++;
        }
        return c;
    }
    public static double bisection3(double a,double b){//Bisection method for the third function (having 2 input values corresponding to the extremes of an interval)
        int i=0;
        double c = 0;
        while (abs((b - a)) >= epsilon && i<=iterations) {
            c = (a + b) / 2;
            if (function3(c) == 0.0) {
                break;
            } else if (function3(a)*function3(b)>0) {
                c=0;
                break;
            } else if (function3(c) * function3(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        i++;
        }
        return c;
    }
    public static void main(String [] args){
        int opc;//Entry variable
        double a,b;//Entry variable
        System.out.println("Enter the option of the function you wish to evaluate");//The user chooses the function which they wish to evaluate
        System.out.println("1. 2*cos(x^2)\n2. 3x^3+7x^2+5\n3. x*cos(x)");
        opc= console.nextInt();//Input
        while(opc<1 || opc>3){//Asks for a function to evaluate until a valid option is given
            System.out.println("Enter a valid option");
            System.out.println("1. 2*cos(x^2)\n2. 3x^3+7x^2+5\n3. x*cos(x)");
            opc= console.nextInt();//Input
        }
        System.out.println("Interval [a,b]");
        System.out.println("Enter the value for a: ");//Ask for the higher value of the interval
        a= console.nextDouble();//Input
        System.out.println("Enter the value for b: ");//Asks for the lower value of the interval
        b= console.nextDouble();//Input
        if(opc==1){//According to the option given, the program returns the value of the root found in said interval or if it's valid
            if(bisection1(a,b)==0){//in case the c returned is 0, means the interval was never valid
                System.out.println("The interval is not valid ");
            }else {
                System.out.println("The root is: "+bisection1(a,b));//Returns the value of c according to the method "bisection1"
            }
        } else if (opc==2) {
            if(bisection2(a,b)==0){
                System.out.println("The interval is not valid ");
            }else {
                System.out.println("The root is: "+bisection2(a,b));//Returns the value of c according to the method "bisection2"
            }
        }else{
            if(bisection3(a,b)==0){
                System.out.println("The interval is not valid ");
            }else {
                System.out.println("The root is: "+bisection3(a,b));//Returns the value of c according to the method "bisection3"
            }

        }

    }

}
