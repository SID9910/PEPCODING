class Solution {
    
    //brute force =O(n2)
//       public int[] twoSum(int[] nums, int target){
//           for(int i=0;i<nums.length;i++){
//               for(int j=i+1; j<nums.length;j++){
//                   if(nums[i]+nums[j] ==target){
//                       return new int[]{i,j};
//                   }
//               }
//           }
//           return null;
//       }
    
    
    
    //optimised approach
    
    public int[] twoSum(int[] nums, int target) {
        //eek bar two pointer technique bhi dekhna
        
        
        //hashMap banao
        //tc-0(n) //space-0(n)
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int compliment =target-nums[i];
            if(map.containsKey(compliment)){ //aaagr compliment milla then uska get karke index                                             and array ki us value ka index return kardo
                
                return new int[]{map.get(compliment),i};
            }
            //aaagr compliment na mille to vo index ki value sath he sath
            // index add kardo
            map.put(nums[i],i);
        }
         return null;
    }
}