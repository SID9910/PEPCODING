import java.io.*;
import java.util.*;

public class Main {
     
   //level-1 main eek he question hai arraylist ka 

//ye prime number ka logic hai
    public static boolean isPrime(int val)
    {
        for(int i = 2; i * i <= val; i++)
        {
            if(val % i == 0) 
            return false;
        }
        return true;
    }
    
    //array list main aagar prime hua to delete kardo
	public static void solution(ArrayList<Integer> al){
		// Loop from right to left: to avoid skipping elements
    for(int idx = 0; idx<al.size(); idx++) //ye loop traverse karega
		{
		    if(isPrime(al.get(idx))==true) //aaagr prime hoga to delete element
		    { al.remove(idx);//remove function ye delete kar dega element or
                             //eek index pehle per leke aajaega element ko
                             //us se bachne ke ley idx-- kar dea taaki fhir uss he 
                             //index se chale jha per element ko 
                    idx--;//ye element jo skip ho jata usse uss index per lakar dubara prime check 
                  //karenge check
             }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
        //tostring()method is se [] ye laag jaenge output main
		System.out.println(al);
	}

}