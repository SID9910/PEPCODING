import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }
//inverse of a number 
  public static int[] inverse(int[] a){
    int n=a.length; //n element index
    int[]b=new int[n]; //resultant array
    for(int i=0;i<n;i++){
        int j=a[i];  //pehle a[i]ki value j main store kardi
        b[j]=i;// vo j ki value index bna do b ka and i index store kar do us vale per
    }
    return b; //return pura array kardo
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    display(inv);
 }

}