class Solution {
    public int[] twoSum(int[] nums, int target) {
        //hashMap banao
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