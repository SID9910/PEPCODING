import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int rows = scn.nextInt();
int col =scn.nextInt();



ArrayList<String> path = getMazePaths(0,0,rows-1,col-1);
System.out.println(path);

    }

    
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
if(sr>dr || sc>dc){
    return new ArrayList<String>();
}

    if(sr==dr && sc==dc){
        ArrayList<String> base = new ArrayList<>();
        base.add("");
        return base;
    }

        ArrayList<String> horizontalpath =getMazePaths(sr,sc+1,dr,dc);
        ArrayList<String> vertialpath =getMazePaths(sr+1,sc,dr,dc);

        ArrayList<String> paths = new ArrayList<>();

        for(String val:horizontalpath){
            paths.add('h'+val);
        } 

        for(String val:vertialpath){
            paths.add('v'+val);
        } 

        return paths;



    }

}