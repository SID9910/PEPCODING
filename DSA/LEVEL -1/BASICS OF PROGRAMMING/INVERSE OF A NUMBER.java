import java.util.*;

public class Main{

public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();//input
    
        // aagr six digits lenge to 1-6 he lenge .7, 8 nhi
        //aagr 8 digits lenge to 1-8 hoge.
        int fv=0;//face value
        int pv=1;//place value
        int inv=0;//inverse
        while(n!=0){
            fv=n%10;//last number store hota jaega and then place value se exchange kar denge 
     //inverse place value and inverse face value 
            int ipv=fv; //we are reversing place value with face value
            int ifv=pv; //because we want place value ki jagah face value and face value ki jagah place value
             inv=inv+ifv*(int)(Math.pow(10,ipv-1)); //this is used to buid a  number fromula facevalueX10power(placevalue-1)
                    

         n=n/10;//number ghata rahe hai
            pv=pv+1;//place value bda rahe hai
        }
        System.out.println(inv);
        
        //another method jisme maths ke bina bhi kae skte hai use 
         //Scanner scn = new Scanner(System.in);
        //int n= scn.nextInt();//input
        //int fv=0;//face value
       // int pv=1;//place value
        //int inv=0;//inverse
        //while(n!=0){
      //      fv=n%10;//last number store hota jaega and then place value se exchange kar denge
     //inverse place value and inverse face value
        //    int ipv=fv; //we are reversing place value with face value
          //  int ifv=pv; //because we want place value ki jagah face value and face value ki jagah place value
          //this is used to buid a  number fromula facevalueX10power(placevalue-1)
         //power kaise banate hai uska logic niche vala hai
            //int apna_pow=1;
         //int lv=1;
         //while(lv<=(ipv-1)){
           //  apna_pow=apna_pow*10;
             //lv=lv+1;
        // }
         //inv=inv+ifv*apna_pow;   //apna_pow ye power vala function hai iski jagah (math.(int)(pow(10,ipv-1))bhi use kar sakte the 
           // n=n/10;//number ghata rahe hai
            //pv=pv+1;//place value bda rahe hai
        //}
        //System.out.println(inv);

        
        
        
        
        
        
        
        
        
 
 }
}