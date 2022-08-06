import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> rud = gss(str);
        System.out.println(rud);
    }

    public static ArrayList<String> gss(String str) {
    if(str.length()==0){
        ArrayList<String> base = new ArrayList<>();
        base.add("");
        return base;
    }
    char sh =str.charAt(0);
    String roz = str.substring(1);
    ArrayList<String> forward = gss(roz);
    ArrayList<String> mans = new ArrayList<>();
    for(String val:forward){
        mans.add(val);
    } 
    for(String val:forward){
        mans.add(sh+val);
    } 

    return mans;
    }

}