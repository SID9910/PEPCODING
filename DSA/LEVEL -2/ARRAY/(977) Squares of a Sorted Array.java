class Solution {
    //brute force
    // public int[] sortedSquares(int[] nums) {
    //     for(int i=0;i<nums.length;i++){
    //         nums[i]=nums[i]*nums[i];
    //     }
    //     Arrays.sort(nums);
    //     return nums;
    // }
    
    //optimised approach tc=0(n)
     public int[] sortedSquares(int[] nums) {
     int[] res = new int[nums.length];
         int left =0;
         int right =nums.length-1;
         int k =nums.length-1; //last se store karna chalaenge
         //while main left<right bhi kar sakte ho
         while(k>=0 ){
             if(Math.abs(nums[left])>Math.abs(nums[right])){ //kya karo absolute nikal lo 
                                                             //like -4 =4 so easy compare karo 
                                                             //us se aasan ho jaega and store                                                               to
                 res[k] =nums[left]*nums[left];      //last index per daalo value
                                                     //jiski baadi ho
                 left++;
             }else{
                 res[k] =nums[right]*nums[right];     
                 right--;
             }
             k--;   //index kaam karo
         }
         return res;
    }
}