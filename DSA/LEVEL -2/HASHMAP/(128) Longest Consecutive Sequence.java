class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int val:nums){
            map.put(val,true);
        }
        for(int val:nums){
            if(map.containsKey(val-1)==true){
                map.put(val,false);
            }
        }
          int maxst =0;
            int mlen =0;
        for(int val:nums){
          
            if(map.get(val)==true){
            int temp =val;
            int tlen =1;
            
            
            
                while(map.containsKey(temp+tlen)==true){
                    tlen++;
                }
                if(tlen>mlen){
                    maxst=temp;
                    mlen =tlen;
                }
            }
        }
            return mlen;
        }
   
    }


