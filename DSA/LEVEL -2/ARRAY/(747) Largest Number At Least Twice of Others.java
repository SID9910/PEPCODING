class Solution {
    public int dominantIndex(int[] nums) {
     int idx1 =-1;
        int idx2 =-1;
        //index ki help se max and second max index nikal lo
        for(int i=0;i<nums.length;i++){
            //starting main idx =-1 hoga so use handle ke ley or lga do
            if(idx1 ==-1 || nums[i]>=nums[idx1]){
                   //aaise karna
                idx2=idx1;//pehle second largest
            idx1=i;//aab largest
            }else if(idx2 == -1 ||nums[i]>=nums[idx2]){//second largest ke ley
                idx2=i;
            }
            
            
        }
        //aab check karo atleast largest =2*smallest ho aagr hua mtlb uske pehle ke saare bhi 
     //valid honge
        if(nums[idx1] >= 2*nums[idx2]){
            return idx1; //bss index return kardo
        }else{
            return -1;//aagr nhi mille to -1 return
        }
        
        
    }
}