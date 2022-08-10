class Solution {
    public void moveZeroes(int[] nums) {
        //logic main main 905 inplace ka logic lagaya hai
        int i=0;
        int j=0;
        while(i<nums.length){
            //jaab number equal na ho zero ke then swap
            //nhi to aagr barabar hua zero ke bss i++ karo
            if(nums[i]!=0){
                 int temp = nums[i];
                nums[i] =nums[j];
                nums[j] =temp;
                i++;
                j++;
            }else{
               i++;
            }
        }
    }
}