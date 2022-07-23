class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int i=0;
        int j=0;
        while(i<nums.length){
            //for odd numbers
            if(nums[i]%2 ==1){
                i++;
            }else{ //for even numbers
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j] =temp;
                i++;
                j++;
            }
        }
        return nums;
    }
}