class Solution {
    public int minSetSize(int[] arr) {
        int n =arr.length;
        //tc =0(nlogn)
        //space=0(n)
        //element and frwequency
        Map<Integer,Integer> map = new HashMap<>();
        
        //sabki frquency daalo map main
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            
        }
        //aab frequency nikalo
        List<Integer> freq = new ArrayList<>(map.values());
        //descending order main sort karega ye
        Collections.sort(freq ,Collections.reverseOrder());
       
        //ab count lo jo remove honge
        
        int count =0;
        int totalElement =n;
        int i=0;
        //aab ghataenge elements ko
        while(totalElement>n/2){
            totalElement =totalElement-freq.get(i); //aab aaagr ye n/2 se baharbar hua samaja                                                        janege haat gay elements
            i++;
            count++;
        }
        return count;
    }
}