class Solution {
    public int majorityElement(int[] nums) {
        //brute force
        //hashmap approach tc =o(n) spacd =o(n)
        //bss dhundo sabki frequency and return maximum frequency
//    HashMap<Integer, Integer> hm =new HashMap<>();        
//         for(int i=0;i<nums.length;i++){
//             if(hm.containsKey(nums[i]) == true){
//                 int old =hm.get(nums[i]);
//                 int neww =old+1;
//                 hm.put(nums[i],neww);
//             }else{
//                 hm.put(nums[i],1);
//             }
//             }
//         int max =nums[0];
//         for(int keys :hm.keySet()){
//             if(hm.get(keys)>hm.get(max)){
//                 max =keys;
//             }
            
//         }
//         return max;
        
        
        //optimised approach
         // Boyer–Moore majority vote algorithm
        //tc =o(n) space =o(1)
        int count =0;//shuruwat main count zero rakho
        int me =0; //or u can use Integer me =null; //here e store maximum element
        for(int i=0;i<nums.length;i++){
            //mtlb aagr jaise kahi bich main count zero hua 
            //taab hum usme alga element lekar count 1 kar kar chalu karenge
            //taaki vo to max element nhi hai
            if(count==0){ 
                me =nums[i];
                count =1;
                
            }else if(me == nums[i]){ //aagr me barabar ushi element ke then bss count bdao
                count++;
            }else{
                count--; //aagr me ke barabar aage emelent nhi hue then hum count kum karte                        jaenge
            }
        }
        return me; //isme max element return kardo
    }
}