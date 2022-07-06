class Solution {
    //amazon question
    public int missingNumber(int[] nums) {
        int sum=0;
        sum = nums.length*(nums.length+1)/2;

int total = 0;

 for(int i=0; i<nums.length; i++){

total = sum-nums[i];
     sum=total;
    }
        return total;
}
    }