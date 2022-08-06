class Solution {
    //is question main galti hai ki return hum count kar rahe hai 
    //and array nums[count] ki jarurat kyu hai fhir
    public int removeElement(int[] nums, int val) {
          int count = 0;    
   for(int i = 0; i < nums.length; i++){
       
       if(nums[i] != val){
           nums[count] = nums[i];
           count++;
       }
   }
   
   return count; //count return karo
    }
}