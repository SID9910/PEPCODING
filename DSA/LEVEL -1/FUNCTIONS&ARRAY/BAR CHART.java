import java.io.*;
import java.util.*;

public class Main{
    public static int max (int[] arr){ //maximum in a array 

        int max=Integer.MIN_VALUE;
        for( int i = 0 ; i<arr.length ; i++){
            max = Math.max(arr[i],max);
    
        }
        return max;
    }
public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<=n-1; i++)
    {
        arr[i] = scn.nextInt();
    }
    
    int cols = arr.length;
   
    int max2 = max(arr);
    for(int floor =max2; floor>=0; floor--)
    {
        for(int j=0; j<cols; j++)
        {
            if(floor< arr[j]) // condition
                { System.out.print("*	"); }
            else System.out.print("	");
        }
        System.out.println();
    }
 }

}