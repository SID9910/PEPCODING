class Solution {
    public int firstMissingPositive(int[] nums) {
        //space =o(1) and tc=o(n)
     int n =nums.length;//length nikal lo
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>n){ //aagr ye condition hui ki 1 to n taak aagr number  
                                         // nhi hua then n+1 daal denge uski jagah kyuki -ve                                              //number haat janege us se 
                nums[i]=n+1;
            }
        }
        //aabs kya karo absolute value lo and uss abs vale ke val-1 idx per jao and vo value 
        //udher rakh aao and nums[i] means aagr value udher +ve milli then -1 karo
        //aagr nhi milli then vaise he chod do
        for(int i=0;i<nums.length;i++){
            int val =Math.abs(nums[i]);
            if(val<=n){ //and jo values uper n+1 hui hai unhe nhi chadenge
                int idx =val-1;
               if(nums[idx]>0){
                nums[idx]=-1*nums[idx]; //value negative karenge
            }   
            }
          
        }
        //bss aab jha per pehli positive value milli uss index per jao and +1 karke return karo 
        //kyuki val eek daal higi index se
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;//aagr bye changes uper saare val -ve milli mtlb ye ki saari positive 
        //value present hai so length+1 return kardo agli val length se return mtlb
    }
}