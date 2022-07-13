//google
class Solution {
    public int arrayPairSum(int[] nums) {
      //basically pehle sort karlo array ko 
        //fhir uska second index ko add karte jao
        //because saare minimum second index per honge
        //array[1,,4,3,2]
        //sortarray[1,2,3,4]
        //sum[i]=1+3=4 //i=i+2
        //kardo sort main mill jaega
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i=i+2){
            sum+=nums[i];
        }
           return sum;
       } 
    }
