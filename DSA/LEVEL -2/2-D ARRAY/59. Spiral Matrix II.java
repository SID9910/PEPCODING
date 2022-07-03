class Solution {
    //similar to level-1 question spiral
    public int[][] generateMatrix(int n) {
     int[][] arr = new int[n][n];
        int frow=0;
        int fcolumn=0;
        int lrow =n-1;
        int lcolumn =n-1;
        int num=1;
        //bss while ki condition aalag
        while(fcolumn<=lcolumn && frow<=lrow){
            //from left to right
            for(int i=fcolumn ;i<=lcolumn;i++){
                arr[frow][i]=num++;
            
               
            }
            frow++;
            //right to down 
            for(int i=frow ;i<=lrow;i++){
                arr[i][lcolumn] =num++;
    
                
            }
            lcolumn--;
            //bottom to left
            for(int i=lcolumn;i>=fcolumn;i--){
             arr[lrow][i]=num++;
                 
                
            }
            lrow--;
            //bottom to top
             for(int i=lrow;i>=frow;i--){
              arr[i][fcolumn]=num++;
        
                
            }
            fcolumn++;
            
            
        }
        return arr;
        
        
    }
}

