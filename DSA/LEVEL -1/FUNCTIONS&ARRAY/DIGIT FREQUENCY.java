import java.util.*;


//digits frequency
public class Main {

    public static int frequency(int n,int d){
        int freq=0;
        while(n!=0){
            int digit =n%10;
                            
            if(digit==d){
                freq++;
            }
            n=n/10;
        }
        return freq;
    }
    public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int d= scn.nextInt();
    int ans=frequency(n,d);
        System.out.println(ans);


    }
}