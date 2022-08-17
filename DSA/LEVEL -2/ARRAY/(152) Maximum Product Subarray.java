class Solution {
    //most imp 
    public int maxProduct(int[] nums) {
        int res =Integer.MIN_VALUE; //product isme aaega
        
        int prd =1;//product
        
        //prefix mtlb sidha calculate karo
        for(int i=0;i<nums.length;i++){
            prd =prd*nums[i];
            if(prd>res){
                res =prd;
            }
            //mtlb jaab zero aaega bich main sab start se karenge
            if(prd == 0){
                prd =1; //us point per bss 1 kardo product ki value taaki agle ko 1 mille
                        //usse pichla aapna
            }
        }
        
        
        prd =1;//product
        //suffix aab mtlb ulta calculate karo
        for(int i=nums.length-1;i>=0;i--){
            prd =prd*nums[i];
            if(prd>res){
                res =prd;
            }
            //aagar bich main zero mille then dubara aagle se start iski prodcut 1 kardo
             //taaki iske aage vale ko 1 mille aapna pichla
            if(prd ==0){
                prd=1;
            }
        }
        return res;//isme prefix se aagr suffix ka bda mille hoga multiple to baadi value hogi isme
        
    }
}