class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        
        for(int i=k ;i<nums.length;i++){
            int val =nums[i];//aaagr k se baadi value milli then pq se remove and nai vali add
            if(val>pq.peek()){
                pq.remove();
                pq.add(val);
            }
        }
        
        return pq.peek();//bss peek return kardo
    }
}
    
    
