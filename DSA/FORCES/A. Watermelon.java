import java.util.Scanner;
public class Watermelon 
{
    public static void main(String[] args) 
    {
        
        Scanner input = new Scanner(System.in);
        int w=input.nextInt();
        //even 
        if(w%2==0){
            //number 2 nhi ho sakta kyuki iska division 1 1 hota hai jo ki odd hota hai
            if(w==2){
            System.out.println("NO"); 
            }
            
        else{
System.out.println("YES");
        }
            
        }
        //odd
        else
            System.out.println("NO");
    }
}