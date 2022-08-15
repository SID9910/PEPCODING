class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> result = new ArrayList<>();
        long val =1;//1C0 =1
        for(int j=0;j<= rowIndex;j++){
            result.add((int)val);//vaqlue add karo pehle vali
            //aab saari aage ki value
            val =val*( rowIndex-j) /(j+1);
            
        }
        return result;
    }
}