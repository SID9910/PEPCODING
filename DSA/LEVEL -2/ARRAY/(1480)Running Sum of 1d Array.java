class Solution {
    public int[] runningSum(int[] nums) {
    //sum store karde jao left ka
        int left=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                nums[left]=nums[i];
            }else{
                nums[left] =nums[i]+nums[left-1];
            }
            left++;
        }
        return nums;
    }
}