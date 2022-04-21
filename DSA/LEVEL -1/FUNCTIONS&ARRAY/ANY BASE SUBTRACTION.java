import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
   
   int borrow=0;
   int multiplier=1;
   int res=0;
   while(n2>0){ 
       int d1=n1%10;
       int d2=n2%10;
       int temp=d2-d1+borrow;//imp
       if(temp<0){
           res+=(temp+b)*multiplier;//imp
           borrow=-1;
       }
       else{
           res+=(temp*multiplier);
           borrow=0;  //imp
       }
       multiplier*=10;//10 se badate jao
       n1/=10;//numbr kaam karte jao
       n2/=10;
       
          }
          return res;
 }
  }