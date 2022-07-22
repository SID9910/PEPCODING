class Solution {
    public int maxChunksToSorted(int[] arr) {
        //values index ki range main he hogi baahar nhi hogi
       if(arr.length==0){
           return 0;
       }
        //count act as a chunks
        int count=0;
        int max =Integer.MIN_VALUE; 
        //basically max nikalo
        //and aagr max index ke baraber hua means 
        //udher taak sort hoga and count kar lenge ki vo
        //pehla barrier banega
        //then next aaise karenge
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(max ==i){
                count++;
            }
        }
        //akhri main count mtlb jitne chunks banege unka total
        return count;
    }
}