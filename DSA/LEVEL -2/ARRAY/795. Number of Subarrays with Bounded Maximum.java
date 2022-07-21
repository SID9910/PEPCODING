class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start =-1; //initially start ko -1 index per rakho
        int end =-1;//initially end ko bhi -1 per rakho
                   //isme bss end ko move karenge
        int res =0;
        for(int i=0;i<nums.length;i++){
            //mtlb aagr range main ho to
            if(nums[i]>= left && nums[i]<=right){
                end =i; //bss end ko move karo i per
            }else if(nums[i] >right){//agr range se bahar ko uper
                start=end=i;//usko us index per rakh denge
            }else{
                //range se lesser ho
                //then kuch nhi karenge
            }
            res+=end-start; //bss index daalo vo and akri main total return kardo
            //jitne subaarays baane hai
        }
        return res;
    }
}