import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      ArrayList<String> stairs =getStairPaths(n);
      System.out.println(stairs);
    }

    public static ArrayList<String> getStairPaths(int n) {
        
if(n==0){
    ArrayList<String> base = new ArrayList<>();
    base.add("");
    return base;
}
if(n<0){
    return new ArrayList<String>();
}


       ArrayList<String> path1 = getStairPaths(n-1);
       ArrayList<String> path2 = getStairPaths(n-2);
       ArrayList<String> path3 = getStairPaths(n-3);
        ArrayList<String> allpaths = new ArrayList<>();
       for(String val:path1){
           allpaths.add(1+val);

       }
 for(String val:path2){
           allpaths.add(2+val);

       }
        for(String val:path3){
           allpaths.add(3+val);

       }

      return allpaths;
    }

}