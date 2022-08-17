class Solution {
    public int maxSubArray(int[] nums) {
     //kadanes algorithm very imp
        int res =Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
            res =Math.max(res,sum);
        }
        return res;

    
       //brute force tle n2
//       int n = nums.length;
//         int maxSum = Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             int sum = nums[i];
//             if(sum>maxSum)
//                 maxSum = sum;
//             for(int j=i+1;j<n;j++){
//                 sum+=nums[j];
//                 if(sum>maxSum)
//                     maxSum = sum;
//             }
//         }
        
//         return maxSum;                

}
}