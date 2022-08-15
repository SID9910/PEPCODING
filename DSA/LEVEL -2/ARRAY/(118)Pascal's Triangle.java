class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();//isme store karenge
        
        //bahar vala loop ha row ke ley chalega
        //pascal triangle pehle karna 
        //bss same logic bss eek arraylsit main store karke dusri arraylist main daal dena
        for(int k=0;k<numRows;k++){
            List<Integer> row =  new ArrayList<Integer>();
            int val =1;
            for(int j=0;j<=k;j++){
                row.add(val);
                val =val*(k-j) /(j+1);
            }
            result.add(row);
        }
        return result;
    }
}