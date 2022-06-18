import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();//base
      int n1 = scn.nextInt();//number 1
      int n2 = scn.nextInt();//number 2
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       int res=0;//result intialised to zero
       int mul=1;//multiplier
       int carry=0;//initial main carry zero rakhenge
       while(carry>0||n1>0||n2>0){//jaab tinno conditions false honge taab loop rukega
                                 //carry ,number1,nunber2 zero hote he ruk jaega
           int d1=n1%10;//last digit ke ley
           int d2=n2%10;
           
          int  temp=carry+d1+d2;//eek number main store karenge
           int quotient=temp/b;//store number ko divide karenge  gieven base se
           int remainder=temp%b;//store kare number ka remainder lenge
       carry=quotient;//carry aage forward hota to quotient ke barabar karenge
       res+=remainder*mul;//remainder ko multiply karenge 10 seand baadate janege 
       n1=n1/10;//number gtate jaenge
       n2=n2/10;
       mul*=10;//multiplier ko 10 se badate jaenge

       }
       return res;
   }
  }