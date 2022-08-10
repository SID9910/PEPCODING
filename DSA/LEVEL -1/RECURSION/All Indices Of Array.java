import java.io.*;
import java.util.*;

public class Main {
//main main jo likha hai pehle se likha hua aaya hai
//so aapmne hisab se coding ke time likhna
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

//ye karega kaam 
//logic aache se notes main explain kara hua hai
//or u can else summit sir video
    public static int[] allIndices(int[] arr, int target, int idx, int count) {
        //base condition
        if(idx==arr.length){
            return new int[count];
        }

        //faith
        if(arr[idx]==target){
            int[]iarr=allIndices(arr,target,idx+1,count+1);
            iarr[count]=idx;
            return iarr; 
        }
        else{
            //ye dubara iarr ko declare kara hai iska mtlb
            //ye nhi ki nya array hai else main return karne 
            //ke ley declare kara hai same array he hai 
            int[]iarr=allIndices(arr,target,idx+1,count);
            return iarr;
                    }
        


    }

} 