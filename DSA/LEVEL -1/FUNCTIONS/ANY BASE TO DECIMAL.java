import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  //ye code bilkul same hai decimal to base ki tarAH BSS THODA AALAG HAI 
   public static int getValueIndecimal(int n, int b){
      int res=0;
      int mul=1;
      while(n!=0){
          int devident=n/10;//any decimal to base main hamesha 10 se he divide karna hoga 
          int remainder=n%10;//ye bhi 10 se he devide hoga 
          n=devident;
          res=res+remainder*mul;




          mul*=b;// given base se multiply hoga
      }

   return res;

   }

  }