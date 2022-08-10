import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
   Scanner scn = new Scanner(System.in);
   String str = scn.next();
   ArrayList<String> ans = getKPC(str);
   System.out.println(ans);
    }

   static String[] codes ={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
       
public static ArrayList<String> getKPC(String str) {
if(str.length()==0){
    ArrayList<String> base = new ArrayList<>();
    base.add("");
    return base;
}    
    char tm = str.charAt(0);
    String roz =str.substring(1);
    ArrayList<String> keys = getKPC(roz);
    ArrayList<String> ans = new ArrayList<>();

    String codeforce = codes[tm-'0']; 
    for(int i=0;i<codeforce.length();i++){
        char ch = codeforce.charAt(i);
        for(String val:keys){
            ans.add(ch+val);
        }
    }
 return ans;

    }
   

}