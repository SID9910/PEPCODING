//brute force
//class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i=0;i<nums.length ;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]+nums[j]==target){
//                     return new int[]{i+1,j+1}; //question main return index+1 karna hai isley
//                                                //1 index per element dalenge
//                 }
//             }
            
//         }
//         return null;
//     }
    // }

    //optimum solution
    class Solution {
        public int[] twoSum(int[] nums,int target){
            int left=0,right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                
                if(sum==target){
                    return new int[]{left+1,right+1};//question main return index+1 karna hai                                                                                     
                                                    //1 index per element dalenge
                }
                if(sum<target){
                    left++;
                }
                else{
                    right--;
                }      
                }
                return null;
            }
        }
    