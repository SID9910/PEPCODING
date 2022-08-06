import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x =scn.nextInt();
        int n =scn.nextInt();
        int pow2 =power(x,n);
        System.out.println(pow2);
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }

       int pow1 = x*power(x,n-1);
       return pow1;


    }

}