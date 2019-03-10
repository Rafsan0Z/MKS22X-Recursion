import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class recursion{

  /*Recursively find the sqrt using Newton's approximation
       *tolerance is the allowed percent error the squared answer is away from n.
       *precondition: n is non-negative

      */
public static double sqrt(double n, double tolerance){
  if(n < 0.0){throw new IllegalArgumentException();}
  if(n == 0.0){return n;}
  return sqrtH(n,n/2.0,tolerance);
}

public static double sqrtH(double n, double guess, double tolerance){
  double num = guess * guess;
  if(Math.abs((num - n)/n) < tolerance){return guess;}
  guess = ((n/guess) + guess) / 2.0;
  return sqrtH(n,guess,tolerance);
}

/*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
public static int fib(int n){
  if(n == 0){return 0;}
  return fibH(0,1,0,n);
}

public static int fibH(int first, int last, int pos, int end){
  if(end == pos){return first;}
  int nfirst = first + last;
  int nlast = first;
  return fibH(nfirst,nlast,pos+1,end);
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
  int counter = 0;
  while(counter < length){
    int num = data.get(length-1);
    if(!data.contains(num+nums)){data.add(num+nums);}
    length--;
  }
  return makeAllSumsH(nums-1,data);
}

public static String printArray(int[] ary) {
 String result = "[";
 for (int i = 0; i < ary.length ; i++) {
  result += " " + ary[i];
  if (i != ary.length - 1) {
    result += ",";
  }
}
 return result + "]";
}

public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{

      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}

public static void main(String[] args){
  ArrayList<Integer> data = makeAllSums(1);
  int num = fib(7);
  System.out.println(num);
  System.out.println(data);
  for(int i = 0; i < 5; i++){
  testFib(i);
}
for(int j = 0; j < 4; j++){
  testSqrt(j);
}
}
}
