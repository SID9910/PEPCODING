class Solution {
    //thoda similar hai 769 se and also valid in 769 as code//practice again
    //bss idher jaruri nhi hai value index ke barbar ho baadi bhi ho sakti hai
    public int maxChunksToSorted(int[] arr) {
        //isme hum last se minimum nikal kar store karenge
        int[] minarray =new int[arr.length];
        minarray[arr.length-1] =arr[arr.length-1]; //last main last he daalo uska comparision            nhi
        
        //eek index kum karo or minimum store karte jao
        for(int i=arr.length-2;i>=0;i--){
            minarray[i]=Math.min(arr[i] ,minarray[i+1]); //basically last se compare kar rahe                                                              hai uske pehle se 
        }
        //saare minimum store kar ley
        //minarray main
        //bss fhir normal compare
        //and imp check karenge left ka max <=right min se chota chots hua
        //samaj jaenge ki chunk mill gya
        //ki left ke max mill chuka hai uske aage baade hai or r min unme sabse chota hai
        //so ki break aaega udher
        
        int result =0;//store chunks
        int max =Integer.MIN_VALUE;
        //last index se eek kum chalao kyuli array ka second last compare niche vale ke eek aage se hoga so automatically compare ho jaega
        //so usko compare nhi karna
        for(int i=0;i<arr.length-1;i++)
        {
            max =Math.max(max,arr[i]);
            
            //minarray[i+1] se chalenge kyuki aage ka compare kare
            if(max<=minarray[i+1]){
                result++;
            }
        }
        
        return result+1;//because last main chunk nhi lga paenge so pehle he eek add kardo
    }
}