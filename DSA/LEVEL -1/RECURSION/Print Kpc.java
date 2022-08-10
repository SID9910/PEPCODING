import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner scn = new Scanner(System.in);
     String st =scn.next();
     printKPC(st,"");
    }
   static String[] code ={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printKPC(String str, String asf) {

if(str.length()==0){
    System.out.println(asf);
    return;
}   

   char ch =str.charAt(0);
   String roz = str.substring(1);
String codeforce =code[ch-'0'];
for(int i=0;i<codeforce.length();i++){
    char ch2 =codeforce.charAt(i);
printKPC(roz,asf+ch2);
}

   
        
    


    }

}