class Solution {
    //approach-1 space lega ye
//      public int partitionDisjoint(int[] nums) {
//          int[] left = new int[nums.length];
//          int[] right = new int[nums.length];
//          // left ke max
//          for(int i=0;i<nums.length;i++){
//              if(i==0){
//                  left[i] =nums[i];
//              }else{
//                  left[i] =Math.max(nums[i],left[i-1]);
//              }
//          }
//          //right ke max
//          for(int i =nums.length-1;i>=0; i--){
//              if(i==nums.length-1){
//                  right[i] =nums[i];
//              }else{
//                  right[i] =Math.min(nums[i],right[i+1]);
//              }
             
//          }
         
//          //comparision for partition jh lagega
//              int ans=-1;
//              for(int i=0;i<nums.length;i++){
//                  if(left[i]<=right[i+1]){
//                      ans =i+1;//isme left aajega
//                      break;
//                  }
            
//              }
             
//            return ans;  
//      }
    
    //optimised approach
    public int partitionDisjoint(int[] nums){
        int pi =0;//partition index
        int mtp =nums[0];//line k=jha khichni hai
        int mts =nums[0]; //maximum lenge iske compare ke ley
        for(int i=1;i<nums.length;i++){
            mts =Math.max(nums[i],mts);
            if(nums[i]<mtp){
                pi =i;
                mtp =mts;
            }
        }
        return pi+1;//partition line jaaegi
    }
    
    
    
    // public int partitionDisjoint(int[] nums) {
        //self lagaya tha but chala nhi 
//      int[] l = new int[nums.length-1];
//         int[] r = new int[nums.length-1];
//         int left =0;
//         int right =nums.length-1;
//         int i=0;
//         int j=0;
//         while(left<right){
//             if(left<=right){
                 
//                 l[i] =nums[left];
//                i++;
//                 left++;
//             }else{
//                 r[j] =nums[left];
//                 r[j+1] =nums[right];
//                 right--;
//                 j++;
                
//             }
//         }
//         return l.length-1;
    // }
}