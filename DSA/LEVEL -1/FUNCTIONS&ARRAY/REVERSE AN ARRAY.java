import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }


//swap function array pass karna jaruri hai kyoki ye heap ka change hai
  public static void swap(int[]arr,int left,int right){
      int temp=arr[left];
      arr[left]=arr[right];
      arr[right]=temp;
  }

//reverse an array ka function
  public static void reverse(int[] a){
    int left=0;  //left pointer starting index se start hoga
    int right=a.length-1;//right pointer last index se start hoga
   
   
   while(left<=right){  //ye condition ye hai ki aaagr jaise he right index se left index
                         // bda hua uss he time stop ho jaega or equal hua taab bhi
        swap(a,left,right);//swap kar dega left index ki value ko right index ki value se
   
        left++;//left index bdao
        right--;//right index ko gatao
    }



  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
 }

}
