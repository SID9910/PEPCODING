import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int pow2=power(x,n);
        System.out.println(pow2);
    }

    public static int power(int x, int n){
     if(n==0){
            return 1;   //power(0)is one
        }
       int power2= power(x,n/2);  //3^8=3^4 *3^4
        if(n%2==0){//for odd
        return  power2*power2;//power ko multiply kar dea karo*number se 
    }
    else{//for even
        return x*power2*power2;
    }
    }

}