class Solution {
    //tc =0(n) 
    public List<Integer> partitionLabels(String s) {
       int[] map = new int[26];//hamare pass 26 character hote hai max
        Arrays.fill(map,-1); //start main -1 daal do sab main
        
        //ye  kaam karega jha per element last aaaya hai usse dalne main
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);//character nikalo
            map[ch-'a'] =i;//is se indexing ho jaegi 0 se
            
        }
        //two pointer bna do
        int start =0;
        int end =0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            end = Math.max(end,map[ch-'a']); //isme jha last end hoga uder max rakhega 
            //taaki break kar sakee
            if(i ==end){
                int length =end-start+1; //length jha per break hoga ye
                res.add(length);
                end =start =i+1;//agge se start karenge aab partision
                
            }
        }
        return res;//isme partision strings hai
        
    }
}