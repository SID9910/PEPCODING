import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);//here na and d are number and base
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
   int res=0;//starting main result zero rakho
   int multiplier=1;//multiplier ko 1 krakho fhir 10 se update karte raho
   //multiplier=1 ka mtlb 10 ki powert zero

    while(n!=0){
        int divident=n/b;//pehle number ko base se devide karo jaise ki
        //base aaya manlo 8 to 8 ko divide karenge quotient aaega
        //lets assume n=634/8 to 79 store hoga fhir
        int remainder=n%b;// remainder aaega usko 10 se multiply karenge number create hoga
        // n=634%8=2
      n=divident;//aab n=79 hoga fhir aaise karte number update hoga
      //jaab n=0 hua loop khatam 
      res=res+remainder*multiplier;//result banta jaega remainer 10 se badta jaega 
      //number form ho jaega
      multiplier*=10;//multiplier badta jaega 
     
    }
    return res;



   }
  }