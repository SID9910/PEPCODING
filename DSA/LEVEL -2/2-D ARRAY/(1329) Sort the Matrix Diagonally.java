class Solution {
    public int[][] diagonalSort(int[][] mat) {
        //
       HashMap<Integer ,PriorityQueue<Integer>> map = new HashMap<>();
        int m = mat.length;//row
        int n =mat[0].length; //column\
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap =i-j;
                if(map.containsKey(gap)==false){//aaagr gap nhi ho then eek pq banado nai
                    map.put(gap, new PriorityQueue<>());
                }
                map.get(gap).add(mat[i][j]);//aagr map main gap  hai then put kardo value vo
                                            //and value pq main chali jaegi uss particular gap                                                //main
            }
        }
        //aab bss values uper sort ho gai hai pq ki vajah se so bss particular gap per vo value         //daal do.in sorted form
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap =i-j;
                mat[i][j]=map.get(gap).remove(); //partically gap ke according value aaejaegi 
                                                //pq main se jo map main hai
            }
        }
        return mat;
    }
}