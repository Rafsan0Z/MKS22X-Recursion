import java.util.ArrayList;
import java.util.Scanner;
public class recursion{

  /*Recursively find the sqrt using Newton's approximation
       *tolerance is the allowed percent error the squared answer is away from n.
       *precondition: n is non-negative

      */
public static double sqrt(double n, double tolerance){
  if(n == 0.0){return n;}
  return sqrtH(n,1.0,tolerance);
}

public static double sqrtH(double n, double guess, double tolerance){
  double num = guess * guess;
  if(Math.abs((n/num) - 1) < tolerance){return guess;}
  guess = ((n/guess) + guess) / 2.0;
  return sqrtH(n,guess,tolerance);
}

/*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
public static int fib(int n){
  if(n == 0){return 1;}
  return fibH(n,0);
}

public static int fibH(int n, int m){
  
}

public static ArrayList<Integer> makeAllSums(){
  ArrayList<Integer> result = new ArrayList<Integer>();
  return result;
}

public static void main(String[] args){
  Scanner in = new Scanner(System.in);
  System.out.println("Here are all the functions: ");
  System.out.println("1) sqrt for finding square root of a number");
  System.out.println("2) fib for finding the fibinachi number at an index");
  System.out.println("3) makeAllSums for finding all posible combination of sums");
  System.out.println("Input a valid function name: ");
  String func = in.nextLine();
  if(func.equals("sqrt")){
    System.out.println("Input a number: ");
    double num = (double)in.nextInt();
    System.out.println("Input a tolerance: ");
    double tolerance = in.nextDouble();
    double result = sqrt(num,tolerance);
    System.out.println("The square root of " + num + " is: " + result);
  }
}

}
