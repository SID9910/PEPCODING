import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }

 public static int getProduct(int b, int n1, int n2){
     int ans = 0;
     int power = 1;
     
     while(n2 != 0){//YE loop jaab taak chalega jaab taak num zero na ho jay
        //jaise n1=234 and n2=34 n2 zero hoga jaab taab taak chalega
         int l2 = n2 % 10;//n2 ki eek ko aaalag kar kar multiply karega 
         //then dubara jaab loop ghum kar aaega taab dubar aalag kar kar multiply karega
         n2 /= 10;//number update hoga
         
         int eeknumkomultiply = gpwsd(b, n1, l2);//isme n1=234 aaega and l2=4 pass aaega
                                             //and multiply hoga pehle number se 
        //  ans = ans +  (pwsd * power);
        ans = getSum(b, ans, eeknumkomultiply * power); //eek jaab jaega eeknumko multiply *1 se hoga and sum main store hoga
                                                      //and intial ans=0 pass hoga and store aaise hoga ans =0+eeknum*1
                                                      //then dubara jaab loop ghumega then ans=ans+eeknum*10
                                                      //ans store hoga and return sum karega numbers ka 
         power *= 10;//then power update hogi
     }
     return ans;
 }
 
 public static int gpwsd(int b, int n1, int d2){//eek number ko multiply ka code
     int ans = 0;
     int power = 1;
     int carry = 0;
     
     while(n1 != 0 || carry != 0){
         int l1 = n1 % 10;
         n1 /= 10;
         
         int product = l1 * d2 + carry;
         int q = product / b;
         int r = product % b;
         
         ans += (r * power);
         carry = q;
         power *= 10;
     }
     
     return ans;
 }
 
  public static int getSum(int b, int n1, int n2){ //two numbers ka sum karne ka code 
       int ans = 0;
       int carry = 0;
       int power = 1;
       
       while(n1 > 0 || n2 > 0 || carry > 0){
           int l1 = n1 % 10;
           int l2 = n2 % 10;
           n1 /= 10;
           n2 /= 10;
           
           int sum = l1 + l2 + carry;
           int q = sum / b;
           int r = sum % b;
           
           ans += (r * power);
           carry = q;
           power *= 10;
       }
       
       return ans;
   }

}