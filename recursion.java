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
  return fibH(1,1,0,n);
}

public static int fibH(int first, int last, int pos, int end){
  if(end <= 1){return first;}
  int nfirst = first + last;
  int nlast = first;
  return fibH(nfirst,nlast,pos,end-1);
}

public static ArrayList<Integer> makeAllSums(int nums){
  ArrayList<Integer> result = new ArrayList<Integer>();
  result.add(0);
  result.add(nums);
  return makeAllSumsH(nums-1,result);
}

public static ArrayList<Integer> makeAllSumsH(int nums, ArrayList<Integer> data){
  if(nums == 0){return data;}
  int length = data.size();
  while(length > 0){
    int num = data.get(length-1);
    if(!data.contains(num+nums)){data.add(num+nums);}
    length--;
  }
  return makeAllSumsH(nums-1,data);
}

public static void main(String[] args){
  Scanner in = new Scanner(System.in);
  System.out.println("Here are all the functions: ");
  System.out.println("1) sqrt for finding square root of a number");
  System.out.println("2) fib for finding the fibinachi number at an index");
  System.out.println("3) makeAllSums for finding all posible combination of sums");
  System.out.println("Input a valid function name: ");
  boolean run = true;
  while(run){
  String func = in.nextLine();
  func = func.toLowerCase();
  if(func.equals("sqrt")){
    System.out.println("Input a number: ");
    double num = (double)in.nextInt();
    System.out.println("Input a tolerance: ");
    double tolerance = in.nextDouble();
    double result = sqrt(num,tolerance);
    System.out.println("The square root of " + num + " is: " + result);
    run = false;
  }
  else if(func.equals("fib")){
    System.out.println("Input a number: ");
    int num = in.nextInt();
    int result = fib(num);
    System.out.println("The fibinachi number at postion " + num + " is: " + result);
    run = false;
  }
  else if(func.equals("makeallsums")){
    System.out.println("Input a number: ");
    int num = in.nextInt();
    ArrayList<Integer> result = makeAllSums(num);
    System.out.println("Here is all possible sums: " + result);
    run = false;
  }
  else if(func.equals("x")){run = false;}
  else{
    System.out.println("Invalid Input! Try Again or Enter 'x' to exit!");
  }
}
  in.close();
}
}
