class Solution {
    public int minMoves2(int[] nums) {
        //basically sort kar lo us se aasani hogi
       Arrays.sort(nums);
        int left =0;
        int right =nums.length-1;
        int res =0;
        //bss right and left -minus karte jao
        while(left<right){
            res+=nums[right]-nums[left];
            left++;
            right--;
        }
        return res;//total operations 
    }
}