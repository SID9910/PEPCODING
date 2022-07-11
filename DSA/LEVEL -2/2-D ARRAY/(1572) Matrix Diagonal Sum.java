class Solution {
    public int diagonalSum(int[][] mat) {
    //sum karna hai
        int sum = 0;
        //isme matrix ki length nikal lo
        int n = mat.length;
        //hum primary diagonal ke sath sath secondary 
        //bhi add karenge kyuki columns change honge
        
        for(int i = 0; i < n; i++){
            sum += mat[i][i] + mat[i][n-i -1];
        }
        //and aaagr matrix even size ka ho kuch 
        //hatana nhi hai
        //aagr odd size ka matrix  ho bech ka hta denge eek kyuki vo primary main add ho chuka      //hai pehle
        
        if(n % 2 == 0){ 
            
            return sum; //for even cases
                      }else{
            return sum-=mat[n/2][n/2];//for odd cases
            
        }
    }
}