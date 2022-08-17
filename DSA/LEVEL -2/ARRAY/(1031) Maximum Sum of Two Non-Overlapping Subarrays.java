class Solution {
    //code difficult hai thoda
    //dp ke baad dubara aaunga iss sawal per
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
     int max1 =getMax(nums,firstLen,secondLen);//kya pta pehla fhir dusra length se aay   
      int max2 = getMax(nums,secondLen,firstLen);//kya pta dusri length pehle fhir first length 
      //dono  main jiska ans max hoga vo lenge
        return Math.max(max1,max2);
    }

    //ye kaam karega main
    public int getMax(int[] nums , int first , int second){
       
        //left bharlo
        int[] left = new int[nums.length];//left array main daalo
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==first-1){
                left[i] =sum;
            }else if(i>=first){
                sum -=nums[i-first];
                left[i] =Math.max(sum,left[i-1]);
            }
        }
        
        
        //right bharlo
        int[] right = new int[nums.length];
        sum =0;
         for(int i=nums.length-1;i>=0;i--){
            sum+=nums[i];
            if(i==nums.length-second){
                right[i] =sum;
            }else if(i<nums.length -second){
                sum -=nums[i+second];
                right[i] =Math.max(sum,right[i+1]);
            }
        }
        
        
        //comparing right and left
        int max =Integer.MIN_VALUE;
        for(int i=first-1;i<nums.length-second;i++){
            max =Math.max(max,left[i]+right[i+1]);
        }
        return max;
       
        
    }
}