import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
   Scanner scn=new Scanner(System.in);
    int n1=scn.nextInt();
    int []arr1=new int[n1];
    for(int i=0;i<n1;i++){               //input lena arr1 main
        arr1[i]=scn.nextInt();

    }


     int n2=scn.nextInt();
    int []arr2=new int[n2];
    for(int i=0;i<n2;i++){
        arr2[i]=scn.nextInt();  //input lena arr2 main
        
    }
    int[] res=new int[Math.max(n1,n2)+1];   //resultant ko dono number ka max +1 hoga kyuki carry last main bacha to bhi eek index badaega

    int borrow=0;
    int i1=n1-1,i2=n2-1,i3=res.length-1; //last index se store karenge haam
    
    while(i3>=0){  //i3 resultant ka index hota hai jaise he index zero se kaam hua loop stop  
        
        int d1=(i1>=0)?arr1[i1]:0; //ye condition hai ki aaagr index i1 ka -ve hua to to d1(digit1) main zero store karenge 
                                  //aagr index i1 greater than zero hoga to continue hoga number
        int d2=(i2>=0)?arr2[i2]:0;//same as d1 
        int temp=d2-d1+borrow;  //ye addition ka logic hai

        if(temp<0){
            res[i3]=temp+10;        //bss itna logic aalag hai sum vale se baaki pura same hai
            borrow=-1;             //aaagr temp -ve hua to to borrow lena padega 
                                  //borrow ki value -1 kardo aagli bar ke ley
        }
        else{
            res[i3]=temp; //aaagr temp +ve rha to mtlb koi borrow nhi lea 
                             
            borrow=0;    //to borrow ko same rakho zero
        }
    
    
    
        
        i1--;i2--;i3--;  //tino index ko kaam karte jaenge

    }

    //ye logic hai starting main resultant main zero hue to htane ka logic

    int idx=0;
    while(res[idx]==0){
        idx++;               //idx ++hota jaega

    }
    
    //jaise he uper  starting ke zero khatam hokar idx update ho jaega uske baad starting he khatam index se karenge

    
     //intial idx jo update hokar aaaega uper se udher  se he karenge start .
     //khatam ho jaenge uper ke starting ke zero uper vale index ke logic se
     for(int i=idx;i<res.length;i++){
        System.out.println(res[i]);
    }




 }

}