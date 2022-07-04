class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
        
          if (matrix.length == 0) {
            return list;
        }
         int tne=matrix.length*matrix[0].length; //m*n
        int frow=0;
        int fcolumn=0;
        int lrow = matrix.length-1;
        int lcolumn =matrix[0].length - 1;
        int count =0;
        
        //bss while ki condition aalag
        //count ko isme return ki jagah hum for loop ki condition main lekar karenge
        while(count<matrix.length*matrix[0].length){
            //from left to right
            for(int i=fcolumn ;i<=lcolumn && count<tne;i++){
              
                list.add(matrix[frow][i]);
            
               count++;
                
            }
            frow++;
            //right to down 
            for(int i=frow ;i<=lrow && count<tne;i++){
              
                list.add(matrix[i][lcolumn] );
    
                count++;
               
            }
            lcolumn--;
            //bottom to left
            for(int i=lcolumn;i>=fcolumn && count<tne;i--){
             
                list.add(matrix[lrow][i]);
                 
                count++;
               
            }
            lrow--;
            //bottom to top
             for(int i=lrow;i>=frow && count<tne;i--){
             
                 list.add(matrix[i][fcolumn]);
        count++;
                
                
            }
            fcolumn++;
            
            
        }
        return list;
        
              
    }
}
