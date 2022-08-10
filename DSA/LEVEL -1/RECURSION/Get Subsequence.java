import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner scn  = new Scanner(System.in);
      String str = scn.next();
      ArrayList<String> g1 = gss(str);
      System.out.println(g1);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String roz = str.substring(1);
        ArrayList<String> subset =gss(roz);
        ArrayList<String> ans = new ArrayList<>();
        for(String val2:subset){
             ans.add(""+val2);
         }
         for(String val:subset){
             ans.add(ch+val);
         }
         

         return ans;




    }

}