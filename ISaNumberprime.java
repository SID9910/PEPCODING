import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      
        Scanner scn = new Scanner(System.in);
        int t =scn.nextInt();
        int lv_2=1;
        while(lv_2<=t) {

            int n = scn.nextInt();
            int lv = 2;
            int count = 0;


            while (lv*lv <= n) {
                if (n % lv == 0) {

                    count = count + 1;
                    break;
                    

                }

                lv = lv + 1;
            }
            if (count == 0) {
                System.out.println("prime ");
            } else {
                System.out.println("not prime ");
            }
         lv_2=lv_2+1;

        }


  
   }
  }