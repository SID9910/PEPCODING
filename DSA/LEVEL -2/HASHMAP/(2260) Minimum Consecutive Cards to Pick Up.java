class Solution {
    public int minimumCardPickup(int[] cards) {
     HashMap<Integer ,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;//minimum he nikalenge
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                min = Math.min(min , i-map.get(cards[i])); // jha se pehla milla or akri taak gya uska distance nikal lo bss and akri main +1 karke return kyuki index 0 se start hotr hai
            }
            map.put(cards[i] ,i);
        }
        //aagr mtlb minimum milla nhi ki koi consecutive nhi mila taab
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min+1;
    }
}

