import java.util.*;

public class Main {

    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
      for(int i=1;i<=n;i++){    //outer loop is for printing number of rows
           for(int j=n;j>=i;j--){
               System.out.print("*\t");
           }
          System.out.println();   //this is used to print in new  line
      }
   //another method
    /*
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
     int i=1;
      while(i<=n){
          int j=n;//outer loop is for printing number of rows
           while(j>=i){
               System.out.print("*\t");
               j--;
           }
          System.out.println();   //this is used to print in new  line


       i++;
      }
          */
    }
}