class Solution {
    public int minMoves(int[] nums) {
        int min =Integer.MAX_VALUE;
        for(int val:nums){
            min =Math.min(min,val);
        }
        int count=0;
        for(int val2:nums){
         count+=val2-min;
        }
        return count;
    }
}