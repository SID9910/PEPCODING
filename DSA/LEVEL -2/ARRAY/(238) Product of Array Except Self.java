class Solution {
    public int[] productExceptSelf(int[] nums) {
        //left main khud ko chod kar saare left ka multiply store
        //kar lenge
        int[] left = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                left[i]=1;
                
            }else{
                left[i]=left[i-1]*nums[i-1];//isme left store ho jaega
            }
        }
        //bss last se right ke store karte jao
        int right =1;
        for(int i=nums.length-2;i>=0;i--){
            right =right*nums[i+1];//bss multiply karte jao
            left[i] =left[i]*right;
        }
        return left;
    }
}