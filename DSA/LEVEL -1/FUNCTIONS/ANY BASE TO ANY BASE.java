import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int ans=getValueInBase(n,sourceBase,destBase);
     System.out.println(ans);
   } 



 public static int getValueInBase(int n, int b,int j){
        int res=0;
        int multiplier=1;
        while(n!=0){
            int divident=n/10;
            int remainder=n%10;
            n=divident;
            res=res+remainder*multiplier;
            multiplier*=b;

        }
        int res2=0;
        int multiplier2=1;
        while(res!=0){
            int divident2=res/j;
            int remainder2=res%j;
            res=divident2;
            res2=res2+remainder2*multiplier2;
            multiplier2*=10;

        }

            return res2;
             }



  }