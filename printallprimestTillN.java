import java.util.*;

public class Main{
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);

        int low= scn.nextInt();
        int high= scn.nextInt();

        int n=low;

        while(n<=high){
            int lv = 2;
            int count = 0;


            while (lv*lv <=n) {
                if (n % lv == 0) {

                    count = count + 1;


                }

                lv = lv + 1;
            }
            if (count == 0) {
                System.out.println(n);
            }
            n=n+1;



        }
        
        
        
        //another method 
     /*
        
        Scanner scn = new Scanner(System.in);

        int low= scn.nextInt();
        int high= scn.nextInt();



        for(int i=low;i<=high;i++){
            int lv = 2;
            int count = 0;


            while (lv*lv <=i) {
                if (i% lv == 0) {

                    count = count + 1;


                }

                lv = lv + 1;
            }
            if (count == 0) {
                System.out.println(i);
            }




        }
        
        */
        
        
        
    